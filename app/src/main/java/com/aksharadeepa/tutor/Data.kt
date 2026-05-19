package com.aksharadeepa.tutor

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "chapters")
data class Chapter(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chapterNumber: Int,
    val chapterName: String,
    val subject: String,
    val summary: String,
    val keyConcepts: List<String>,
    val totalQuestions: Int,
    val bestScore: Int = 0,
    val lastAttemptDate: Long? = null,
    val masteryLevel: MasteryLevel = MasteryLevel.RED
)

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chapterId: Long,
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String,
    val explanation: String,
    val difficulty: Difficulty = Difficulty.MEDIUM,
    val conceptTag: String
)

@Entity(tableName = "quiz_attempts")
data class QuizAttempt(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chapterId: Long,
    val score: Int,
    val totalQuestions: Int,
    val percentage: Float,
    val attemptDate: Long = System.currentTimeMillis(),
    val wrongQuestionIds: List<Long> = emptyList()
)

@Entity(tableName = "daily_streaks")
data class DailyStreak(
    @PrimaryKey val date: String,
    val quizzesCompleted: Int,
    val minutesStudied: Int
)

enum class MasteryLevel { RED, AMBER, GREEN }
enum class Difficulty { EASY, MEDIUM, HARD }

@Dao
interface TutorDao {
    @Query("SELECT COUNT(*) FROM chapters")
    suspend fun chapterCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapters(chapters: List<Chapter>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<Question>)

    @Query("SELECT * FROM chapters ORDER BY subject, chapterNumber")
    fun observeChapters(): Flow<List<Chapter>>

    @Query("SELECT * FROM chapters WHERE subject = :subject ORDER BY chapterNumber")
    fun observeChaptersBySubject(subject: String): Flow<List<Chapter>>

    @Query("SELECT * FROM chapters WHERE id = :id")
    suspend fun getChapter(id: Long): Chapter?

    @Query("SELECT * FROM questions WHERE chapterId = :chapterId ORDER BY difficulty, id")
    suspend fun getQuestions(chapterId: Long): List<Question>

    @Insert
    suspend fun insertAttempt(attempt: QuizAttempt): Long

    @Query("SELECT * FROM quiz_attempts WHERE id = :attemptId")
    suspend fun getAttempt(attemptId: Long): QuizAttempt?

    @Query("SELECT * FROM quiz_attempts ORDER BY attemptDate DESC")
    fun observeAttempts(): Flow<List<QuizAttempt>>

    @Query("UPDATE chapters SET bestScore = :bestScore, masteryLevel = :masteryLevel, lastAttemptDate = :date WHERE id = :chapterId")
    suspend fun updateChapterProgress(chapterId: Long, bestScore: Int, masteryLevel: MasteryLevel, date: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStreak(streak: DailyStreak)

    @Query("SELECT * FROM daily_streaks ORDER BY date DESC")
    fun observeStreaks(): Flow<List<DailyStreak>>

    @Query("SELECT * FROM daily_streaks WHERE date = :date")
    suspend fun getStreak(date: String): DailyStreak?
}

class Converters {
    @TypeConverter
    fun stringListToText(value: List<String>): String = value.joinToString("||")

    @TypeConverter
    fun textToStringList(value: String): List<String> =
        value.takeIf { it.isNotBlank() }?.split("||") ?: emptyList()

    @TypeConverter
    fun longListToText(value: List<Long>): String = value.joinToString(",")

    @TypeConverter
    fun textToLongList(value: String): List<Long> =
        value.takeIf { it.isNotBlank() }?.split(",")?.mapNotNull { it.toLongOrNull() } ?: emptyList()
}

@Database(
    entities = [Chapter::class, Question::class, QuizAttempt::class, DailyStreak::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tutorDao(): TutorDao
}
