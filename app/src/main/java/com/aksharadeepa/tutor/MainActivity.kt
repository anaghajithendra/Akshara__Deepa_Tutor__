package com.aksharadeepa.tutor

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AksharaDeepaAppRoot() }
    }
}

class TutorViewModel(application: Application) : AndroidViewModel(application) {
    private val container = (application as AksharaDeepaApp).container
    private val repository = container.repository
    val hintGenerator = container.hintGenerator
    private val prefs = application.getSharedPreferences("onboarding", 0)

    val isFirstLaunch = MutableStateFlow(prefs.getBoolean("firstLaunch", true))

    val uiState: StateFlow<TutorUiState> = combine(
        repository.chapters,
        repository.attempts,
        repository.streaks
    ) { chapters, attempts, streaks ->
        TutorUiState(chapters = chapters, attempts = attempts, streaks = streaks)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), TutorUiState())

    private val _selectedChapter = MutableStateFlow<Chapter?>(null)
    val selectedChapter: StateFlow<Chapter?> = _selectedChapter

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _result = MutableStateFlow<QuizAttempt?>(null)
    val result: StateFlow<QuizAttempt?> = _result

    private val _selectedAnswers = MutableStateFlow<Map<Long, String>>(emptyMap())
    val selectedAnswers: StateFlow<Map<Long, String>> = _selectedAnswers

    init {
        viewModelScope.launch { repository.seedIfNeeded() }
    }

    fun completeOnboarding() {
        prefs.edit().putBoolean("firstLaunch", false).apply()
        isFirstLaunch.value = false
    }

    fun loadChapter(id: Long) {
        viewModelScope.launch {
            _selectedChapter.value = repository.chapter(id)
            _questions.value = repository.questions(id)
        }
    }

    fun submitQuiz(chapterId: Long, answers: Map<Long, String>, onDone: () -> Unit) {
        viewModelScope.launch {
            _selectedAnswers.value = answers
            val attemptId = repository.submitQuiz(chapterId, answers)
            _result.value = repository.attempt(attemptId)
            onDone()
        }
    }
}

data class TutorUiState(
    val chapters: List<Chapter> = emptyList(),
    val attempts: List<QuizAttempt> = emptyList(),
    val streaks: List<DailyStreak> = emptyList()
) {
    val studyScore: Int = attempts.sumOf { it.score * 10 }
    val masteredChapters: Int = chapters.count { it.masteryLevel == MasteryLevel.GREEN }
}

sealed interface Route {
    data object Splash : Route
    data object Welcome : Route
    data object Dashboard : Route
    data class Chapters(val subject: String) : Route
    data class ChapterDetail(val chapterId: Long) : Route
    data class Quiz(val chapterId: Long) : Route
    data object Result : Route
    data object Review : Route
    data object Strength : Route
    data object History : Route
}

@Composable
fun AksharaDeepaAppRoot(viewModel: TutorViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val isFirstLaunch by viewModel.isFirstLaunch.collectAsState()
    var route by remember { mutableStateOf<Route>(Route.Splash) }
    val backStack = remember { mutableListOf<Route>() }

    fun go(next: Route) {
        backStack += route
        route = next
    }

    fun back() {
        route = backStack.removeLastOrNull() ?: Route.Dashboard
    }

    AksharaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            when (val current = route) {
                Route.Splash -> SplashScreen {
                    route = if (isFirstLaunch) Route.Welcome else Route.Dashboard
                }
                Route.Welcome -> WelcomeScreen {
                    viewModel.completeOnboarding()
                    route = Route.Dashboard
                }
                Route.Dashboard -> DashboardScreen(
                    uiState = uiState,
                    onSubject = { go(Route.Chapters(it)) },
                    onStrength = { go(Route.Strength) },
                    onHistory = { go(Route.History) }
                )
                is Route.Chapters -> ChapterListScreen(
                    subject = current.subject,
                    chapters = uiState.chapters.filter { it.subject == current.subject },
                    onBack = ::back,
                    onChapter = { go(Route.ChapterDetail(it)) }
                )
                is Route.ChapterDetail -> ChapterDetailScreen(
                    chapterId = current.chapterId,
                    attempts = uiState.attempts.filter { it.chapterId == current.chapterId },
                    viewModel = viewModel,
                    onBack = ::back,
                    onStartQuiz = { go(Route.Quiz(current.chapterId)) }
                )
                is Route.Quiz -> QuizScreen(
                    chapterId = current.chapterId,
                    viewModel = viewModel,
                    onBack = ::back,
                    onDone = {
                        backStack.clear()
                        backStack += Route.Dashboard
                        route = Route.Result
                    }
                )
                Route.Result -> ResultScreen(
                    viewModel = viewModel,
                    onContinue = { route = Route.Dashboard },
                    onReview = { route = Route.Review },
                    onRetry = { route = Route.Quiz(it) }
                )
                Route.Review -> ReviewScreen(viewModel = viewModel, onBack = { route = Route.Result })
                Route.Strength -> StrengthScreen(chapters = uiState.chapters, onBack = ::back)
                Route.History -> HistoryScreen(attempts = uiState.attempts, chapters = uiState.chapters, onBack = ::back)
            }
        }
    }
}

@Composable
fun AksharaTheme(content: @Composable () -> Unit) {
    val colors = androidx.compose.material3.lightColorScheme(
        primary = Color(0xFF22577A),
        secondary = Color(0xFF38A3A5),
        tertiary = Color(0xFFF9C74F),
        background = Color(0xFFF8FAFC),
        surface = Color.White,
        surfaceVariant = Color(0xFFEAF2F4),
        onPrimary = Color.White,
        onSurface = Color(0xFF14213D),
        onSurfaceVariant = Color(0xFF52616B)
    )
    MaterialTheme(colorScheme = colors, content = content)
}

@Composable
fun SplashScreen(onDone: () -> Unit) {
    val alpha by animateFloatAsState(targetValue = 1f, label = "splashAlpha")
    LaunchedEffect(Unit) {
        delay(2_000)
        onDone()
    }
    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary).padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Icon(Icons.Default.School, contentDescription = null, modifier = Modifier.size((96 * alpha).dp), tint = Color.White)
            Text("Akshara-Deepa Tutor", color = Color.White, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text("Track Your Learning Journey", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Spacer(Modifier.height(24.dp)) }
        item {
            Icon(Icons.Default.School, contentDescription = null, modifier = Modifier.size(96.dp), tint = MaterialTheme.colorScheme.primary)
        }
        item {
            Text("Welcome to Akshara-Deepa Tutor", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text("Your personal self-study companion for SSLC success", color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
        }
        item { FeatureRow("Track Progress", "Monitor your learning chapter by chapter") }
        item { FeatureRow("Smart Quizzes", "Get AI-powered hints when stuck") }
        item { FeatureRow("Build Streaks", "Stay consistent and earn points") }
        item {
            Button(onClick = onStart, modifier = Modifier.fillMaxWidth().height(54.dp)) {
                Text("Start Learning")
            }
        }
    }
}

@Composable
fun FeatureRow(title: String, body: String) {
    Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
            Spacer(Modifier.width(12.dp))
            Column {
                Text(title, fontWeight = FontWeight.SemiBold)
                Text(body, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
fun DashboardScreen(uiState: TutorUiState, onSubject: (String) -> Unit, onStrength: () -> Unit, onHistory: () -> Unit) {
    val subjects = listOf("Mathematics", "Science", "Social Studies")
    LazyColumn(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("Mission Map", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                    Text("45 chapters. 225 offline questions.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                IconButton(onClick = onStrength) { Icon(Icons.Default.BarChart, contentDescription = "Strength Map") }
                IconButton(onClick = onHistory) { Icon(Icons.Default.History, contentDescription = "History") }
            }
        }
        item {
            OverviewCard(uiState)
        }
        items(subjects) { subject ->
            val chapters = uiState.chapters.filter { it.subject == subject }
            SubjectCard(subject, chapters, onClick = { onSubject(subject) })
        }
    }
}

@Composable
fun OverviewCard(uiState: TutorUiState) {
    val progress = if (uiState.chapters.isEmpty()) 0f else uiState.masteredChapters.toFloat() / uiState.chapters.size
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary), shape = RoundedCornerShape(8.dp)) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("Progress Overview", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
            Text("Chapters: ${uiState.masteredChapters}/${uiState.chapters.size}", color = Color.White)
            Text("Study Score: ${uiState.studyScore}", color = Color.White)
            Text("Streak: ${uiState.streaks.size} days", color = Color.White)
            LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.tertiary, trackColor = Color.White.copy(alpha = 0.25f))
        }
    }
}

@Composable
fun SubjectCard(subject: String, chapters: List<Chapter>, onClick: () -> Unit) {
    val completed = chapters.count { it.masteryLevel == MasteryLevel.GREEN }
    val progress = if (chapters.isEmpty()) 0f else completed.toFloat() / chapters.size
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(8.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.MenuBook, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
                Spacer(Modifier.width(12.dp))
                Text(subject.uppercase(), fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("$completed/${chapters.size}")
            }
            LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
            MasteryDots(chapters.take(15))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterListScreen(subject: String, chapters: List<Chapter>, onBack: () -> Unit, onChapter: (Long) -> Unit) {
    Scaffold(topBar = { AppBar(subject, onBack) }) { padding ->
        LazyColumn(contentPadding = padding, modifier = Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(chapters) { chapter ->
                Card(Modifier.fillMaxWidth().clickable { onChapter(chapter.id) }, shape = RoundedCornerShape(8.dp)) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        MasteryDot(chapter.masteryLevel)
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text("${chapter.chapterNumber}. ${chapter.chapterName}", fontWeight = FontWeight.SemiBold)
                            Text("Best score ${chapter.bestScore}% • ${chapter.masteryLevel.label}", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChapterDetailScreen(chapterId: Long, attempts: List<QuizAttempt>, viewModel: TutorViewModel, onBack: () -> Unit, onStartQuiz: () -> Unit) {
    val chapter by viewModel.selectedChapter.collectAsState()
    val questions by viewModel.questions.collectAsState()
    LaunchedEffect(chapterId) { viewModel.loadChapter(chapterId) }
    Scaffold(topBar = { AppBar(chapter?.chapterName ?: "Chapter", onBack) }) { padding ->
        chapter?.let {
            LazyColumn(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                item { Text(it.summary, style = MaterialTheme.typography.bodyLarge) }
                item {
                    Text("Key Concepts", fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(8.dp))
                    it.keyConcepts.forEach { concept -> Text("- $concept") }
                }
                item {
                    StatLine("Previous attempts", attempts.size.toString())
                    StatLine("Best score", "${it.bestScore}%")
                    StatLine("Questions", questions.size.toString())
                }
                item {
                    Button(onClick = onStartQuiz, modifier = Modifier.fillMaxWidth().height(52.dp)) {
                        Text("Start Quiz")
                    }
                }
            }
        } ?: Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
    }
}

@Composable
fun QuizScreen(chapterId: Long, viewModel: TutorViewModel, onBack: () -> Unit, onDone: () -> Unit) {
    val questions by viewModel.questions.collectAsState()
    val answers = remember(chapterId) { mutableStateMapOf<Long, String>() }
    var index by remember(chapterId) { mutableIntStateOf(0) }
    var secondsLeft by remember(chapterId) { mutableIntStateOf(90) }
    LaunchedEffect(chapterId) { viewModel.loadChapter(chapterId) }
    LaunchedEffect(chapterId, questions.size) {
        secondsLeft = 90
        while (secondsLeft > 0 && questions.isNotEmpty()) {
            delay(1_000)
            secondsLeft--
        }
        if (questions.isNotEmpty() && secondsLeft == 0) {
            viewModel.submitQuiz(chapterId, answers, onDone)
        }
    }

    Scaffold(topBar = { AppBar("Quiz", onBack) }) { padding ->
        if (questions.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        } else {
            val question = questions[index]
            Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("Question ${index + 1}/${questions.size}", fontWeight = FontWeight.SemiBold)
                LinearProgressIndicator(progress = { (index + 1).toFloat() / questions.size }, modifier = Modifier.fillMaxWidth())
                Text("Time left: ${secondsLeft}s", color = if (secondsLeft <= 15) Color(0xFFE76F51) else MaterialTheme.colorScheme.onSurfaceVariant)
                QuestionCard(question = question, selected = answers[question.id], onAnswer = { answers[question.id] = it })
                Spacer(Modifier.weight(1f))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                    OutlinedButton(onClick = { index-- }, enabled = index > 0, modifier = Modifier.weight(1f)) { Text("Previous") }
                    Button(
                        onClick = {
                            if (index == questions.lastIndex) viewModel.submitQuiz(chapterId, answers, onDone) else index++
                        },
                        enabled = answers[question.id] != null,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(if (index == questions.lastIndex) "Submit" else "Next")
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionCard(question: Question, selected: String?, onAnswer: (String) -> Unit) {
    Card(shape = RoundedCornerShape(8.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(question.questionText, fontWeight = FontWeight.SemiBold)
            listOf("A" to question.optionA, "B" to question.optionB, "C" to question.optionC, "D" to question.optionD).forEach { (key, text) ->
                Row(Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)).clickable { onAnswer(key) }.padding(vertical = 2.dp), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = selected == key, onClick = { onAnswer(key) })
                    Text("$key. $text")
                }
            }
        }
    }
}

@Composable
fun ResultScreen(viewModel: TutorViewModel, onContinue: () -> Unit, onReview: () -> Unit, onRetry: (Long) -> Unit) {
    val result by viewModel.result.collectAsState()
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
        result?.let {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("${it.score}/${it.totalQuestions}", style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Bold, color = masteryColor(levelFor(it.percentage.toInt())))
                Text("${it.percentage.toInt()}% • ${levelFor(it.percentage.toInt()).label}", style = MaterialTheme.typography.titleMedium)
                Text("Study score earned: ${it.score * 10}", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Button(onClick = onReview, modifier = Modifier.fillMaxWidth()) { Text("Review Answers") }
                OutlinedButton(onClick = { onRetry(it.chapterId) }, modifier = Modifier.fillMaxWidth()) { Text("Try Again") }
                Button(onClick = onContinue, modifier = Modifier.fillMaxWidth()) { Text("Back to Mission Map") }
            }
        } ?: CircularProgressIndicator()
    }
}

@Composable
fun ReviewScreen(viewModel: TutorViewModel, onBack: () -> Unit) {
    val questions by viewModel.questions.collectAsState()
    val answers by viewModel.selectedAnswers.collectAsState()
    val scope = rememberCoroutineScope()
    var hint by remember { mutableStateOf("") }
    Scaffold(topBar = { AppBar("Review Answers", onBack) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            if (hint.isNotBlank()) {
                item {
                    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), shape = RoundedCornerShape(8.dp)) {
                        Row(Modifier.padding(14.dp)) {
                            Icon(Icons.Default.Lightbulb, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
                            Spacer(Modifier.width(10.dp))
                            Text(hint)
                        }
                    }
                }
            }
            items(questions) { question ->
                val selected = answers[question.id]
                val correct = selected == question.correctAnswer
                Card(shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = if (correct) Color(0xFFE8F5EF) else Color(0xFFFFF1ED))) {
                    Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(question.questionText, fontWeight = FontWeight.SemiBold)
                        Text("Your answer: ${selected ?: "Not answered"}")
                        Text("Correct answer: ${question.correctAnswer}")
                        Text(question.explanation, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        if (!correct) {
                            OutlinedButton(onClick = {
                                scope.launch { hint = viewModel.hintGenerator.hint(question) }
                            }) {
                                Icon(Icons.Default.Lightbulb, contentDescription = null)
                                Spacer(Modifier.width(8.dp))
                                Text("AI Hint")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StrengthScreen(chapters: List<Chapter>, onBack: () -> Unit) {
    Scaffold(topBar = { AppBar("Strength Map", onBack) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(chapters.groupBy { it.subject }.toList()) { (subject, subjectChapters) ->
                Text(subject, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                subjectChapters.forEach { chapter ->
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        MasteryDot(chapter.masteryLevel)
                        Spacer(Modifier.width(12.dp))
                        Text(chapter.chapterName, Modifier.weight(1f), maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text("${chapter.bestScore}%")
                    }
                }
            }
        }
    }
}

@Composable
fun HistoryScreen(attempts: List<QuizAttempt>, chapters: List<Chapter>, onBack: () -> Unit) {
    Scaffold(topBar = { AppBar("Progress History", onBack) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            item {
                val weak = chapters.filter { it.masteryLevel == MasteryLevel.RED }.take(3).joinToString { it.chapterName }
                Text("Weak areas: ${weak.ifBlank { "Complete quizzes to discover weak areas" }}", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            items(attempts) { attempt ->
                val chapter = chapters.firstOrNull { it.id == attempt.chapterId }
                Card(shape = RoundedCornerShape(8.dp)) {
                    Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = masteryColor(levelFor(attempt.percentage.toInt())))
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text(chapter?.chapterName ?: "Chapter ${attempt.chapterId}", fontWeight = FontWeight.SemiBold)
                            Text("${attempt.score}/${attempt.totalQuestions} correct", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Text("${attempt.percentage.toInt()}%")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

@Composable
fun StatLine(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun MasteryDots(chapters: List<Chapter>) {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        chapters.forEach { MasteryDot(it.masteryLevel) }
    }
}

@Composable
fun MasteryDot(level: MasteryLevel) {
    Box(Modifier.size(14.dp).clip(CircleShape).background(masteryColor(level)))
}

val MasteryLevel.label: String
    get() = when (this) {
        MasteryLevel.GREEN -> "Mastered"
        MasteryLevel.AMBER -> "Needs Revision"
        MasteryLevel.RED -> "Weak"
    }

fun levelFor(score: Int): MasteryLevel = when {
    score >= 70 -> MasteryLevel.GREEN
    score >= 40 -> MasteryLevel.AMBER
    else -> MasteryLevel.RED
}

fun masteryColor(level: MasteryLevel): Color = when (level) {
    MasteryLevel.GREEN -> Color(0xFF2D9D78)
    MasteryLevel.AMBER -> Color(0xFFF9C74F)
    MasteryLevel.RED -> Color(0xFFE76F51)
}
