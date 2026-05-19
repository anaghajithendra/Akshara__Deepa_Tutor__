package com.aksharadeepa.tutor

import android.content.Context
import com.google.ai.client.generativeai.GenerativeModel
import java.time.LocalDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.json.JSONObject

class TutorRepository(
    private val dao: TutorDao,
    private val context: Context
) {
    val chapters: Flow<List<Chapter>> = dao.observeChapters()
    val attempts: Flow<List<QuizAttempt>> = dao.observeAttempts()
    val streaks: Flow<List<DailyStreak>> = dao.observeStreaks()

    suspend fun seedIfNeeded() {
        if (dao.chapterCount() > 0) return
        val bank = loadQuestionBank()
        val chapters = bank.chapters
        val ids = dao.insertChapters(chapters)
        val chapterIds = chapters.mapIndexed { index, chapter ->
            "${chapter.subject}|${chapter.chapterNumber}" to ids[index]
        }.toMap()
        val questions = bank.questions.mapNotNull { seed ->
            val chapterId = chapterIds[seed.chapterKey] ?: return@mapNotNull null
            Question(
                chapterId = chapterId,
                questionText = seed.questionText,
                optionA = seed.optionA,
                optionB = seed.optionB,
                optionC = seed.optionC,
                optionD = seed.optionD,
                correctAnswer = seed.correctAnswer,
                explanation = seed.explanation,
                conceptTag = seed.conceptTag
            )
        }
        dao.insertQuestions(questions)
    }

    fun chaptersFor(subject: String): Flow<List<Chapter>> = dao.observeChaptersBySubject(subject)
    suspend fun chapter(id: Long): Chapter? = dao.getChapter(id)
    suspend fun questions(chapterId: Long): List<Question> = dao.getQuestions(chapterId)
    suspend fun attempt(id: Long): QuizAttempt? = dao.getAttempt(id)

    suspend fun submitQuiz(chapterId: Long, answers: Map<Long, String>): Long {
        val questions = dao.getQuestions(chapterId)
        val wrongIds = questions.filter { answers[it.id] != it.correctAnswer }.map { it.id }
        val score = questions.size - wrongIds.size
        val percentage = if (questions.isEmpty()) 0f else (score * 100f / questions.size)
        val attemptId = dao.insertAttempt(
            QuizAttempt(
                chapterId = chapterId,
                score = score,
                totalQuestions = questions.size,
                percentage = percentage,
                wrongQuestionIds = wrongIds
            )
        )
        val currentBest = dao.getChapter(chapterId)?.bestScore ?: 0
        val best = maxOf(currentBest, percentage.toInt())
        dao.updateChapterProgress(chapterId, best, masteryFor(best), System.currentTimeMillis())
        val today = LocalDate.now().toString()
        val existingStreak = dao.getStreak(today)
        dao.upsertStreak(
            DailyStreak(
                date = today,
                quizzesCompleted = (existingStreak?.quizzesCompleted ?: 0) + 1,
                minutesStudied = (existingStreak?.minutesStudied ?: 0) + 15
            )
        )
        return attemptId
    }

    private fun masteryFor(score: Int): MasteryLevel = when {
        score >= 70 -> MasteryLevel.GREEN
        score >= 40 -> MasteryLevel.AMBER
        else -> MasteryLevel.RED
    }

    private fun loadQuestionBank(): SeedBank {
        val json = context.assets.open("question_bank.json").bufferedReader().use { it.readText() }
        val root = JSONObject(json)
        val chaptersJson = root.getJSONArray("chapters")
        val questionsJson = root.getJSONArray("questions")
        val chapters = (0 until chaptersJson.length()).map { index ->
            val item = chaptersJson.getJSONObject(index)
            val concepts = item.getJSONArray("keyConcepts")
            Chapter(
                chapterNumber = item.getInt("chapterNumber"),
                chapterName = item.getString("chapterName"),
                subject = item.getString("subject"),
                summary = item.getString("summary"),
                keyConcepts = (0 until concepts.length()).map { concepts.getString(it) },
                totalQuestions = 5
            )
        }
        val questions = (0 until questionsJson.length()).map { index ->
            val item = questionsJson.getJSONObject(index)
            val options = item.getJSONObject("options")
            SeedQuestion(
                chapterKey = item.getString("chapterKey"),
                questionText = item.getString("questionText"),
                optionA = options.getString("A"),
                optionB = options.getString("B"),
                optionC = options.getString("C"),
                optionD = options.getString("D"),
                correctAnswer = item.getString("correctAnswer"),
                explanation = item.getString("explanation"),
                conceptTag = item.getString("conceptTag")
            )
        }
        return SeedBank(chapters, questions)
    }
}

class HintGenerator(private val apiKey: String) {
    suspend fun hint(question: Question): String = withContext(Dispatchers.IO) {
        if (apiKey.isBlank()) {
            "Focus on the concept of ${question.conceptTag.lowercase()} and compare it with each option. Remove choices that do not match the rule before choosing again."
        } else {
            runCatching {
                val model = GenerativeModel(modelName = "gemini-1.5-flash", apiKey = apiKey)
                model.generateContent(
                    "Give a beginner-friendly hint in maximum two sentences for this Class 10 MCQ. Explain the concept but do not reveal the answer. Question: ${question.questionText}"
                ).text ?: "Think about the concept first, then eliminate options that do not match it."
            }.getOrElse {
                "Think about the concept first, then eliminate options that do not match it."
            }
        }
    }
}

private data class SeedBank(
    val chapters: List<Chapter>,
    val questions: List<SeedQuestion>
)

private data class SeedQuestion(
    val chapterKey: String,
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String,
    val explanation: String,
    val conceptTag: String
)
