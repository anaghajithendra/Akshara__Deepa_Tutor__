# 📄 STANDARD OPERATING PROCEDURE (SOP)
# Akshara-Deepa Tutor
### Android App Development using GenAI
### Education / Rural Learning Track

---

## 📑 TABLE OF CONTENTS

1. [Project Overview](#1-project-overview)
2. [Project Objectives](#2-project-objectives)
3. [Target Users](#3-target-users)
4. [Core Features](#4-core-features)
5. [Complete User Flow](#5-complete-user-flow)
6. [Screen-by-Screen Specifications](#6-screen-by-screen-specifications)
7. [Database Structure](#7-database-structure)
8. [Backend Logic & Algorithms](#8-backend-logic--algorithms)
9. [Offline-First Architecture](#9-offline-first-architecture)
10. [GenAI Integration Requirements](#10-genai-integration-requirements)
11. [Frontend Design Guidelines](#11-frontend-design-guidelines)
12. [Technical Architecture](#12-technical-architecture)
13. [Non-Functional Requirements](#13-non-functional-requirements)
14. [Acceptance Criteria](#14-acceptance-criteria)
15. [Question Database - Complete Dataset](#15-question-database---complete-dataset)
16. [Future Enhancements](#16-future-enhancements)
17. [Final Deliverables](#17-final-deliverables)

---

# 1. PROJECT OVERVIEW

## 📌 Project Name
**Akshara-Deepa Tutor**

## 🎯 Project Vision
Akshara-Deepa Tutor is a **GenAI-powered self-study companion application** designed specifically for **Class 10 (SSLC) students**, with a primary focus on **rural and semi-urban students** who lack access to coaching centers and structured after-school guidance.

The application transforms traditional studying into a **guided, data-driven learning journey** through:

- ✅ **Chapter-wise progress tracking**
- ✅ **Daily quizzes with instant feedback**
- ✅ **Visual strength analysis**
- ✅ **AI-generated conceptual hints**
- ✅ **Study streaks and gamified score systems**
- ✅ **Complete offline functionality**

### Key Innovation
The app uses **Google Gemini API** to provide contextual learning hints without revealing direct answers, encouraging conceptual understanding over rote memorization.

---

# 2. PROJECT OBJECTIVES

The primary goals of Akshara-Deepa Tutor are:

| Objective | Description |
|-----------|-------------|
| **Identify Weak Areas** | Help students identify weak subjects and chapters through visual mastery indicators |
| **Build Consistency** | Improve daily study habits through streak tracking and daily reminders |
| **Track Mastery** | Provide visual chapter mastery tracking with color-coded indicators |
| **Instant Feedback** | Deliver immediate quiz results and performance analytics |
| **Encourage Self-Learning** | Use AI-powered hints to guide students toward understanding |
| **Offline Accessibility** | Ensure full functionality in areas with limited internet connectivity |

---

# 3. TARGET USERS

## Primary Users

| User Type | Characteristics |
|-----------|----------------|
| **Class 10 SSLC Students** | Ages 14-16, preparing for board examinations |
| **Rural Students** | Limited access to coaching centers and tutors |
| **Semi-Urban Students** | Seeking affordable self-study solutions |
| **Digital-First Learners** | Comfortable with smartphone-based learning |

## User Constraints
- May have low-end Android devices (2GB RAM)
- Intermittent internet connectivity
- Limited storage capacity
- First-time app users (need simple UX)

---

# 4. CORE FEATURES

## 📚 Feature 1: Mission Map Dashboard

### Purpose
A **subject and chapter navigation system** that serves as the central hub for learning.

### Subjects Covered
1. **Mathematics** (15 Chapters)
2. **Science** (15 Chapters)
3. **Social Studies** (15 Chapters)

### Key Features
- ✅ Chapter progress tracking (0-100%)
- ✅ Completion indicators (✓ checkmarks)
- ✅ Color-coded mastery levels
- ✅ Chapter hierarchy visualization
- ✅ Quick access to all subjects
- ✅ Visual progress indicators

---

## 🧪 Feature 2: Chapter Quiz System

### Quiz Specifications

| Specification | Details |
|---------------|---------|
| **Questions per Chapter** | Exactly 5 MCQs |
| **Question Format** | Multiple Choice (4 options: A, B, C, D) |
| **Timer** | 60-90 seconds recommended |
| **Attempt Limit** | Unlimited retakes allowed |
| **Best Score Tracking** | System saves highest score achieved |

### Quiz Requirements
- ✅ Fully offline functionality
- ✅ Instant score calculation
- ✅ Progress persistence across app restarts
- ✅ Question randomization (optional)
- ✅ Clear answer selection UI
- ✅ Submit confirmation dialog

---

## 🕸️ Feature 3: Strength Map (Mastery Tracking)

### Purpose
Visual representation of student mastery across subjects and chapters.

### Color-Coding Logic

| Color | Mastery Level | Score Range | Interpretation |
|-------|---------------|-------------|----------------|
| 🟢 **Green** | Mastered | ≥70% | Strong understanding |
| 🟡 **Amber** | Needs Revision | 40-69% | Moderate understanding |
| 🔴 **Red** | Weak | <40% | Requires focused study |

### Update Mechanism
- Updates **instantly** after every quiz submission
- Reflects **best score** achieved for each chapter
- Provides **subject-wise summary** visualization
- Shows **overall progress percentage**

---

## 🎯 Feature 4: Daily Goal Reminder

### Purpose
Encourage consistent study habits through smart notifications.

### Implementation
- **Technology**: WorkManager (Android background task scheduler)
- **Notification Time**: Evening (configurable)
- **Frequency**: Daily
- **Content**: Motivational messages encouraging quiz completion

### Sample Notifications
- "📚 Complete today's learning goal! One quiz = 10 points"
- "🔥 Keep your streak alive! You've studied for X days"
- "🎯 Review weak chapters today for better mastery"

---

## 🤖 Feature 5: GenAI Hint System (Gemini API)

### Purpose
Provide contextual learning assistance without revealing direct answers.

### Trigger Condition
- **When**: Student answers a question incorrectly
- **What**: Gemini API generates a conceptual hint

### AI Hint Rules
1. ✅ **2-sentence maximum** hint
2. ✅ **Explains the underlying concept**
3. ❌ **Does NOT reveal the direct answer**
4. ✅ **Uses beginner-friendly language**
5. ✅ **Encourages thinking and understanding**

### Example Interaction

**Question**: "The HCF of 96 and 404 is?"
**Student Answer**: C (12) ❌ Incorrect
**Correct Answer**: A (4)

**AI Hint Generated**:
> "HCF is found using Euclid's Division Algorithm where we repeatedly divide and take remainders. Start by dividing the larger number by the smaller one and continue until the remainder is zero."

---

## 📈 Feature 6: Progress History

### Purpose
Enable students to review their learning journey and track improvements.

### Data Displayed

| Data Point | Description |
|------------|-------------|
| **Quiz Attempts** | All previous attempts with dates |
| **Score Trends** | Line/bar charts showing improvement |
| **Chapter-wise Analysis** | Breakdown by subject and chapter |
| **Weak Area Identification** | Chapters with consistently low scores |
| **Best Scores** | Highest achievements per chapter |
| **Study Streaks** | Consecutive days of learning |

### Sorting Options
- Most recent first (default)
- By score (ascending/descending)
- By subject
- By mastery level

---

# 5. COMPLETE USER FLOW

## Application Flow Diagram

```
┌─────────────────────────────────────────────────────────────┐
│                      APP LAUNCH                             │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 1: SPLASH SCREEN                                    │
│  • Display app logo and tagline                             │
│  • Initialize database (if first launch)                    │
│  • Duration: 2-3 seconds                                    │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 2: WELCOME SCREEN                                   │
│  • Show app introduction                                    │
│  • "Start Learning" CTA button                              │
│  • One-time onboarding experience                           │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 3: MISSION MAP DASHBOARD (HOME)                     │
│  • View all 3 subjects                                      │
│  • See overall progress stats                               │
│  • Access strength map & history                            │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 4: CHAPTER LIST SCREEN                              │
│  • Display 15 chapters for selected subject                 │
│  • Show mastery colors (Red/Amber/Green)                    │
│  • Display best scores                                      │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 5: CHAPTER OVERVIEW SCREEN                          │
│  • Show chapter summary                                     │
│  • Display key concepts                                     │
│  • Show previous attempt history                            │
│  • "Start Quiz" button                                      │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 6: QUIZ SCREEN                                      │
│  • 5 MCQ questions                                          │
│  • Timer countdown                                          │
│  • Progress indicator (1/5, 2/5...)                         │
│  • Next/Previous navigation                                 │
│  • Submit button                                            │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 7: QUIZ RESULT SCREEN                               │
│  • Display final score (X/5)                                │
│  • Show correct/incorrect answers                           │
│  • Update mastery level                                     │
│  • Calculate study score                                    │
│  • "Review Answers" button                                  │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 8: REVIEW ANSWERS SCREEN (Optional)                 │
│  • Show all questions with answers                          │
│  • Highlight wrong answers                                  │
│  • Display AI-generated hints (for wrong answers)           │
│  • Provide explanations                                     │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 9: STRENGTH MAP SCREEN                              │
│  • Visual mastery representation                            │
│  • Radar chart / Heatmap                                    │
│  • Subject-wise breakdown                                   │
│  • Chapter-level details                                    │
└─────────────────────┬───────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────┐
│  SCREEN 10: PROGRESS HISTORY SCREEN                         │
│  • All quiz attempts timeline                               │
│  • Score trend graphs                                       │
│  • Weak area analysis                                       │
│  • Study statistics                                         │
└─────────────────────┴───────────────────────────────────────┘
```

---

# 6. SCREEN-BY-SCREEN SPECIFICATIONS

## SCREEN 1: SPLASH SCREEN

### Purpose
Display app branding while initializing the application.

### UI Requirements

| Element | Specification |
|---------|---------------|
| **Logo** | Centered, large size (120dp) |
| **Tagline** | "Track Your Learning Journey" |
| **Background** | Gradient or solid color (brand blue) |
| **Animation** | Fade-in effect (500ms) |
| **Duration** | 2-3 seconds |

### Design Style
- ✅ Modern educational aesthetic
- ✅ Minimal, clean layout
- ✅ Blue + green educational color palette
- ✅ High contrast for readability

### Navigation Logic
```kotlin
After 2-3 seconds:
  if (isFirstLaunch) {
    navigate to Welcome Screen
  } else {
    navigate to Mission Map Dashboard
  }
```

---

## SCREEN 2: WELCOME SCREEN

### Purpose
Introduce the app's mission and encourage users to begin learning.

### UI Elements

| Element | Description |
|---------|-------------|
| **Hero Image** | Illustration of students learning |
| **Welcome Text** | "Welcome to Akshara-Deepa Tutor" |
| **Subtitle** | "Your personal self-study companion for SSLC success" |
| **Feature Highlights** | 3 key benefits (icons + text) |
| **CTA Button** | "Start Learning" (large, prominent) |

### Feature Highlights to Display
1. 📊 **Track Progress** - Monitor your learning chapter by chapter
2. 🎯 **Smart Quizzes** - Get AI-powered hints when stuck
3. 🔥 **Build Streaks** - Stay consistent and earn points

### Navigation
```kotlin
On "Start Learning" click:
  → Navigate to Mission Map Dashboard
  → Mark onboarding as complete
```

---

## SCREEN 3: MISSION MAP DASHBOARD

### Purpose
Central hub displaying all subjects and overall progress.

### Layout Structure

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  • App Title: "Mission Map"                 │
│  • Strength Map Icon                        │
│  • History Icon                             │
├──────────────────────────────────────────────┤
│  PROGRESS OVERVIEW CARD                      │
│  ┌────────────────────────────────────────┐ │
│  │ 📚 Chapters: 5/45                      │ │
│  │ ⭐ Study Score: 150                    │ │
│  │ 🔥 Streak: 7 days                      │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  SUBJECT CARDS                               │
│  ┌────────────────────────────────────────┐ │
│  │ 📐 MATHEMATICS                         │ │
│  │ Progress: 33% • 5/15 chapters          │ │
│  │ [Progress Bar]                         │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🔬 SCIENCE                             │ │
│  │ Progress: 20% • 3/15 chapters          │ │
│  │ [Progress Bar]                         │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🌍 SOCIAL STUDIES                      │ │
│  │ Progress: 13% • 2/15 chapters          │ │
│  │ [Progress Bar]                         │ │
│  └────────────────────────────────────────┘ │
└──────────────────────────────────────────────┘
```

### Subject Card Components
- **Subject Icon** (emoji or vector drawable)
- **Subject Name** (bold, large text)
- **Progress Percentage** (calculated from completed chapters)
- **Chapters Completed** (e.g., "5/15 chapters")
- **Linear Progress Bar** (color-coded)
- **Mastery Indicator** (color tint: green/amber/red based on average)

### Bottom Navigation
- 🏠 **Home** (Mission Map)
- 📊 **Strength Map**
- 📈 **Progress History**
- ⚙️ **Settings**

### Navigation
```kotlin
On Subject Card Click:
  → Navigate to Chapter List Screen
  → Pass subject name as parameter
```

---

## SCREEN 4: CHAPTER LIST SCREEN

### Purpose
Display all 15 chapters for the selected subject.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | MATHEMATICS                      │
├──────────────────────────────────────────────┤
│  CHAPTER CARDS (Scrollable List)             │
│  ┌────────────────────────────────────────┐ │
│  │ 1. Real Numbers              🟢        │ │
│  │ Best Score: 5/5 (100%)                 │ │
│  │ Last Attempt: 2 days ago               │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 2. Polynomials               🟡        │ │
│  │ Best Score: 3/5 (60%)                  │ │
│  │ Last Attempt: 5 days ago               │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 3. Linear Equations          🔴        │ │
│  │ Best Score: 1/5 (20%)                  │ │
│  │ Last Attempt: Never                    │ │
│  └────────────────────────────────────────┘ │
│  ... (12 more chapters)                     │
└──────────────────────────────────────────────┘
```

### Chapter Card Components

| Component | Details |
|-----------|---------|
| **Chapter Number** | Sequential (1-15) |
| **Chapter Name** | Full chapter title |
| **Mastery Indicator** | Colored circle (🟢🟡🔴) |
| **Best Score** | Highest score achieved (X/5) |
| **Percentage** | Score as percentage |
| **Last Attempt** | Time since last quiz (e.g., "2 days ago") |
| **Completion Badge** | ✓ checkmark if score ≥70% |

### Mastery Color Logic
```kotlin
when (bestScorePercentage) {
    in 70..100 -> MasteryLevel.GREEN  // 🟢
    in 40..69  -> MasteryLevel.AMBER  // 🟡
    in 0..39   -> MasteryLevel.RED    // 🔴
}
```

### Navigation
```kotlin
On Chapter Card Click:
  → Navigate to Chapter Overview Screen
  → Pass chapter ID as parameter
```

---

## SCREEN 5: CHAPTER OVERVIEW SCREEN

### Purpose
Provide detailed chapter information before starting the quiz.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | Chapter 1: Real Numbers          │
├──────────────────────────────────────────────┤
│  CHAPTER SUMMARY CARD                        │
│  ┌────────────────────────────────────────┐ │
│  │ 📖 SUMMARY                             │ │
│  │ This chapter covers fundamental        │ │
│  │ concepts of real numbers including...  │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  KEY CONCEPTS CARD                           │
│  ┌────────────────────────────────────────┐ │
│  │ 💡 KEY CONCEPTS                        │ │
│  │ • Euclid's Division Lemma              │ │
│  │ • Fundamental Theorem of Arithmetic    │ │
│  │ • Rational and Irrational Numbers      │ │
│  │ • Decimal Expansion                    │ │
│  │ • HCF and LCM                          │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  PROGRESS STATS CARD                         │
│  ┌────────────────────────────────────────┐ │
│  │ 📊 YOUR PROGRESS                       │ │
│  │ Total Attempts: 3                      │ │
│  │ Best Score: 4/5 (80%)                  │ │
│  │ Mastery Level: 🟢 Green (Mastered)     │ │
│  │ Last Attempt: 2 days ago               │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  [START QUIZ] BUTTON (Large, Primary)        │
└──────────────────────────────────────────────┘
```

### Data Requirements
- **Chapter Summary**: 2-3 sentence overview
- **Key Concepts**: 4-6 bullet points (JSON array from database)
- **Progress Stats**: Fetched from QuizAttempt table
- **Mastery Calculation**: Based on best score

### Navigation
```kotlin
On "Start Quiz" Click:
  → Navigate to Quiz Screen
  → Load 5 questions for this chapter
  → Start timer
```

---

## SCREEN 6: QUIZ SCREEN

### Purpose
Conduct the chapter quiz with timer and navigation controls.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ⏱️ 01:25 | Question 2/5           [Exit]    │
├──────────────────────────────────────────────┤
│  PROGRESS INDICATOR                          │
│  [●][●][○][○][○]                             │
├──────────────────────────────────────────────┤
│  QUESTION CARD                               │
│  ┌────────────────────────────────────────┐ │
│  │ The HCF of 96 and 404 is:              │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  OPTIONS (Radio Buttons)                     │
│  ┌────────────────────────────────────────┐ │
│  │ ○ A. 4                                 │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ ○ B. 8                                 │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ ● C. 12                                │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ ○ D. 2                                 │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  NAVIGATION BUTTONS                          │
│  [← Previous]              [Next →]          │
│                                              │
│  [SUBMIT QUIZ] (Enabled only when complete)  │
└──────────────────────────────────────────────┘
```

### Functional Requirements

| Feature | Specification |
|---------|---------------|
| **Timer** | Countdown from 90 seconds (configurable) |
| **Timer Alert** | Red color when <30 seconds remain |
| **Auto-Submit** | Submit quiz when timer reaches 0 |
| **Answer Selection** | Single-select radio buttons |
| **Navigation** | Previous/Next buttons (maintain state) |
| **Progress Indicator** | Visual dots showing current question |
| **Exit Confirmation** | Dialog asking "Are you sure?" when exiting |

### Question Loading
```kotlin
// Load questions from Room database
questions = questionDao.getQuestionsByChapter(chapterId)
  .orderBy(questionNumber)
  .limit(5)
```

### State Management
```kotlin
data class QuizUiState(
    val questions: List<Question>,
    val currentQuestionIndex: Int = 0,
    val userAnswers: MutableMap<Int, String> = mutableMapOf(),
    val timeRemaining: Int = 90,
    val isSubmitted: Boolean = false
)
```

### Navigation
```kotlin
On "Submit Quiz" Click:
  → Calculate score
  → Save attempt to database
  → Update chapter mastery
  → Navigate to Quiz Result Screen
```

---

## SCREEN 7: QUIZ RESULT SCREEN

### Purpose
Display quiz performance and update progress instantly.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  RESULT CARD                                 │
│  ┌────────────────────────────────────────┐ │
│  │         🎉 QUIZ COMPLETED!             │ │
│  │                                        │ │
│  │            YOUR SCORE                  │ │
│  │              4 / 5                     │ │
│  │              80%                       │ │
│  │                                        │ │
│  │   Mastery Level: 🟢 MASTERED           │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  PERFORMANCE BREAKDOWN                       │
│  ┌────────────────────────────────────────┐ │
│  │ ✅ Correct: 4                          │ │
│  │ ❌ Incorrect: 1                        │ │
│  │ ⏱️ Time Taken: 62 seconds              │ │
│  │ ⭐ Points Earned: +10                  │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  MOTIVATIONAL MESSAGE                        │
│  ┌────────────────────────────────────────┐ │
│  │ "Excellent work! You've mastered this  │ │
│  │  chapter. Keep up the great progress!" │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  ACTION BUTTONS                              │
│  [REVIEW ANSWERS]                            │
│  [BACK TO CHAPTERS]                          │
│  [VIEW STRENGTH MAP]                         │
└──────────────────────────────────────────────┘
```

### Score Calculation Logic
```kotlin
val correctAnswers = userAnswers.count { (questionId, answer) ->
    questions.find { it.id == questionId }?.correctAnswer == answer
}
val score = correctAnswers
val percentage = (score / totalQuestions.toFloat()) * 100
```

### Mastery Update Logic
```kotlin
val newMasteryLevel = when (percentage) {
    in 70f..100f -> "GREEN"
    in 40f..69f  -> "AMBER"
    else         -> "RED"
}

// Update chapter in database
chapterDao.updateChapterProgress(
    chapterId = chapterId,
    bestScore = max(currentBestScore, score),
    masteryLevel = newMasteryLevel,
    lastAttemptDate = System.currentTimeMillis()
)
```

### Study Score Calculation
```kotlin
val pointsEarned = if (percentage >= 70) {
    10 * streakMultiplier
} else {
    0
}

userProgressDao.updateStudyScore(
    currentScore + pointsEarned
)
```

### Navigation
```kotlin
On "Review Answers" Click:
  → Navigate to Review Answers Screen
  
On "Back to Chapters" Click:
  → Navigate to Chapter List Screen
  
On "View Strength Map" Click:
  → Navigate to Strength Map Screen
```

---

## SCREEN 8: REVIEW ANSWERS SCREEN

### Purpose
Allow students to review their quiz performance and learn from mistakes.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | Review Answers                   │
├──────────────────────────────────────────────┤
│  QUESTION 1 (Correct)                        │
│  ┌────────────────────────────────────────┐ │
│  │ ✅ The HCF of 96 and 404 is:            │ │
│  │                                        │ │
│  │ Your Answer: A. 4 ✓ Correct            │ │
│  │                                        │ │
│  │ 💡 EXPLANATION:                        │ │
│  │ Using Euclid's Division Algorithm...   │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  QUESTION 2 (Incorrect)                      │
│  ┌────────────────────────────────────────┐ │
│  │ ❌ Which is an irrational number?      │ │
│  │                                        │ │
│  │ Your Answer: B. √16 ✗ Wrong            │ │
│  │ Correct Answer: C. √12                 │ │
│  │                                        │ │
│  │ 🤖 AI HINT:                            │ │
│  │ "An irrational number cannot be        │ │
│  │  expressed as a fraction of integers.  │ │
│  │  √12 simplifies to 2√3, and √3 cannot │ │
│  │  be written as a simple fraction."     │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  ... (Remaining 3 questions)                 │
└──────────────────────────────────────────────┘
```

### GenAI Hint Integration

For each **incorrect answer**, the system should:

1. **Call Gemini API** with context:
```json
{
  "subject": "Mathematics",
  "chapter": "Real Numbers",
  "question": "Which is an irrational number?",
  "correct_answer": "√12",
  "student_answer": "√16",
  "concept_tag": "Irrational Numbers"
}
```

2. **Receive AI Hint** (max 2 sentences):
```
"An irrational number cannot be expressed as a fraction 
of integers. √12 simplifies to 2√3, and √3 cannot be 
written as a simple fraction."
```

3. **Display Hint** in the UI with a robot icon (🤖)

### AI Hint Generation Rules
- ✅ Explain the **underlying concept**
- ✅ Use **simple, beginner-friendly language**
- ❌ Do NOT reveal the **exact answer steps**
- ✅ Encourage **understanding over memorization**
- ✅ Keep to **2 sentences maximum**

---

## SCREEN 9: STRENGTH MAP SCREEN

### Purpose
Provide visual representation of mastery across all subjects and chapters.

### UI Layout Option 1: Radar Chart

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | Strength Map                     │
├──────────────────────────────────────────────┤
│  OVERALL MASTERY                             │
│  ┌────────────────────────────────────────┐ │
│  │                                        │ │
│  │           Mathematics (67%)            │ │
│  │               /   \                    │ │
│  │              /     \                   │ │
│  │      Social /       \ Science          │ │
│  │      (45%) \_______/ (73%)             │ │
│  │                                        │ │
│  │         [Radar Chart]                  │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  SUBJECT BREAKDOWN                           │
│  ┌────────────────────────────────────────┐ │
│  │ 📐 MATHEMATICS (67%)                   │ │
│  │ 🟢 Green: 10 chapters                  │ │
│  │ 🟡 Amber: 3 chapters                   │ │
│  │ 🔴 Red: 2 chapters                     │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🔬 SCIENCE (73%)                       │ │
│  │ 🟢 Green: 11 chapters                  │ │
│  │ 🟡 Amber: 2 chapters                   │ │
│  │ 🔴 Red: 2 chapters                     │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🌍 SOCIAL STUDIES (45%)                │ │
│  │ 🟢 Green: 5 chapters                   │ │
│  │ 🟡 Amber: 6 chapters                   │ │
│  │ 🔴 Red: 4 chapters                     │ │
│  └────────────────────────────────────────┘ │
└──────────────────────────────────────────────┘
```

### UI Layout Option 2: Heatmap Grid

```
┌──────────────────────────────────────────────┐
│  CHAPTER MASTERY HEATMAP                     │
│  ┌────────────────────────────────────────┐ │
│  │ MATHEMATICS                            │ │
│  │ [🟢][🟢][🟢][🟢][🟡][🟢][🟢][🟢]        │ │
│  │ [🟢][🟡][🔴][🟢][🟢][🟡][🔴]           │ │
│  │                                        │ │
│  │ SCIENCE                                │ │
│  │ [🟢][🟢][🟢][🟢][🟢][🟢][🟡][🟢]        │ │
│  │ [🟢][🟢][🟢][🔴][🟢][🟡][🔴]           │ │
│  │                                        │ │
│  │ SOCIAL STUDIES                         │ │
│  │ [🟡][🟡][🟢][🟢][🔴][🟡][🟡][🟢]        │ │
│  │ [🔴][🟢][🔴][🟡][🟡][🟡][🔴]           │ │
│  └────────────────────────────────────────┘ │
└──────────────────────────────────────────────┘
```

### Data Calculation
```kotlin
// Calculate subject mastery
val subjectMastery = chapters
    .groupBy { it.subject }
    .mapValues { (_, chapters) ->
        val avgPercentage = chapters
            .map { it.bestPercentage }
            .average()
        avgPercentage
    }

// Count mastery distribution
val masteryDistribution = chapters
    .groupBy { it.masteryLevel }
    .mapValues { it.value.size }
```

### Dynamic Updates
- ✅ Updates **immediately** after quiz submission
- ✅ Reflects **latest best scores**
- ✅ Recalculates **subject averages** in real-time
- ✅ Animates **color transitions** smoothly

---

## SCREEN 10: PROGRESS HISTORY SCREEN

### Purpose
Enable students to track their learning journey over time.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | Progress History                 │
├──────────────────────────────────────────────┤
│  STATISTICS CARDS                            │
│  ┌─────────────┐ ┌─────────────┐            │
│  │ Total Quizzes│ │Study Score  │            │
│  │     42      │ │    350      │            │
│  └─────────────┘ └─────────────┘            │
│  ┌─────────────┐ ┌─────────────┐            │
│  │ Best Streak │ │ Avg Score   │            │
│  │  12 days    │ │   72%       │            │
│  └─────────────┘ └─────────────┘            │
├──────────────────────────────────────────────┤
│  RECENT ATTEMPTS (Scrollable)                │
│  ┌────────────────────────────────────────┐ │
│  │ 📐 Mathematics - Real Numbers          │ │
│  │ Score: 5/5 (100%) 🟢                   │ │
│  │ Date: Today, 3:45 PM                   │ │
│  │ Points Earned: +10                     │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🔬 Science - Chemical Reactions        │ │
│  │ Score: 3/5 (60%) 🟡                    │ │
│  │ Date: Yesterday, 5:20 PM               │ │
│  │ Points Earned: +0                      │ │
│  └────────────────────────────────────────┘ │
│  ┌────────────────────────────────────────┐ │
│  │ 🌍 Social - Nationalism in Europe      │ │
│  │ Score: 4/5 (80%) 🟢                    │ │
│  │ Date: 2 days ago                       │ │
│  │ Points Earned: +10                     │ │
│  └────────────────────────────────────────┘ │
│  ... (More attempts)                         │
├──────────────────────────────────────────────┤
│  SCORE TREND CHART                           │
│  ┌────────────────────────────────────────┐ │
│  │   Score Trend (Last 30 Days)           │ │
│  │   100%│        ●                        │ │
│  │      │      ●   ●                       │ │
│  │    50│    ●       ●                     │ │
│  │      │  ●           ●                   │ │
│  │     0└──────────────────────────────    │ │
│  └────────────────────────────────────────┘ │
└──────────────────────────────────────────────┘
```

### Data Displayed

| Component | Data Source |
|-----------|-------------|
| **Total Quizzes** | Count of all QuizAttempt records |
| **Study Score** | Sum from UserProgress table |
| **Best Streak** | Longest consecutive study days |
| **Average Score** | Mean of all quiz percentages |
| **Recent Attempts** | Last 10-20 quiz attempts |
| **Score Trend** | Line chart of scores over time |

### Filtering Options
- 📅 **By Date Range**: Last 7 days, 30 days, All time
- 📚 **By Subject**: Mathematics, Science, Social Studies, All
- 🎯 **By Mastery Level**: Green, Amber, Red, All

### Sorting Options
- 🕒 **Most Recent** (default)
- 📊 **Highest Score**
- 📉 **Lowest Score**
- 📖 **By Subject**

---

## SCREEN 11: SETTINGS SCREEN

### Purpose
Allow users to customize app preferences.

### UI Layout

```
┌──────────────────────────────────────────────┐
│  TOP BAR                                     │
│  ← [Back] | Settings                         │
├──────────────────────────────────────────────┤
│  NOTIFICATION SETTINGS                       │
│  ┌────────────────────────────────────────┐ │
│  │ Daily Reminder                         │ │
│  │ [Toggle: ON]                           │ │
│  │                                        │ │
│  │ Reminder Time: 6:00 PM                 │ │
│  │ [Time Picker]                          │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  DISPLAY SETTINGS                            │
│  ┌────────────────────────────────────────┐ │
│  │ Theme                                  │ │
│  │ ○ Light  ● Auto  ○ Dark                │ │
│  │                                        │ │
│  │ Language                               │ │
│  │ English [Dropdown]                     │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  DATA MANAGEMENT                             │
│  ┌────────────────────────────────────────┐ │
│  │ [RESET PROGRESS]                       │ │
│  │ (Warning: This will delete all data)   │ │
│  │                                        │ │
│  │ [EXPORT PROGRESS]                      │ │
│  │ Download your data as CSV              │ │
│  └────────────────────────────────────────┘ │
├──────────────────────────────────────────────┤
│  ABOUT                                       │
│  ┌────────────────────────────────────────┐ │
│  │ Version: 1.0.0                         │ │
│  │ Developed for rural SSLC students      │ │
│  │                                        │ │
│  │ [PRIVACY POLICY]                       │ │
│  │ [TERMS OF SERVICE]                     │ │
│  └────────────────────────────────────────┘ │
└──────────────────────────────────────────────┘
```

### Features to Implement
- ✅ **Daily Reminder Toggle** (enable/disable)
- ✅ **Notification Time Picker** (default: 6:00 PM)
- ✅ **Theme Selection** (Light/Dark/Auto)
- ✅ **Language Preference** (Future: Kannada, Hindi, etc.)
- ⚠️ **Reset Progress** (with confirmation dialog)
- 📤 **Export Data** (CSV format)

---

# 7. DATABASE STRUCTURE

## Entity Relationship Diagram (ERD)

```
┌─────────────────────┐       ┌─────────────────────┐
│     Chapter         │       │     Question        │
├─────────────────────┤       ├─────────────────────┤
│ PK: id              │───┐   │ PK: id              │
│ subject             │   │   │ FK: chapterId       │
│ chapterNumber       │   └───│ questionNumber      │
│ chapterName         │       │ questionText        │
│ summary             │       │ optionA             │
│ keyConcepts (JSON)  │       │ optionB             │
│ isCompleted         │       │ optionC             │
│ bestScore           │       │ optionD             │
│ bestPercentage      │       │ correctAnswer       │
│ totalAttempts       │       │ explanation         │
│ lastAttemptDate     │       │ conceptTag          │
│ masteryLevel        │       │ difficulty          │
│ createdAt           │       └─────────────────────┘
│ updatedAt           │
└─────────────────────┘
         │
         │ 1:N
         │
         ▼
┌─────────────────────┐
│   QuizAttempt       │
├─────────────────────┤
│ PK: id              │
│ FK: chapterId       │
│ score               │
│ percentage          │
│ totalQuestions      │
│ userAnswers (JSON)  │
│ wrongQuestIds(JSON) │
│ timeTakenSeconds    │
│ attemptDate         │
└─────────────────────┘

┌─────────────────────┐       ┌─────────────────────┐
│   UserProgress      │       │   DailyStreak       │
├─────────────────────┤       ├─────────────────────┤
│ PK: id (1)          │       │ PK: date (String)   │
│ totalStudyScore     │       │ quizzesCompleted    │
│ currentStreak       │       │ chaptersStudied     │
│ longestStreak       │       │ studyScore          │
│ totalChapters       │       │ totalTimeMinutes    │
│ completedChapters   │       │ timestamp           │
│ masteredChapters    │       └─────────────────────┘
│ mathProgress        │
│ scienceProgress     │
│ socialProgress      │
│ lastStudyDate       │
│ updatedAt           │
└─────────────────────┘
```

---

## Room Database Entities (Kotlin)

### 1. Chapter Entity

```kotlin
@Entity(tableName = "chapters")
data class Chapter(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    val subject: String,              // "Mathematics", "Science", "Social Studies"
    val chapterNumber: Int,           // 1-15
    val chapterName: String,          // e.g., "Real Numbers"
    
    val summary: String,              // Chapter description (2-3 sentences)
    val keyConcepts: String,          // JSON array: ["concept1", "concept2"]
    
    val isCompleted: Boolean = false, // true if bestScore >= 70%
    val bestScore: Int = 0,           // 0-5
    val bestPercentage: Float = 0f,   // 0-100
    val totalAttempts: Int = 0,       // Number of quiz attempts
    val lastAttemptDate: Long? = null,// Timestamp
    
    val masteryLevel: String = "RED", // "RED", "AMBER", "GREEN"
    
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
```

---

### 2. Question Entity

```kotlin
@Entity(
    tableName = "questions",
    foreignKeys = [
        ForeignKey(
            entity = Chapter::class,
            parentColumns = ["id"],
            childColumns = ["chapterId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("chapterId")]
)
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    val chapterId: Long,              // Foreign key
    val questionNumber: Int,          // 1-5
    
    val questionText: String,         // The question
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    
    val correctAnswer: String,        // "A", "B", "C", or "D"
    val explanation: String,          // Explanation of answer
    
    val conceptTag: String,           // For AI hint generation
    val difficulty: String = "MEDIUM" // "EASY", "MEDIUM", "HARD"
)
```

---

### 3. QuizAttempt Entity

```kotlin
@Entity(
    tableName = "quiz_attempts",
    foreignKeys = [
        ForeignKey(
            entity = Chapter::class,
            parentColumns = ["id"],
            childColumns = ["chapterId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("chapterId")]
)
data class QuizAttempt(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    val chapterId: Long,
    
    val score: Int,                   // 0-5
    val percentage: Float,            // 0-100
    val totalQuestions: Int = 5,
    
    val userAnswers: String,          // JSON: ["A", "B", "C", "D", "A"]
    val wrongQuestionIds: String,     // JSON: [2, 5]
    
    val timeTakenSeconds: Int,        // Time in seconds
    val attemptDate: Long = System.currentTimeMillis()
)
```

---

### 4. UserProgress Entity

```kotlin
@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey
    val id: Int = 1,                  // Single row
    
    val totalStudyScore: Int = 0,     // Points earned
    val currentStreak: Int = 0,       // Consecutive days
    val longestStreak: Int = 0,       // Best streak record
    
    val totalChapters: Int = 45,      // 15 per subject
    val completedChapters: Int = 0,   // Chapters with score >= 70%
    val masteredChapters: Int = 0,    // Green chapters
    
    val mathProgress: Float = 0f,     // 0-100%
    val scienceProgress: Float = 0f,  // 0-100%
    val socialProgress: Float = 0f,   // 0-100%
    
    val lastStudyDate: String = "",   // "yyyy-MM-dd"
    val updatedAt: Long = System.currentTimeMillis()
)
```

---

### 5. DailyStreak Entity

```kotlin
@Entity(tableName = "daily_streaks")
data class DailyStreak(
    @PrimaryKey
    val date: String,                 // "yyyy-MM-dd" (unique per day)
    
    val quizzesCompleted: Int = 0,    // Number of quizzes
    val chaptersStudied: Int = 0,     // Unique chapters
    val studyScore: Int = 0,          // Points earned today
    val totalTimeMinutes: Int = 0,    // Study duration
    
    val timestamp: Long = System.currentTimeMillis()
)
```

---

## Type Converters

```kotlin
class Converters {
    private val gson = Gson()
    
    @TypeConverter
    fun fromStringList(value: List<String>): String = gson.toJson(value)
    
    @TypeConverter
    fun toStringList(value: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
    
    @TypeConverter
    fun fromLongList(value: List<Long>): String = gson.toJson(value)
    
    @TypeConverter
    fun toLongList(value: String): List<Long> {
        val type = object : TypeToken<List<Long>>() {}.type
        return gson.fromJson(value, type)
    }
}
```

---

# 8. BACKEND LOGIC & ALGORITHMS

## 8.1 Study Score Calculation

### Rules
```kotlin
fun calculateStudyScore(quizPercentage: Float, currentStreak: Int): Int {
    val basePoints = if (quizPercentage >= 70f) 10 else 0
    
    val streakMultiplier = if (currentStreak >= 5) 1.5f else 1.0f
    
    return (basePoints * streakMultiplier).toInt()
}
```

### Example
```
Quiz Score: 80% → Base Points: 10
Current Streak: 7 days → Multiplier: 1.5
Final Points: 10 × 1.5 = 15 points
```

---

## 8.2 Mastery Level Calculation

### Algorithm
```kotlin
fun calculateMasteryLevel(bestPercentage: Float): String {
    return when {
        bestPercentage >= 70f -> "GREEN"   // Mastered
        bestPercentage >= 40f -> "AMBER"   // Needs Revision
        else -> "RED"                       // Weak
    }
}
```

### Color Mapping
| Percentage | Mastery Level | Color | Icon |
|------------|---------------|-------|------|
| 70-100%    | Mastered      | 🟢 Green | ✅ |
| 40-69%     | Needs Revision | 🟡 Amber | ⚠️ |
| 0-39%      | Weak          | 🔴 Red | ❌ |

---

## 8.3 Streak Calculation

### Algorithm
```kotlin
suspend fun updateStreak(currentDate: String) {
    val userProgress = userProgressDao.getUserProgressSync() ?: return
    val lastDate = userProgress.lastStudyDate
    
    val streak = when {
        lastDate.isEmpty() -> 1
        isConsecutiveDay(lastDate, currentDate) -> userProgress.currentStreak + 1
        else -> 1
    }
    
    val longestStreak = max(userProgress.longestStreak, streak)
    
    userProgressDao.updateStreaks(streak, longestStreak)
    userProgressDao.updateProgress(
        userProgress.copy(lastStudyDate = currentDate)
    )
}

fun isConsecutiveDay(lastDate: String, currentDate: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val last = LocalDate.parse(lastDate, formatter)
    val current = LocalDate.parse(currentDate, formatter)
    return ChronoUnit.DAYS.between(last, current) == 1L
}
```

---

## 8.4 Chapter Completion Logic

### Rules
```kotlin
suspend fun updateChapterCompletion(chapterId: Long, score: Int, totalQuestions: Int) {
    val percentage = (score.toFloat() / totalQuestions) * 100
    
    val isCompleted = percentage >= 70f
    val masteryLevel = calculateMasteryLevel(percentage)
    
    val chapter = chapterDao.getChapterByIdSync(chapterId)
    
    // Only update if new score is better
    if (chapter != null && score > chapter.bestScore) {
        chapterDao.updateChapterProgress(
            chapterId = chapterId,
            score = score,
            percentage = percentage,
            date = System.currentTimeMillis(),
            masteryLevel = masteryLevel,
            isCompleted = isCompleted
        )
    }
    
    // Update total completed chapters count
    val completedCount = chapterDao.getCompletedChaptersCount()
    userProgressDao.updateCompletedChapters(completedCount)
}
```

---

## 8.5 Subject Progress Calculation

### Algorithm
```kotlin
suspend fun calculateSubjectProgress(subject: String): Float {
    val completedChapters = chapterDao.getCompletedChaptersBySubject(subject)
    val totalChapters = chapterDao.getTotalChaptersBySubject(subject)
    
    return if (totalChapters > 0) {
        (completedChapters.toFloat() / totalChapters) * 100
    } else {
        0f
    }
}

suspend fun updateAllSubjectProgress() {
    val mathProgress = calculateSubjectProgress("Mathematics")
    val scienceProgress = calculateSubjectProgress("Science")
    val socialProgress = calculateSubjectProgress("Social Studies")
    
    val userProgress = userProgressDao.getUserProgressSync()
    userProgressDao.updateProgress(
        userProgress?.copy(
            mathProgress = mathProgress,
            scienceProgress = scienceProgress,
            socialProgress = socialProgress
        ) ?: UserProgress()
    )
}
```

---

# 9. OFFLINE-FIRST ARCHITECTURE

## Requirements

The application **MUST** function completely offline after initial setup.

### Offline Capabilities Required

| Feature | Offline Status |
|---------|----------------|
| ✅ View subjects and chapters | **Fully offline** |
| ✅ Take quizzes | **Fully offline** |
| ✅ View results | **Fully offline** |
| ✅ Track progress | **Fully offline** |
| ✅ View strength map | **Fully offline** |
| ✅ View history | **Fully offline** |
| ⚠️ AI hints | **Requires internet** (optional) |
| ✅ Daily reminders | **Fully offline** |

---

## Data Persistence Strategy

### Room Database
- All questions preloaded during app installation
- All user progress stored locally
- No server sync required
- Data persists across app restarts

### Data Seeding
```kotlin
// On first app launch
suspend fun seedDatabase() {
    if (isDatabaseEmpty()) {
        // Insert all 45 chapters
        insertChapters()
        
        // Insert all 225 questions (5 per chapter)
        insertQuestions()
        
        // Initialize user progress
        insertUserProgress()
    }
}
```

---

## Offline Quiz Flow

```
User clicks "Start Quiz"
     ↓
Load questions from Room DB
     ↓
Display quiz offline
     ↓
User submits quiz
     ↓
Calculate score locally
     ↓
Save to Room DB
     ↓
Update mastery offline
     ↓
Show results
```

---

## Network Handling for AI Hints

```kotlin
suspend fun generateHint(question: Question, userAnswer: String): String? {
    return if (isNetworkAvailable()) {
        try {
            geminiApi.generateHint(question, userAnswer)
        } catch (e: Exception) {
            Log.e("AI", "Hint generation failed", e)
            null // Gracefully degrade
        }
    } else {
        null // No internet, skip AI hint
    }
}

// UI displays fallback
if (aiHint != null) {
    Text("🤖 AI Hint: $aiHint")
} else {
    Text("💡 Review the explanation to understand the concept")
}
```

---

# 10. GENAI INTEGRATION REQUIREMENTS

## 10.1 Gemini API Usage

### When to Call Gemini API
- **ONLY** when a student answers a question **incorrectly**
- **ONLY** if network is available (optional feature)

### API Configuration
```kotlin
// build.gradle.kts
buildConfigField("String", "GEMINI_API_KEY", "\"${project.findProperty("GEMINI_API_KEY")}\"")

// GeminiApiService.kt
class GeminiApiService {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = BuildConfig.GEMINI_API_KEY
    )
    
    suspend fun generateHint(
        subject: String,
        chapter: String,
        questionText: String,
        correctAnswer: String,
        userAnswer: String,
        conceptTag: String
    ): String {
        val prompt = """
            You are a helpful tutor for Class 10 SSLC students.
            
            Subject: $subject
            Chapter: $chapter
            Concept: $conceptTag
            
            Question: $questionText
            Student's Answer: $userAnswer
            Correct Answer: $correctAnswer
            
            Provide a 2-sentence conceptual hint that:
            1. Explains the underlying concept
            2. Does NOT reveal the direct answer
            3. Uses simple, beginner-friendly language
            4. Encourages the student to think
            
            Hint:
        """.trimIndent()
        
        val response = generativeModel.generateContent(prompt)
        return response.text ?: "Review the concept and try again."
    }
}
```

---

## 10.2 AI Hint Rules & Guidelines

### ✅ DO's
1. **Explain the concept** behind the question
2. **Use simple language** appropriate for 10th graders
3. **Encourage thinking** and understanding
4. **Keep to 2 sentences** maximum
5. **Be encouraging** and supportive

### ❌ DON'Ts
1. **Don't reveal** the direct answer
2. **Don't solve** the problem step-by-step
3. **Don't use** complex terminology
4. **Don't exceed** 2 sentences
5. **Don't be** discouraging

---

## 10.3 Example AI Hint Generation

### Example 1: Mathematics

**Question**: "The HCF of 96 and 404 is?"
**Student Answer**: "C (12)" ❌ Wrong
**Correct Answer**: "A (4)"

**AI Hint**:
> "HCF is found using Euclid's Division Algorithm where we repeatedly divide and take remainders. Start by dividing 404 by 96 and continue the process until the remainder becomes zero."

---

### Example 2: Science

**Question**: "In the reaction Zn + CuSO₄ → ZnSO₄ + Cu, which element is oxidized?"
**Student Answer**: "B (Copper)" ❌ Wrong
**Correct Answer**: "A (Zinc)"

**AI Hint**:
> "Oxidation means losing electrons, while reduction means gaining electrons. Look at which metal atom becomes an ion by losing electrons in this reaction."

---

### Example 3: Social Studies

**Question**: "The French Revolution began in the year?"
**Student Answer**: "B (1799)" ❌ Wrong
**Correct Answer**: "A (1789)"

**AI Hint**:
> "The French Revolution started with the storming of the Bastille prison in July. This historic event marked the beginning of radical changes in French society and occurred in the late 18th century."

---

## 10.4 Error Handling for AI Hints

```kotlin
suspend fun getAIHint(question: Question, userAnswer: String): String {
    return try {
        if (!NetworkUtils.isOnline(context)) {
            return "💡 No internet connection. Review the explanation below."
        }
        
        val hint = geminiApiService.generateHint(
            subject = question.subject,
            chapter = question.chapter,
            questionText = question.questionText,
            correctAnswer = question.correctAnswer,
            userAnswer = userAnswer,
            conceptTag = question.conceptTag
        )
        
        hint.take(200) // Limit hint length
        
    } catch (e: Exception) {
        Log.e("AI", "Failed to generate hint", e)
        "💡 Review the explanation to understand the concept better."
    }
}
```

---

# 11. FRONTEND DESIGN GUIDELINES

## 11.1 UI Design Principles

### Core Principles
1. **Simplicity First** - Clean, uncluttered interfaces
2. **Large Touch Targets** - Buttons minimum 48dp height
3. **High Contrast** - WCAG AA compliance (4.5:1 ratio)
4. **Readable Text** - Minimum 14sp body text
5. **Offline Indicators** - Clear visual cues

---

## 11.2 Color Palette

### Primary Colors
```kotlin
val PrimaryBlue = Color(0xFF1976D2)      // Main brand color
val PrimaryBlueLight = Color(0xFF63A4FF)
val PrimaryBlueDark = Color(0xFF004BA0)
```

### Mastery Colors
```kotlin
val MasteryGreen = Color(0xFF4CAF50)     // 🟢 Mastered
val MasteryAmber = Color(0xFFFFA726)     // 🟡 Needs Revision
val MasteryRed = Color(0xFFF44336)       // 🔴 Weak
```

### Subject Colors
```kotlin
val MathematicsColor = Color(0xFF2196F3) // Blue
val ScienceColor = Color(0xFF4CAF50)     // Green
val SocialStudiesColor = Color(0xFFFF9800) // Orange
```

### Semantic Colors
```kotlin
val SuccessGreen = Color(0xFF66BB6A)
val WarningYellow = Color(0xFFFFA726)
val ErrorRed = Color(0xFFEF5350)
val InfoBlue = Color(0xFF42A5F5)
```

---

## 11.3 Typography

### Text Styles
```kotlin
// Headings
displayLarge: 34.sp, FontWeight.Bold
displayMedium: 28.sp, FontWeight.Bold
displaySmall: 24.sp, FontWeight.Bold

// Titles
titleLarge: 20.sp, FontWeight.SemiBold
titleMedium: 16.sp, FontWeight.Medium
titleSmall: 14.sp, FontWeight.Medium

// Body
bodyLarge: 16.sp, FontWeight.Normal
bodyMedium: 14.sp, FontWeight.Normal
bodySmall: 12.sp, FontWeight.Normal
```

---

## 11.4 Spacing & Layout

### Padding Guidelines
```kotlin
val PaddingXSmall = 4.dp
val PaddingSmall = 8.dp
val PaddingMedium = 16.dp
val PaddingLarge = 24.dp
val PaddingXLarge = 32.dp
```

### Component Sizes
```kotlin
val ButtonHeight = 56.dp
val CardElevation = 2.dp
val CardCornerRadius = 12.dp
val IconSize = 24.dp
val AvatarSize = 48.dp
```

---

## 11.5 UI Inspiration References

### Duolingo-Style Elements
- ✅ Gamified progress indicators
- ✅ Streak celebrations
- ✅ Colorful subject cards
- ✅ Achievement badges

### Khan Academy-Style Elements
- ✅ Clean chapter navigation
- ✅ Progress trees
- ✅ Educational icons
- ✅ Mastery indicators

### Notion-Style Elements
- ✅ Minimal layouts
- ✅ Card-based design
- ✅ Clear typography
- ✅ Organized hierarchy

---

## 11.6 Animations & Transitions

### Required Animations
```kotlin
// Screen transitions
val ScreenTransition = slideInHorizontally() + fadeIn()

// Progress bar
val ProgressAnimation = tween(durationMillis = 500)

// Score reveal
val ScoreReveal = spring(dampingRatio = Spring.DampingRatioMediumBouncy)

// Mastery color change
val ColorTransition = animateColorAsState(targetValue = masteryColor)
```

---

## 11.7 Accessibility Requirements

### WCAG Compliance
- ✅ Color contrast ratio ≥ 4.5:1
- ✅ Touch targets ≥ 48dp
- ✅ Text size ≥ 14sp
- ✅ Clear focus indicators
- ✅ Screen reader support

### Low-End Device Optimization
- ✅ Works on 2GB RAM devices
- ✅ Minimal animations (optional)
- ✅ Efficient image loading
- ✅ Database query optimization

---

# 12. TECHNICAL ARCHITECTURE

## 12.1 Technology Stack

| Layer | Technology | Version |
|-------|------------|---------|
| **Language** | Kotlin | 1.9.20 |
| **UI Framework** | Jetpack Compose | 1.5.4 |
| **Architecture** | MVVM | - |
| **Database** | Room | 2.6.1 |
| **State Management** | StateFlow | - |
| **Dependency Injection** | Hilt / Manual | Optional |
| **Background Tasks** | WorkManager | 2.9.0 |
| **AI Integration** | Gemini API | 0.1.2 |
| **Networking** | Retrofit (optional) | 2.9.0 |
| **JSON Parsing** | Gson | 2.10.1 |

---

## 12.2 MVVM Architecture Diagram

```
┌─────────────────────────────────────────────┐
│            PRESENTATION LAYER               │
│  ┌───────────────────────────────────────┐  │
│  │      Composable Screens (UI)          │  │
│  │  • SplashScreen                       │  │
│  │  • MissionMapScreen                   │  │
│  │  • QuizScreen                         │  │
│  └───────────────┬───────────────────────┘  │
└──────────────────┼──────────────────────────┘
                   │ observes StateFlow
┌──────────────────▼──────────────────────────┐
│             VIEWMODEL LAYER                 │
│  ┌───────────────────────────────────────┐  │
│  │         ViewModels                    │  │
│  │  • MissionMapViewModel                │  │
│  │  • QuizViewModel                      │  │
│  │  • ResultViewModel                    │  │
│  │                                       │  │
│  │  StateFlow<UiState>                   │  │
│  │  suspend fun loadData()               │  │
│  └───────────────┬───────────────────────┘  │
└──────────────────┼──────────────────────────┘
                   │ calls
┌──────────────────▼──────────────────────────┐
│           REPOSITORY LAYER                  │
│  ┌───────────────────────────────────────┐  │
│  │        Repositories                   │  │
│  │  • ChapterRepository                  │  │
│  │  • QuizRepository                     │  │
│  │  • ProgressRepository                 │  │
│  └───────────────┬───────────────────────┘  │
└──────────────────┼──────────────────────────┘
                   │ accesses
┌──────────────────▼──────────────────────────┐
│              DATA LAYER                     │
│  ┌───────────────────────────────────────┐  │
│  │   Room Database       Gemini API      │  │
│  │   • ChapterDao        • HintService   │  │
│  │   • QuestionDao                       │  │
│  │   • QuizAttemptDao                    │  │
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
```

---

## 12.3 Project Folder Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/aksharadeepа/tutor/
│   │   │   ├── data/
│   │   │   │   ├── local/
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── ChapterDao.kt
│   │   │   │   │   │   ├── QuestionDao.kt
│   │   │   │   │   │   ├── QuizAttemptDao.kt
│   │   │   │   │   │   ├── UserProgressDao.kt
│   │   │   │   │   │   └── StreakDao.kt
│   │   │   │   │   ├── entities/
│   │   │   │   │   │   ├── Chapter.kt
│   │   │   │   │   │   ├── Question.kt
│   │   │   │   │   │   ├── QuizAttempt.kt
│   │   │   │   │   │   ├── UserProgress.kt
│   │   │   │   │   │   └── DailyStreak.kt
│   │   │   │   │   ├── database/
│   │   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   │   ├── Converters.kt
│   │   │   │   │   │   └── DatabaseSeeder.kt
│   │   │   │   │   └── preferences/
│   │   │   │   │       └── UserPreferences.kt
│   │   │   │   ├── remote/
│   │   │   │   │   ├── GeminiApiService.kt
│   │   │   │   │   └── NetworkUtils.kt
│   │   │   │   └── repository/
│   │   │   │       ├── ChapterRepository.kt
│   │   │   │       ├── QuizRepository.kt
│   │   │   │       ├── ProgressRepository.kt
│   │   │   │       └── StreakRepository.kt
│   │   │   ├── domain/
│   │   │   │   ├── model/
│   │   │   │   │   ├── Subject.kt
│   │   │   │   │   ├── MasteryLevel.kt
│   │   │   │   │   └── QuizResult.kt
│   │   │   │   └── usecase/
│   │   │   │       ├── GetChaptersUseCase.kt
│   │   │   │       ├── SubmitQuizUseCase.kt
│   │   │   │       └── UpdateProgressUseCase.kt
│   │   │   ├── presentation/
│   │   │   │   ├── navigation/
│   │   │   │   │   ├── NavGraph.kt
│   │   │   │   │   └── Screen.kt
│   │   │   │   ├── theme/
│   │   │   │   │   ├── Color.kt
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   └── Type.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── ChapterCard.kt
│   │   │   │   │   ├── SubjectCard.kt
│   │   │   │   │   ├── QuestionCard.kt
│   │   │   │   │   └── ProgressBar.kt
│   │   │   │   ├── screens/
│   │   │   │   │   ├── splash/
│   │   │   │   │   │   ├── SplashScreen.kt
│   │   │   │   │   │   └── SplashViewModel.kt
│   │   │   │   │   ├── welcome/
│   │   │   │   │   │   └── WelcomeScreen.kt
│   │   │   │   │   ├── dashboard/
│   │   │   │   │   │   ├── MissionMapScreen.kt
│   │   │   │   │   │   └── MissionMapViewModel.kt
│   │   │   │   │   ├── chapters/
│   │   │   │   │   │   ├── ChapterListScreen.kt
│   │   │   │   │   │   ├── ChapterOverviewScreen.kt
│   │   │   │   │   │   └── ChapterViewModel.kt
│   │   │   │   │   ├── quiz/
│   │   │   │   │   │   ├── QuizScreen.kt
│   │   │   │   │   │   ├── QuizViewModel.kt
│   │   │   │   │   │   ├── QuizResultScreen.kt
│   │   │   │   │   │   └── ReviewAnswersScreen.kt
│   │   │   │   │   ├── strength/
│   │   │   │   │   │   ├── StrengthMapScreen.kt
│   │   │   │   │   │   └── StrengthMapViewModel.kt
│   │   │   │   │   ├── progress/
│   │   │   │   │   │   ├── ProgressHistoryScreen.kt
│   │   │   │   │   │   └── ProgressViewModel.kt
│   │   │   │   │   └── settings/
│   │   │   │   │       └── SettingsScreen.kt
│   │   │   │   └── MainActivity.kt
│   │   │   ├── workers/
│   │   │   │   └── DailyReminderWorker.kt
│   │   │   └── util/
│   │   │       ├── Constants.kt
│   │   │       ├── DateUtils.kt
│   │   │       └── Extensions.kt
│   │   ├── res/
│   │   │   ├── drawable/
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   └── xml/
│   │   │       └── backup_rules.xml
│   │   └── AndroidManifest.xml
│   └── test/
│       └── java/com/aksharadeepа/tutor/
└── build.gradle.kts
```

---

## 12.4 Dependency Injection Setup (Optional)

### Manual DI (Simpler)
```kotlin
object AppContainer {
    private lateinit var database: AppDatabase
    
    fun init(context: Context) {
        database = AppDatabase.getDatabase(context)
    }
    
    val chapterRepository: ChapterRepository by lazy {
        ChapterRepository(database.chapterDao())
    }
    
    val quizRepository: QuizRepository by lazy {
        QuizRepository(
            database.questionDao(),
            database.quizAttemptDao()
        )
    }
}
```

### Hilt DI (Advanced)
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
    
    @Provides
    fun provideChapterDao(db: AppDatabase) = db.chapterDao()
    
    @Provides
    fun provideQuestionDao(db: AppDatabase) = db.questionDao()
}
```

---

# 13. NON-FUNCTIONAL REQUIREMENTS

## 13.1 Performance Requirements

| Metric | Target | Critical |
|--------|--------|----------|
| **App Launch Time** | < 2 seconds | ✅ |
| **Quiz Load Time** | < 1 second | ✅ |
| **Screen Transition** | < 300ms | ✅ |
| **Database Query Time** | < 100ms | ✅ |
| **APK Size** | < 20 MB | ⚠️ |

---

## 13.2 Compatibility Requirements

### Android Version Support
```gradle
minSdk = 26  // Android 8.0 Oreo
targetSdk = 34  // Android 14
compileSdk = 34
```

### Device Requirements
- **RAM**: Minimum 2GB (optimized for low-end devices)
- **Storage**: 50MB free space
- **Screen Size**: 5" to 6.5" (responsive layouts)
- **Resolution**: 720p minimum

---

## 13.3 Accessibility Requirements

### WCAG 2.1 Level AA Compliance
- ✅ Text contrast ratio ≥ 4.5:1
- ✅ Touch targets ≥ 48dp × 48dp
- ✅ Scalable fonts (support system font size)
- ✅ Screen reader support (TalkBack)
- ✅ Color is not the only visual cue

### Example Implementation
```kotlin
@Composable
fun AccessibleButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(56.dp)  // Minimum touch target
            .semantics {
                contentDescription = text
                role = Role.Button
            }
    ) {
        Text(
            text = text,
            fontSize = 16.sp,  // Readable size
            fontWeight = FontWeight.SemiBold
        )
    }
}
```

---

## 13.4 Reliability Requirements

### Data Persistence
- ✅ All progress must persist across app restarts
- ✅ Database writes must be atomic
- ✅ No data loss on app crashes
- ✅ Backup and restore capability

### Error Handling
```kotlin
try {
    val result = quizRepository.submitQuiz(answers)
    _uiState.value = QuizUiState.Success(result)
} catch (e: Exception) {
    Log.e("QuizViewModel", "Failed to submit quiz", e)
    _uiState.value = QuizUiState.Error("Failed to save. Please try again.")
}
```

---

## 13.5 Security Requirements

### Data Privacy
- ✅ All data stored locally (no cloud sync)
- ✅ No personal information collected
- ✅ No third-party analytics
- ✅ Gemini API key secured in BuildConfig

### API Key Protection
```kotlin
// local.properties (not in version control)
GEMINI_API_KEY=your_api_key_here

// build.gradle.kts
buildConfigField("String", "GEMINI_API_KEY", 
    "\"${project.findProperty("GEMINI_API_KEY")}\"")
```

---

## 13.6 Usability Requirements

### Learning Curve
- ✅ First-time users should understand the app within **5 minutes**
- ✅ No tutorial required (intuitive design)
- ✅ Clear visual hierarchy
- ✅ Consistent navigation patterns

### User Feedback
- ✅ Loading indicators for async operations
- ✅ Success/error messages for actions
- ✅ Haptic feedback on important actions
- ✅ Visual confirmation of selections

---

# 14. ACCEPTANCE CRITERIA

## 14.1 Must-Have Features (MVP)

| # | Feature | Status |
|---|---------|--------|
| 1 | Splash screen with branding | ✅ Required |
| 2 | Welcome screen (first launch only) | ✅ Required |
| 3 | Mission Map dashboard | ✅ Required |
| 4 | 3 subjects with 15 chapters each | ✅ Required |
| 5 | Chapter overview screen | ✅ Required |
| 6 | Quiz system (5 MCQs per chapter) | ✅ Required |
| 7 | Timer functionality | ✅ Required |
| 8 | Score calculation | ✅ Required |
| 9 | Quiz result screen | ✅ Required |
| 10 | Mastery level tracking (RED/AMBER/GREEN) | ✅ Required |
| 11 | Progress persistence (Room DB) | ✅ Required |
| 12 | Strength map visualization | ✅ Required |
| 13 | Progress history screen | ✅ Required |
| 14 | Study score system | ✅ Required |
| 15 | Daily streak tracking | ✅ Required |
| 16 | Daily reminder notifications (WorkManager) | ✅ Required |
| 17 | AI hint generation (Gemini API) | ✅ Required |
| 18 | Review answers screen | ✅ Required |
| 19 | Offline functionality | ✅ Required |
| 20 | Settings screen | ⚠️ Nice to have |

---

## 14.2 Testing Checklist

### Functional Testing
- [ ] User can navigate through all screens
- [ ] Quizzes load correctly (5 questions)
- [ ] Timer counts down properly
- [ ] Answers can be selected
- [ ] Quiz can be submitted
- [ ] Score is calculated correctly
- [ ] Mastery level updates correctly
- [ ] Progress persists after app restart
- [ ] Strength map displays correctly
- [ ] History shows all attempts
- [ ] Daily reminders work
- [ ] AI hints generate (when online)

### UI/UX Testing
- [ ] All screens follow design guidelines
- [ ] Color contrast is WCAG compliant
- [ ] Touch targets are ≥48dp
- [ ] Text is readable (≥14sp)
- [ ] Animations are smooth
- [ ] Loading states are shown
- [ ] Error messages are clear

### Performance Testing
- [ ] App launches in <2 seconds
- [ ] Quizzes load in <1 second
- [ ] Database queries are fast
- [ ] No memory leaks
- [ ] Works on 2GB RAM devices
- [ ] APK size is reasonable

### Offline Testing
- [ ] App works without internet
- [ ] Quizzes function offline
- [ ] Progress saves offline
- [ ] AI hints degrade gracefully
- [ ] Notifications work offline

---

## 14.3 Success Metrics

### User Engagement
- **Daily Active Users**: Students use app at least once per day
- **Completion Rate**: 70% of started quizzes are completed
- **Streak Retention**: 40% of users maintain 5+ day streak

### Learning Outcomes
- **Score Improvement**: Average score increases over time
- **Mastery Growth**: More chapters turn GREEN over time
- **Consistency**: Students complete at least 1 quiz daily

### Technical Metrics
- **Crash-Free Rate**: >99%
- **App Rating**: >4.0 stars
- **Load Time**: <2 seconds

---

# 15. QUESTION DATABASE - COMPLETE DATASET

## 15.1 MATHEMATICS (15 Chapters × 5 Questions = 75 Questions)

### Chapter 1: Real Numbers

1. **Question**: The decimal expansion of 14587/1250 will terminate after how many decimal places?
   - A. 1
   - B. 2
   - C. 3
   - **D. 4** ✅
   - **Explanation**: 1250 = 2 × 5⁴. Maximum power is 4, so 4 decimal places.

2. **Question**: The HCF of 96 and 404 is:
   - **A. 4** ✅
   - B. 8
   - C. 12
   - D. 2
   - **Explanation**: Using Euclid's Division Algorithm: HCF = 4

3. **Question**: Which of the following is an irrational number?
   - A. √16
   - B. √(4/9)
   - **C. √12** ✅
   - D. √100
   - **Explanation**: √12 = 2√3, which is irrational.

4. **Question**: The product of a non-zero rational and an irrational number is:
   - A. Always rational
   - **B. Always irrational** ✅
   - C. Rational or irrational
   - D. Zero
   - **Explanation**: Non-zero rational × irrational = always irrational.

5. **Question**: The prime factorization of 3825 is:
   - A. 3 × 5² × 51
   - **B. 3² × 5² × 17** ✅
   - C. 5² × 153
   - D. 3 × 5 × 255
   - **Explanation**: 3825 = 3² × 5² × 17

---

### Chapter 2: Polynomials

1. **Question**: The degree of 4x⁴ + 0x³ + 0x² + 5x + 7 is:
   - **A. 4** ✅
   - B. 3
   - C. 2
   - D. 7
   - **Explanation**: Degree is the highest power of x.

2. **Question**: If α and β are zeros of x² - 5x + 6, then α + β equals:
   - **A. 5** ✅
   - B. -5
   - C. 6
   - D. -6
   - **Explanation**: Sum of zeros = -b/a = 5

3. **Question**: A quadratic polynomial whose zeros are 3 and -4 is:
   - A. x² - x - 12
   - **B. x² + x - 12** ✅
   - C. x² - x + 12
   - D. x² + x + 12
   - **Explanation**: x² - (sum)x + product = x² + x - 12

4. **Question**: The value of k for which -2 is a zero of 3x² + 4x + 2k is:
   - **A. 2** ✅
   - B. -2
   - C. 4
   - D. -4
   - **Explanation**: Substitute x = -2 and solve for k.

5. **Question**: The graph of a quadratic polynomial is a:
   - A. Straight line
   - **B. Parabola** ✅
   - C. Circle
   - D. Hyperbola
   - **Explanation**: Quadratic polynomials always form parabolas.

---

### Chapter 3: Pair of Linear Equations in Two Variables

1. **Question**: The pair of equations x + 2y = 5 and 3x + 6y = 15 has:
   - A. Unique solution
   - **B. Infinitely many solutions** ✅
   - C. No solution
   - D. Two solutions
   - **Explanation**: Second equation is 3 times the first (coincident lines).

2. **Question**: If 2x + 3y = 7 and 2x - 3y = 1, then x equals:
   - **A. 2** ✅
   - B. 1
   - C. 3
   - D. 4
   - **Explanation**: Add equations: 4x = 8, x = 2

3. **Question**: The graph of equations x = 3 and y = 4 intersects at:
   - A. (0, 0)
   - B. (3, 0)
   - C. (0, 4)
   - **D. (3, 4)** ✅
   - **Explanation**: Vertical and horizontal lines intersect at (3, 4).

4. **Question**: For the pair ax + by = c and px + qy = r to have a unique solution:
   - **A. a/p ≠ b/q** ✅
   - B. a/p = b/q
   - C. a/p = b/q = c/r
   - D. a = p
   - **Explanation**: Slopes must be different for unique solution.

5. **Question**: The solution of x + y = 14 and x - y = 4 is:
   - A. x = 5, y = 9
   - **B. x = 9, y = 5** ✅
   - C. x = 7, y = 7
   - D. x = 10, y = 4
   - **Explanation**: Add equations: 2x = 18, x = 9; y = 5

---

### Chapter 4: Quadratic Equations

1. **Question**: The roots of x² - 3x + 2 = 0 are:
   - **A. 1, 2** ✅
   - B. -1, -2
   - C. 2, 3
   - D. 1, 3
   - **Explanation**: Factorize: (x-1)(x-2) = 0

2. **Question**: The discriminant of 2x² + 5x + 3 = 0 is:
   - **A. 1** ✅
   - B. -1
   - C. 0
   - D. 2
   - **Explanation**: D = b² - 4ac = 25 - 24 = 1

3. **Question**: If the discriminant of ax² + bx + c = 0 is zero, the roots are:
   - **A. Real and equal** ✅
   - B. Real and distinct
   - C. Not real
   - D. Zero
   - **Explanation**: D = 0 means equal roots.

4. **Question**: The sum of roots of 3x² - 6x + 2 = 0 is:
   - A. -2
   - **B. 2** ✅
   - C. 3
   - D. 6
   - **Explanation**: Sum = -b/a = 6/3 = 2

5. **Question**: If one root of x² + kx + 12 = 0 is 3, then k equals:
   - A. 4
   - **B. -7** ✅
   - C. 7
   - D. -4
   - **Explanation**: Substitute x = 3: 9 + 3k + 12 = 0, k = -7

---

### Chapter 5: Arithmetic Progressions

1. **Question**: The 10th term of the AP 2, 7, 12, ... is:
   - A. 42
   - **B. 47** ✅
   - C. 52
   - D. 57
   - **Explanation**: a₁₀ = a + 9d = 2 + 9(5) = 47

2. **Question**: The common difference of the AP 10, 7, 4, 1, ... is:
   - A. 3
   - **B. -3** ✅
   - C. 4
   - D. -4
   - **Explanation**: d = a₂ - a₁ = 7 - 10 = -3

3. **Question**: The sum of first 20 terms of the AP 5, 8, 11, ... is:
   - A. 610
   - **B. 670** ✅
   - C. 630
   - D. 650
   - **Explanation**: S₂₀ = n/2[2a + (n-1)d] = 10[10 + 57] = 670

4. **Question**: Which term of the AP 3, 8, 13, 18, ... is 78?
   - A. 14th
   - **B. 16th** ✅
   - C. 15th
   - D. 17th
   - **Explanation**: aₙ = a + (n-1)d, 78 = 3 + 5(n-1), n = 16

5. **Question**: The first term of an AP is 5, last term is 45, and sum is 400. Number of terms:
   - A. 14
   - **B. 16** ✅
   - C. 15
   - D. 18
   - **Explanation**: S = n/2(a + l), 400 = n/2(50), n = 16

---

### Chapter 6: Triangles

1. **Question**: If in triangles ABC and DEF, AB/DE = BC/FE = CA/FD, then:
   - **A. △ABC ~ △DEF** ✅
   - B. △ABC ≅ △DEF
   - C. △ABC ~ △EFD
   - D. None
   - **Explanation**: SSS similarity criterion.

2. **Question**: In △ABC, DE || BC. If AD = 3 cm, DB = 2 cm, AE = 4 cm, then EC equals:
   - A. 2 cm
   - **B. 8/3 cm** ✅
   - C. 3 cm
   - D. 4 cm
   - **Explanation**: By Basic Proportionality Theorem: 3/2 = 4/EC

3. **Question**: The areas of two similar triangles are 64 cm² and 121 cm². The ratio of their sides is:
   - **A. 8:11** ✅
   - B. 4:11
   - C. 8:9
   - D. 16:22
   - **Explanation**: Ratio of sides = √(64/121) = 8/11

4. **Question**: If △ABC ~ △PQR and AB/PQ = 3/4, then ar(△ABC)/ar(△PQR) equals:
   - A. 3/4
   - **B. 9/16** ✅
   - C. 4/3
   - D. 16/9
   - **Explanation**: Ratio of areas = (ratio of sides)²

5. **Question**: In a right triangle ABC, ∠B = 90°. If AB = 6 cm and BC = 8 cm, then AC equals:
   - **A. 10 cm** ✅
   - B. 12 cm
   - C. 14 cm
   - D. 9 cm
   - **Explanation**: Pythagoras: AC² = 36 + 64 = 100, AC = 10

---

### Chapter 7: Coordinate Geometry

1. **Question**: The distance between points (3, 4) and (0, 0) is:
   - A. 3
   - B. 4
   - **C. 5** ✅
   - D. 7
   - **Explanation**: d = √(3² + 4²) = 5

2. **Question**: The midpoint of the line joining (2, 3) and (4, 7) is:
   - A. (2, 5)
   - **B. (3, 5)** ✅
   - C. (3, 4)
   - D. (4, 5)
   - **Explanation**: Midpoint = ((2+4)/2, (3+7)/2) = (3, 5)

3. **Question**: The coordinates of the point dividing the join of (1, 2) and (4, 5) in ratio 2:1 are:
   - **A. (3, 4)** ✅
   - B. (2, 3)
   - C. (4, 5)
   - D. (2, 4)
   - **Explanation**: Section formula: ((2×4+1)/3, (2×5+2)/3) = (3, 4)

4. **Question**: The area of triangle with vertices (0,0), (3,0), (0,4) is:
   - A. 5 sq units
   - **B. 6 sq units** ✅
   - C. 7 sq units
   - D. 12 sq units
   - **Explanation**: Area = 1/2 × base × height = 1/2 × 3 × 4 = 6

5. **Question**: If A(x, y), B(1, 2), C(2, 1) are collinear, then:
   - A. x = y
   - **B. x + y = 3** ✅
   - C. x - y = 0
   - D. x + y = 0
   - **Explanation**: Area of triangle ABC = 0 for collinear points.

---

### Chapter 8: Introduction to Trigonometry

1. **Question**: The value of sin 30° is:
   - **A. 1/2** ✅
   - B. √3/2
   - C. 1
   - D. 0
   - **Explanation**: Standard trigonometric value.

2. **Question**: If sin θ = 1/2, then θ equals:
   - **A. 30°** ✅
   - B. 45°
   - C. 60°
   - D. 90°
   - **Explanation**: sin 30° = 1/2

3. **Question**: The value of tan 45° is:
   - **A. 1** ✅
   - B. 0
   - C. √3
   - D. 1/√3
   - **Explanation**: tan 45° = 1

4. **Question**: sin² θ + cos² θ equals:
   - **A. 1** ✅
   - B. 0
   - C. 2
   - D. sin θ cos θ
   - **Explanation**: Fundamental trigonometric identity.

5. **Question**: If cos A = 3/5, then sin A equals:
   - **A. 4/5** ✅
   - B. 3/5
   - C. 5/4
   - D. 5/3
   - **Explanation**: sin²A + cos²A = 1, sin A = 4/5

---

### Chapter 9: Some Applications of Trigonometry

1. **Question**: A ladder 10 m long reaches a window 8 m above the ground. The distance of foot of ladder from base of wall is:
   - **A. 6 m** ✅
   - B. 4 m
   - C. 5 m
   - D. 8 m
   - **Explanation**: Pythagoras: √(10² - 8²) = 6

2. **Question**: The angle of elevation of the top of a tower from a point 30 m away is 30°. Height of tower is:
   - A. 10 m
   - **B. 10√3 m** ✅
   - C. 15 m
   - D. 20 m
   - **Explanation**: tan 30° = h/30, h = 10√3

3. **Question**: From the top of a 7 m building, the angle of elevation of a tower is 60°. Height of tower is approximately:
   - A. 14 m
   - **B. 19 m** ✅
   - C. 21 m
   - D. 25 m
   - **Explanation**: tan 60° = (h-7)/d, solve for h.

4. **Question**: A tree breaks due to storm and the broken part bends so that the top touches the ground at 30° angle from vertical. If the distance from foot to top is 8 m, length of tree was:
   - **A. 16 m** ✅
   - B. 12 m
   - C. 10 m
   - D. 14 m
   - **Explanation**: Using trigonometry and Pythagoras.

5. **Question**: The shadow of a tower is √3 times its height. The angle of elevation of sun is:
   - **A. 30°** ✅
   - B. 45°
   - C. 60°
   - D. 90°
   - **Explanation**: tan θ = h/(√3h) = 1/√3, θ = 30°

---

### Chapter 10: Circles

1. **Question**: A tangent to a circle intersects it in:
   - **A. One point** ✅
   - B. Two points
   - C. Three points
   - D. No point
   - **Explanation**: Definition of tangent.

2. **Question**: The length of tangent from external point (5, 0) to circle x² + y² = 9 is:
   - **A. 4** ✅
   - B. 5
   - C. 3
   - D. 6
   - **Explanation**: Length = √(d² - r²) = √(25-9) = 4

3. **Question**: If two tangents inclined at 60° are drawn to a circle of radius 3 cm, the length of each tangent is:
   - A. 3 cm
   - **B. 3√3 cm** ✅
   - C. 6 cm
   - D. 3/√3 cm
   - **Explanation**: Using tangent properties and trigonometry.

4. **Question**: The angle between tangent at a point and radius through that point is:
   - A. 60°
   - B. 45°
   - C. 30°
   - **D. 90°** ✅
   - **Explanation**: Tangent is perpendicular to radius.

5. **Question**: If tangents PA and PB from point P to circle are inclined at 80°, then ∠POB equals:
   - A. 40°
   - **B. 50°** ✅
   - C. 60°
   - D. 80°
   - **Explanation**: Using properties of tangents from external point.

---

### Chapter 11: Areas Related to Circles

1. **Question**: The area of a circle with radius 7 cm is:
   - A. 44 cm²
   - **B. 154 cm²** ✅
   - C. 22 cm²
   - D. 308 cm²
   - **Explanation**: Area = πr² = 22/7 × 49 = 154

2. **Question**: The circumference of a circle with diameter 14 cm is:
   - **A. 44 cm** ✅
   - B. 22 cm
   - C. 88 cm
   - D. 154 cm
   - **Explanation**: Circumference = πd = 22/7 × 14 = 44

3. **Question**: Area of sector of angle 60° in circle of radius 6 cm is:
   - A. 18π cm²
   - **B. 6π cm²** ✅
   - C. 12π cm²
   - D. 3π cm²
   - **Explanation**: Area = (θ/360) × πr² = (60/360) × 36π = 6π

4. **Question**: The area of semicircle of diameter 14 cm is:
   - A. 154 cm²
   - **B. 77 cm²** ✅
   - C. 44 cm²
   - D. 22 cm²
   - **Explanation**: Area = πr²/2 = 22/7 × 49/2 = 77

5. **Question**: Length of arc of sector of angle 90° in circle of radius 4 cm is:
   - A. π cm
   - **B. 2π cm** ✅
   - C. 4π cm
   - D. 8π cm
   - **Explanation**: Arc length = (θ/360) × 2πr = (90/360) × 8π = 2π

---

### Chapter 12: Surface Areas and Volumes

1. **Question**: The volume of a cube of edge 4 cm is:
   - A. 16 cm³
   - **B. 64 cm³** ✅
   - C. 48 cm³
   - D. 24 cm³
   - **Explanation**: Volume = a³ = 4³ = 64

2. **Question**: The total surface area of cuboid 5 cm × 3 cm × 2 cm is:
   - A. 30 cm²
   - **B. 62 cm²** ✅
   - C. 50 cm²
   - D. 72 cm²
   - **Explanation**: TSA = 2(lb + bh + hl) = 2(15+6+10) = 62

3. **Question**: The volume of cylinder with radius 3 cm and height 7 cm is:
   - A. 63π cm³
   - **B. 63π cm³** ✅
   - C. 21π cm³
   - D. 42π cm³
   - **Explanation**: Volume = πr²h = π × 9 × 7 = 63π

4. **Question**: The curved surface area of cone with radius 5 cm and slant height 13 cm is:
   - **A. 65π cm²** ✅
   - B. 60π cm²
   - C. 130π cm²
   - D. 25π cm²
   - **Explanation**: CSA = πrl = π × 5 × 13 = 65π

5. **Question**: The surface area of sphere of radius 7 cm is:
   - A. 154π cm²
   - **B. 196π cm²** ✅
   - C. 49π cm²
   - D. 308π cm²
   - **Explanation**: SA = 4πr² = 4π × 49 = 196π

---

### Chapter 13: Statistics

1. **Question**: The mean of first 10 natural numbers is:
   - A. 5
   - **B. 5.5** ✅
   - C. 6
   - D. 10
   - **Explanation**: Mean = (1+2+...+10)/10 = 55/10 = 5.5

2. **Question**: The median of 3, 1, 5, 6, 3, 4, 5 is:
   - A. 3
   - **B. 4** ✅
   - C. 5
   - D. 6
   - **Explanation**: Arrange: 1,3,3,4,5,5,6 → median = 4

3. **Question**: The mode of 2, 3, 4, 2, 3, 5, 3, 4 is:
   - A. 2
   - **B. 3** ✅
   - C. 4
   - D. 5
   - **Explanation**: 3 appears most frequently (3 times).

4. **Question**: If mean of x, x+2, x+4, x+6, x+8 is 11, then x equals:
   - **A. 7** ✅
   - B. 9
   - C. 5
   - D. 11
   - **Explanation**: (5x+20)/5 = 11, x = 7

5. **Question**: The range of data 5, 8, 2, 9, 6, 3 is:
   - **A. 7** ✅
   - B. 5
   - C. 9
   - D. 6
   - **Explanation**: Range = max - min = 9 - 2 = 7

---

### Chapter 14: Probability

1. **Question**: A die is thrown once. Probability of getting a prime number is:
   - A. 1/6
   - B. 1/3
   - **C. 1/2** ✅
   - D. 2/3
   - **Explanation**: Prime numbers: 2, 3, 5 → P = 3/6 = 1/2

2. **Question**: Two coins are tossed. Probability of getting at least one head is:
   - A. 1/4
   - B. 1/2
   - **C. 3/4** ✅
   - D. 1
   - **Explanation**: Outcomes: HH, HT, TH, TT → 3/4

3. **Question**: A card is drawn from 52 cards. Probability of getting a king is:
   - **A. 1/13** ✅
   - B. 1/26
   - C. 1/52
   - D. 4/52
   - **Explanation**: 4 kings in 52 cards → 4/52 = 1/13

4. **Question**: A bag contains 3 red and 5 blue balls. Probability of drawing a red ball is:
   - **A. 3/8** ✅
   - B. 5/8
   - C. 1/2
   - D. 3/5
   - **Explanation**: P(red) = 3/(3+5) = 3/8

5. **Question**: The probability of an impossible event is:
   - **A. 0** ✅
   - B. 1
   - C. 0.5
   - D. -1
   - **Explanation**: Impossible events have probability 0.

---

### Chapter 15: Construction (Conceptual Questions)

1. **Question**: To divide a line segment AB in ratio 3:4, first draw a ray making an acute angle with AB. The number of equal parts the ray is divided into is:
   - A. 3
   - B. 4
   - C. 5
   - **D. 7** ✅
   - **Explanation**: Sum of ratio parts = 3 + 4 = 7

2. **Question**: To construct a triangle similar to given triangle with scale factor 3/5, the ratio of sides is:
   - **A. 3:5** ✅
   - B. 5:3
   - C. 2:3
   - D. 3:2
   - **Explanation**: Scale factor represents ratio of sides.

3. **Question**: The basic principle used in constructing a tangent to a circle at a point is:
   - A. Angle in semicircle
   - B. Chord properties
   - **C. Tangent perpendicular to radius** ✅
   - D. Arc properties
   - **Explanation**: Tangent is always perpendicular to radius at point of contact.

4. **Question**: To construct a tangent to a circle from an external point, the angle between radius and tangent is:
   - **A. 90°** ✅
   - B. 60°
   - C. 45°
   - D. 30°
   - **Explanation**: Tangent ⊥ radius at contact point.

5. **Question**: In constructing triangle ABC similar to triangle PQR, if PQ = 4 cm and AB = 6 cm, the scale factor is:
   - A. 2/3
   - **B. 3/2** ✅
   - C. 1/2
   - D. 4/6
   - **Explanation**: Scale factor = AB/PQ = 6/4 = 3/2

---

## 15.2 SCIENCE (15 Chapters × 5 Questions = 75 Questions)

### Chapter 1: Chemical Reactions and Equations

1. **Question**: Which equation is balanced?
   - A. H₂ + O₂ → H₂O
   - **B. 2H₂ + O₂ → 2H₂O** ✅
   - C. H₂ + O₂ → 2H₂O
   - D. 2H₂ + 2O₂ → 2H₂O
   - **Explanation**: Equal atoms on both sides.

2. **Question**: CaCO₃ → CaO + CO₂ is an example of:
   - A. Combination
   - **B. Decomposition** ✅
   - C. Displacement
   - D. Double displacement
   - **Explanation**: Single compound breaks into two.

3. **Question**: In Zn + CuSO₄ → ZnSO₄ + Cu, which is oxidized?
   - **A. Zinc** ✅
   - B. Copper
   - C. Sulphur
   - D. Oxygen
   - **Explanation**: Zn loses electrons (oxidation).

4. **Question**: Rancidity can be prevented by:
   - A. Antioxidants
   - B. Airtight containers
   - C. Refrigeration
   - **D. All of the above** ✅
   - **Explanation**: All prevent oxidation.

5. **Question**: When iron nail is dipped in CuSO₄, color changes:
   - **A. Blue to green** ✅
   - B. Green to blue
   - C. Blue to colorless
   - D. No change
   - **Explanation**: Fe displaces Cu, forming green FeSO₄.

---

### Chapter 2: Acids, Bases and Salts

1. **Question**: The pH of lemon juice is approximately:
   - **A. 2** ✅
   - B. 7
   - C. 10
   - D. 14
   - **Explanation**: Lemon juice is acidic (pH < 7).

2. **Question**: Which turns red litmus blue?
   - A. Acid
   - **B. Base** ✅
   - C. Salt
   - D. Water
   - **Explanation**: Bases turn red litmus blue.

3. **Question**: Plaster of Paris formula is:
   - A. CaSO₄
   - **B. CaSO₄·½H₂O** ✅
   - C. CaSO₄·2H₂O
   - D. Ca(OH)₂
   - **Explanation**: Calcium sulphate hemihydrate.

4. **Question**: pH of pure water is:
   - A. 0
   - B. 1
   - **C. 7** ✅
   - D. 14
   - **Explanation**: Water is neutral (pH = 7).

5. **Question**: Common name of NaHCO₃ is:
   - A. Washing soda
   - **B. Baking soda** ✅
   - C. Caustic soda
   - D. Soda ash
   - **Explanation**: Sodium bicarbonate = baking soda.

---

### Chapter 3: Metals and Non-Metals

1. **Question**: Most reactive metal is:
   - **A. Potassium** ✅
   - B. Sodium
   - C. Calcium
   - D. Magnesium
   - **Explanation**: Potassium is most reactive in reactivity series.

2. **Question**: Which is a good conductor of electricity?
   - A. Sulphur
   - B. Phosphorus
   - **C. Copper** ✅
   - D. Carbon
   - **Explanation**: Copper is a metal and conducts electricity.

3. **Question**: Metals react with acids to produce:
   - A. Oxygen
   - **B. Hydrogen** ✅
   - C. Carbon dioxide
   - D. Nitrogen
   - **Explanation**: Metal + Acid → Salt + H₂

4. **Question**: Galvanization is coating iron with:
   - A. Copper
   - B. Tin
   - **C. Zinc** ✅
   - D. Aluminium
   - **Explanation**: Zinc coating prevents rusting.

5. **Question**: An amphoteric oxide is:
   - A. CaO
   - **B. Al₂O₃** ✅
   - C. MgO
   - D. CuO
   - **Explanation**: Al₂O₃ reacts with both acids and bases.

---

### Chapter 4: Carbon and its Compounds

1. **Question**: The functional group in ethanol is:
   - A. –CHO
   - **B. –OH** ✅
   - C. –COOH
   - D. –CO–
   - **Explanation**: Alcohols have –OH group.

2. **Question**: Vinegar contains:
   - **A. Acetic acid** ✅
   - B. Formic acid
   - C. Citric acid
   - D. Lactic acid
   - **Explanation**: Vinegar is dilute acetic acid.

3. **Question**: Saturated hydrocarbons are called:
   - A. Alkenes
   - **B. Alkanes** ✅
   - C. Alkynes
   - D. Aromatics
   - **Explanation**: Alkanes have single bonds only.

4. **Question**: The formula of methane is:
   - A. CH₂
   - B. C₂H₆
   - **C. CH₄** ✅
   - D. C₃H₈
   - **Explanation**: Simplest alkane.

5. **Question**: Esterification is reaction between:
   - A. Acid and base
   - **B. Acid and alcohol** ✅
   - C. Alcohol and base
   - D. Two acids
   - **Explanation**: Acid + Alcohol → Ester + Water

---

### Chapter 5: Life Processes

1. **Question**: The basic unit of life is:
   - A. Tissue
   - **B. Cell** ✅
   - C. Organ
   - D. Organism
   - **Explanation**: Cell is the fundamental unit.

2. **Question**: Autotrophic nutrition occurs in:
   - **A. Plants** ✅
   - B. Animals
   - C. Fungi
   - D. Bacteria
   - **Explanation**: Plants make their own food.

3. **Question**: The energy currency of cell is:
   - A. ADP
   - **B. ATP** ✅
   - C. DNA
   - D. RNA
   - **Explanation**: ATP stores and releases energy.

4. **Question**: Stomata are present on:
   - A. Roots
   - B. Stem
   - **C. Leaves** ✅
   - D. Flowers
   - **Explanation**: Stomata on leaf surface for gas exchange.

5. **Question**: Respiratory organ in fish is:
   - A. Lungs
   - **B. Gills** ✅
   - C. Skin
   - D. Trachea
   - **Explanation**: Fish breathe through gills.

---

### Chapter 6: Control and Coordination

1. **Question**: The gap between two neurons is called:
   - A. Dendrite
   - B. Axon
   - **C. Synapse** ✅
   - D. Nucleus
   - **Explanation**: Synapse is the junction between neurons.

2. **Question**: Plant hormone responsible for growth is:
   - **A. Auxin** ✅
   - B. Cytokinin
   - C. Gibberellin
   - D. Ethylene
   - **Explanation**: Auxins promote cell elongation.

3. **Question**: Master gland of human body is:
   - A. Thyroid
   - **B. Pituitary** ✅
   - C. Pancreas
   - D. Adrenal
   - **Explanation**: Pituitary controls other glands.

4. **Question**: Insulin is secreted by:
   - A. Liver
   - **B. Pancreas** ✅
   - C. Kidney
   - D. Pituitary
   - **Explanation**: Pancreas produces insulin.

5. **Question**: Reflex arc acts in:
   - A. Brain
   - **B. Spinal cord** ✅
   - C. Nerves
   - D. Muscles
   - **Explanation**: Reflex actions through spinal cord.

---

### Chapter 7: How Do Organisms Reproduce?

1. **Question**: Asexual reproduction occurs in:
   - A. Humans
   - **B. Amoeba** ✅
   - C. Birds
   - D. Mammals
   - **Explanation**: Amoeba reproduces by binary fission.

2. **Question**: Male gamete in plants is:
   - A. Ovule
   - **B. Pollen** ✅
   - C. Seed
   - D. Fruit
   - **Explanation**: Pollen carries male gametes.

3. **Question**: Fertilization in humans occurs in:
   - A. Uterus
   - **B. Fallopian tube** ✅
   - C. Ovary
   - D. Vagina
   - **Explanation**: Egg fertilized in fallopian tube.

4. **Question**: Vegetative propagation occurs through:
   - A. Seeds
   - **B. Stem** ✅
   - C. Flowers
   - D. Fruits
   - **Explanation**: New plants from stem cuttings.

5. **Question**: The period of development inside uterus is called:
   - A. Fertilization
   - B. Implantation
   - **C. Gestation** ✅
   - D. Parturition
   - **Explanation**: Gestation = pregnancy period.

---

### Chapter 8: Heredity and Evolution

1. **Question**: The basic unit of heredity is:
   - A. Cell
   - **B. Gene** ✅
   - C. Chromosome
   - D. DNA
   - **Explanation**: Genes carry hereditary information.

2. **Question**: Human cells have chromosomes:
   - A. 23
   - **B. 46** ✅
   - C. 48
   - D. 44
   - **Explanation**: 23 pairs = 46 chromosomes.

3. **Question**: Theory of evolution was proposed by:
   - **A. Charles Darwin** ✅
   - B. Mendel
   - C. Lamarck
   - D. Watson
   - **Explanation**: Darwin's theory of natural selection.

4. **Question**: Variations arise due to:
   - A. Environment only
   - B. Genes only
   - **C. Both genes and environment** ✅
   - D. Neither
   - **Explanation**: Both contribute to variations.

5. **Question**: Sex of baby is determined by:
   - A. Mother
   - **B. Father** ✅
   - C. Both equally
   - D. Random
   - **Explanation**: Father's sperm determines sex (X or Y).

---

### Chapter 9: Light - Reflection and Refraction

1. **Question**: The SI unit of power of lens is:
   - A. Meter
   - **B. Dioptre** ✅
   - C. Watt
   - D. Joule
   - **Explanation**: Dioptre (D) = 1/focal length in meters.

2. **Question**: A concave mirror is used in:
   - A. Rear view mirror
   - **B. Dentist's mirror** ✅
   - C. Security mirror
   - D. Headlights
   - **Explanation**: Concave mirrors magnify images.

3. **Question**: Refractive index of water is:
   - A. 1.0
   - B. 1.2
   - **C. 1.33** ✅
   - D. 1.5
   - **Explanation**: Standard value for water.

4. **Question**: Image formed by plane mirror is:
   - A. Real and inverted
   - **B. Virtual and erect** ✅
   - C. Real and erect
   - D. Virtual and inverted
   - **Explanation**: Plane mirrors form virtual, erect images.

5. **Question**: Power of a convex lens is:
   - **A. Positive** ✅
   - B. Negative
   - C. Zero
   - D. Infinity
   - **Explanation**: Convex lenses have positive power.

---

### Chapter 10: The Human Eye and Colourful World

1. **Question**: The defect myopia can be corrected using:
   - **A. Concave lens** ✅
   - B. Convex lens
   - C. Cylindrical lens
   - D. Plane mirror
   - **Explanation**: Concave lens diverges light for myopia.

2. **Question**: The phenomenon of splitting white light is called:
   - A. Reflection
   - B. Refraction
   - **C. Dispersion** ✅
   - D. Scattering
   - **Explanation**: Dispersion splits light into colors.

3. **Question**: Rainbow is formed due to:
   - A. Reflection only
   - B. Refraction only
   - **C. Dispersion and refraction** ✅
   - D. Scattering
   - **Explanation**: Both processes create rainbow.

4. **Question**: The danger signals are red because:
   - **A. Red light scatters the least** ✅
   - B. Red is attractive
   - C. Red is bright
   - D. Red is dark
   - **Explanation**: Longer wavelength scatters less.

5. **Question**: The part of eye that controls light entering is:
   - A. Retina
   - B. Lens
   - **C. Pupil** ✅
   - D. Cornea
   - **Explanation**: Pupil regulates light entry.

---

### Chapter 11: Electricity

1. **Question**: SI unit of electric current is:
   - **A. Ampere** ✅
   - B. Volt
   - C. Ohm
   - D. Watt
   - **Explanation**: Current measured in amperes (A).

2. **Question**: According to Ohm's law, V = IR, R is:
   - A. Voltage
   - B. Current
   - **C. Resistance** ✅
   - D. Power
   - **Explanation**: R = resistance in ohms.

3. **Question**: Electric power formula is:
   - A. P = V/I
   - **B. P = VI** ✅
   - C. P = I/V
   - D. P = V + I
   - **Explanation**: Power = Voltage × Current.

4. **Question**: 1 kWh equals:
   - A. 1000 J
   - B. 3600 J
   - **C. 3.6 × 10⁶ J** ✅
   - D. 1000000 J
   - **Explanation**: 1 kWh = 3.6 million joules.

5. **Question**: In parallel combination, voltage across each resistor is:
   - **A. Same** ✅
   - B. Different
   - C. Zero
   - D. Infinite
   - **Explanation**: Parallel circuits have same voltage.

---

### Chapter 12: Magnetic Effects of Electric Current

1. **Question**: Magnetic field inside a solenoid is:
   - A. Zero
   - B. Weak
   - **C. Strong and uniform** ✅
   - D. Variable
   - **Explanation**: Solenoid creates uniform field.

2. **Question**: Fleming's left hand rule determines:
   - A. Current direction
   - **B. Force direction** ✅
   - C. Magnetic field
   - D. Voltage
   - **Explanation**: Left hand rule gives force direction.

3. **Question**: Electric motor works on:
   - A. Heating effect
   - **B. Magnetic effect** ✅
   - C. Chemical effect
   - D. Light effect
   - **Explanation**: Motors use magnetic force.

4. **Question**: The device used to detect current is:
   - A. Voltmeter
   - **B. Galvanometer** ✅
   - C. Ammeter
   - D. Ohmmeter
   - **Explanation**: Galvanometer detects current.

5. **Question**: Electromagnetic induction was discovered by:
   - A. Ampere
   - **B. Faraday** ✅
   - C. Ohm
   - D. Fleming
   - **Explanation**: Faraday's law of induction.

---

### Chapter 13: Our Environment

1. **Question**: Ozone layer protects from:
   - A. Visible light
   - **B. UV radiation** ✅
   - C. Infrared
   - D. Radio waves
   - **Explanation**: Ozone blocks harmful UV rays.

2. **Question**: Which is biodegradable?
   - A. Plastic
   - **B. Paper** ✅
   - C. Glass
   - D. Metal
   - **Explanation**: Paper decomposes naturally.

3. **Question**: Top consumers in food chain are:
   - A. Producers
   - B. Herbivores
   - **C. Carnivores** ✅
   - D. Decomposers
   - **Explanation**: Carnivores are top predators.

4. **Question**: The main cause of ozone depletion is:
   - A. CO₂
   - **B. CFCs** ✅
   - C. SO₂
   - D. NO₂
   - **Explanation**: CFCs damage ozone layer.

5. **Question**: Energy flow in ecosystem is:
   - **A. Unidirectional** ✅
   - B. Bidirectional
   - C. Cyclic
   - D. Random
   - **Explanation**: Energy flows one way (sun → plants → animals).

---

### Chapter 14: Management of Natural Resources

1. **Question**: 3 R's of waste management are:
   - A. Reduce, Reuse, Recycle
   - **B. All of the above** ✅
   - C. None
   - D. Only reduce
   - **Explanation**: All three principles apply.

2. **Question**: Sustainable development means:
   - A. Fast development
   - **B. Development without harming future** ✅
   - C. No development
   - D. Industrial growth
   - **Explanation**: Meeting needs without compromising future.

3. **Question**: Watershed management helps in:
   - A. Water pollution
   - **B. Water conservation** ✅
   - C. Air pollution
   - D. Deforestation
   - **Explanation**: Manages water resources efficiently.

4. **Question**: Fossil fuels are:
   - **A. Non-renewable** ✅
   - B. Renewable
   - C. Inexhaustible
   - D. Clean
   - **Explanation**: Limited fossil fuel reserves.

5. **Question**: Chipko movement was for:
   - A. Water
   - **B. Forest conservation** ✅
   - C. Air quality
   - D. Wildlife
   - **Explanation**: Movement to save trees.

---

### Chapter 15: Sources of Energy

1. **Question**: Solar energy is:
   - **A. Renewable** ✅
   - B. Non-renewable
   - C. Fossil fuel
   - D. Nuclear
   - **Explanation**: Sun provides unlimited energy.

2. **Question**: Biogas mainly contains:
   - A. CO₂
   - **B. Methane** ✅
   - C. O₂
   - D. N₂
   - **Explanation**: Biogas is primarily methane.

3. **Question**: Nuclear energy is produced by:
   - A. Chemical reaction
   - **B. Nuclear fission** ✅
   - C. Combustion
   - D. Oxidation
   - **Explanation**: Splitting atoms releases energy.

4. **Question**: Wind energy is used to generate:
   - A. Heat
   - **B. Electricity** ✅
   - C. Light
   - D. Sound
   - **Explanation**: Wind turbines produce electricity.

5. **Question**: The cleanest source of energy is:
   - A. Coal
   - B. Diesel
   - C. Natural gas
   - **D. Solar** ✅
   - **Explanation**: Solar energy produces no pollution.

---

## 15.3 SOCIAL STUDIES (15 Chapters × 5 Questions = 75 Questions)

### Chapter 1: The Rise of Nationalism in Europe

1. **Question**: French Revolution began in:
   - **A. 1789** ✅
   - B. 1799
   - C. 1804
   - D. 1815
   - **Explanation**: Bastille stormed on July 14, 1789.

2. **Question**: Who was proclaimed King of United Italy?
   - A. Garibaldi
   - B. Cavour
   - **C. Victor Emmanuel II** ✅
   - D. Mazzini
   - **Explanation**: Crowned in 1861.

3. **Question**: Architect of Germany's unification:
   - A. William I
   - **B. Otto von Bismarck** ✅
   - C. Friedrich
   - D. Napoleon III
   - **Explanation**: Bismarck's "Blood and Iron" policy.

4. **Question**: Treaty that ended Napoleon's rule:
   - **A. Treaty of Vienna** ✅
   - B. Treaty of Versailles
   - C. Treaty of Paris
   - D. Treaty of Westphalia
   - **Explanation**: 1815 Congress of Vienna.

5. **Question**: Romanticism emphasized:
   - A. Logic
   - **B. Emotions** ✅
   - C. Industry
   - D. Colonialism
   - **Explanation**: Cultural movement valuing emotion.

---

### Chapter 2: Nationalism in India

1. **Question**: First World War lasted from:
   - A. 1910-1914
   - **B. 1914-1918** ✅
   - C. 1918-1922
   - D. 1939-1945
   - **Explanation**: WWI from 1914 to 1918.

2. **Question**: Jallianwala Bagh massacre occurred in:
   - **A. 1919** ✅
   - B. 1920
   - C. 1921
   - D. 1922
   - **Explanation**: April 13, 1919 in Amritsar.

3. **Question**: Non-Cooperation Movement started in:
   - A. 1919
   - **B. 1920** ✅
   - C. 1921
   - D. 1922
   - **Explanation**: Gandhi launched in 1920.

4. **Question**: Simon Commission arrived in India in:
   - A. 1925
   - B. 1926
   - C. 1927
   - **D. 1928** ✅
   - **Explanation**: All-British commission in 1928.

5. **Question**: Salt March was in:
   - **A. 1930** ✅
   - B. 1932
   - C. 1935
   - D. 1940
   - **Explanation**: Dandi March, March 12, 1930.

---

### Chapter 3: The Making of a Global World

1. **Question**: Silk Routes connected:
   - **A. Asia and Europe** ✅
   - B. Africa and America
   - C. Europe and Africa
   - D. Asia and America
   - **Explanation**: Ancient trade routes.

2. **Question**: Potato and maize came to Asia from:
   - A. Africa
   - **B. America** ✅
   - C. Europe
   - D. Australia
   - **Explanation**: Columbian Exchange.

3. **Question**: Great Depression started in:
   - **A. 1929** ✅
   - B. 1930
   - C. 1931
   - D. 1932
   - **Explanation**: Stock market crash, 1929.

4. **Question**: Bretton Woods institutions are:
   - A. UN and WHO
   - **B. IMF and World Bank** ✅
   - C. WTO and ILO
   - D. UNESCO and UNICEF
   - **Explanation**: Established in 1944.

5. **Question**: MNCs expand through:
   - A. Trade only
   - B. Investment only
   - **C. Both trade and investment** ✅
   - D. Aid
   - **Explanation**: Multiple strategies.

---

### Chapter 4: The Age of Industrialization

1. **Question**: First industrial nation was:
   - A. Germany
   - B. USA
   - **C. Britain** ✅
   - D. France
   - **Explanation**: Industrial Revolution began in Britain.

2. **Question**: Spinning Jenny was invented by:
   - **A. James Hargreaves** ✅
   - B. Richard Arkwright
   - C. Samuel Crompton
   - D. James Watt
   - **Explanation**: 1764 invention.

3. **Question**: Steam engine improved by:
   - A. Newcomen
   - **B. James Watt** ✅
   - C. Stephenson
   - D. Hargreaves
   - **Explanation**: Watt's improvements, 1769.

4. **Question**: First railway opened in:
   - A. 1820
   - **B. 1825** ✅
   - C. 1830
   - D. 1835
   - **Explanation**: Stockton-Darlington, 1825.

5. **Question**: Industrialization led to growth of:
   - A. Villages
   - **B. Cities** ✅
   - C. Farms
   - D. Forests
   - **Explanation**: Urbanization increased.

---

### Chapter 5: Print Culture and Modern World

1. **Question**: Printing press invented by:
   - A. Caxton
   - **B. Gutenberg** ✅
   - C. Aldus
   - D. Franklin
   - **Explanation**: Johannes Gutenberg, 1440s.

2. **Question**: First printed book was:
   - A. Koran
   - **B. Bible** ✅
   - C. Vedas
   - D. Dictionary
   - **Explanation**: Gutenberg Bible, 1455.

3. **Question**: In India, first printing press set up by:
   - A. British
   - **B. Portuguese** ✅
   - C. French
   - D. Dutch
   - **Explanation**: Goa, mid-16th century.

4. **Question**: Vernacular press means:
   - A. English press
   - **B. Local language press** ✅
   - C. Government press
   - D. Foreign press
   - **Explanation**: Regional languages.

5. **Question**: Print culture helped spread:
   - A. Religion only
   - B. Politics only
   - C. Science only
   - **D. All ideas** ✅
   - **Explanation**: Democratized knowledge.

---

### Chapter 6: Resources and Development

1. **Question**: Resources created by humans are:
   - A. Natural
   - B. Biotic
   - **C. Human-made** ✅
   - D. Abiotic
   - **Explanation**: Buildings, roads, etc.

2. **Question**: Renewable resources are:
   - **A. Solar, wind** ✅
   - B. Coal, petroleum
   - C. Minerals
   - D. Metals
   - **Explanation**: Can be replenished.

3. **Question**: Sustainable development aims to:
   - A. Fast growth
   - **B. Meet present needs without harming future** ✅
   - C. Industrial expansion
   - D. Urban growth
   - **Explanation**: Balance development and conservation.

4. **Question**: Black soil is also called:
   - A. Alluvial
   - **B. Regur** ✅
   - C. Laterite
   - D. Desert
   - **Explanation**: Cotton-growing soil.

5. **Question**: Soil erosion is mainly caused by:
   - **A. Water and wind** ✅
   - B. Earthquakes
   - C. Volcanoes
   - D. Landslides
   - **Explanation**: Natural agents of erosion.

---

### Chapter 7: Forest and Wildlife Resources

1. **Question**: Project Tiger was launched in:
   - A. 1970
   - B. 1971
   - **C. 1973** ✅
   - D. 1975
   - **Explanation**: Tiger conservation program.

2. **Question**: Biodiversity hotspot in India:
   - A. Himalayas
   - **B. Western Ghats** ✅
   - C. Thar Desert
   - D. Gangetic Plain
   - **Explanation**: High species diversity.

3. **Question**: Sacred groves are:
   - A. National parks
   - **B. Community-protected forests** ✅
   - C. Sanctuaries
   - D. Biosphere reserves
   - **Explanation**: Traditionally protected.

4. **Question**: Deforestation leads to:
   - A. More rainfall
   - **B. Climate change** ✅
   - C. Soil fertility
   - D. Biodiversity increase
   - **Explanation**: Loss of trees affects climate.

5. **Question**: Endangered species means:
   - A. Extinct
   - **B. At risk of extinction** ✅
   - C. Abundant
   - D. Domesticated
   - **Explanation**: Threatened with extinction.

---

### Chapter 8: Water Resources

1. **Question**: Multipurpose projects provide:
   - A. Water only
   - B. Electricity only
   - C. Irrigation only
   - **D. All of the above** ✅
   - **Explanation**: Multiple benefits.

2. **Question**: Rainwater harvesting helps in:
   - A. Water wastage
   - **B. Groundwater recharge** ✅
   - C. Pollution
   - D. Flooding
   - **Explanation**: Stores and recharges water.

3. **Question**: Dams can cause:
   - A. Deforestation
   - B. Displacement
   - C. Ecological damage
   - **D. All of the above** ✅
   - **Explanation**: Environmental and social impacts.

4. **Question**: Narmada Bachao Andolan opposed:
   - A. Pollution
   - **B. Sardar Sarovar Dam** ✅
   - C. Deforestation
   - D. Mining
   - **Explanation**: Anti-dam movement.

5. **Question**: India receives water mainly from:
   - A. Rivers
   - **B. Monsoon** ✅
   - C. Glaciers
   - D. Groundwater
   - **Explanation**: Monsoon rains crucial.

---

### Chapter 9: Agriculture

1. **Question**: Green Revolution increased production of:
   - A. Cotton
   - **B. Wheat and rice** ✅
   - C. Sugarcane
   - D. Tea
   - **Explanation**: HYV seeds boosted cereals.

2. **Question**: Rabi crops are sown in:
   - A. Monsoon
   - **B. Winter** ✅
   - C. Summer
   - D. Spring
   - **Explanation**: October-December sowing.

3. **Question**: Kharif crops are harvested in:
   - A. Winter
   - B. Summer
   - **C. September-October** ✅
   - D. December
   - **Explanation**: Monsoon crops.

4. **Question**: India is largest producer of:
   - A. Wheat
   - B. Rice
   - **C. Spices** ✅
   - D. Cotton
   - **Explanation**: Leading spice producer.

5. **Question**: Slash and burn agriculture is called:
   - A. Terrace farming
   - **B. Shifting cultivation** ✅
   - C. Intensive farming
   - D. Commercial farming
   - **Explanation**: Traditional method.

---

### Chapter 10: Minerals and Energy Resources

1. **Question**: Most abundantmineral in earth's crust:
   - A. Iron
   - B. Copper
   - **C. Aluminium** ✅
   - D. Gold
   - **Explanation**: Aluminium (8% of crust).

2. **Question**: Coal is a:
   - A. Metallic mineral
   - **B. Non-metallic mineral** ✅
   - C. Energy mineral
   - D. Precious mineral
   - **Explanation**: Fossil fuel, non-metallic.

3. **Question**: Mica is mainly found in:
   - A. Kerala
   - **B. Jharkhand** ✅
   - C. Tamil Nadu
   - D. Gujarat
   - **Explanation**: Mica belt.

4. **Question**: Renewable energy includes:
   - **A. Solar, wind** ✅
   - B. Coal, oil
   - C. Natural gas
   - D. Nuclear
   - **Explanation**: Sustainable sources.

5. **Question**: Petroleum is called:
   - A. White gold
   - **B. Black gold** ✅
   - C. Brown gold
   - D. Liquid gold
   - **Explanation**: Valuable resource.

---

### Chapter 11: Manufacturing Industries

1. **Question**: Cotton textile industry is:
   - **A. Agro-based** ✅
   - B. Mineral-based
   - C. Forest-based
   - D. Animal-based
   - **Explanation**: Uses cotton (agricultural).

2. **Question**: TISCO (Tata Steel) located in:
   - A. Mumbai
   - **B. Jamshedpur** ✅
   - C. Kolkata
   - D. Chennai
   - **Explanation**: Jharkhand city.

3. **Question**: IT industry is concentrated in:
   - A. Mumbai
   - **B. Bangalore** ✅
   - C. Chennai
   - D. Delhi
   - **Explanation**: Silicon Valley of India.

4. **Question**: Oldest industry in India:
   - **A. Cotton textile** ✅
   - B. Jute
   - C. Iron and steel
   - D. Sugar
   - **Explanation**: Established in 1854.

5. **Question**: Industrial pollution affects:
   - A. Air only
   - B. Water only
   - C. Land only
   - **D. All of the above** ✅
   - **Explanation**: Multiple environmental impacts.

---

### Chapter 12: Lifelines of National Economy

1. **Question**: Golden Quadrilateral connects:
   - A. 3 cities
   - **B. 4 metros** ✅
   - C. 5 cities
   - D. 6 cities
   - **Explanation**: Delhi, Mumbai, Chennai, Kolkata.

2. **Question**: First railway in India started in:
   - A. 1850
   - B. 1852
   - **C. 1853** ✅
   - D. 1855
   - **Explanation**: Mumbai to Thane, 1853.

3. **Question**: Longest National Highway:
   - **A. NH 44** ✅
   - B. NH 1
   - C. NH 2
   - D. NH 7
   - **Explanation**: Srinagar to Kanyakumari.

4. **Question**: Major seaport on west coast:
   - **A. Mumbai** ✅
   - B. Chennai
   - C. Kolkata
   - D. Vishakhapatnam
   - **Explanation**: Largest natural harbor.

5. **Question**: Mass communication includes:
   - A. Radio
   - B. TV
   - C. Internet
   - **D. All of the above** ✅
   - **Explanation**: All are mass media.

---

### Chapter 13: Power Sharing

1. **Question**: Power sharing is essential for:
   - A. Economic growth
   - **B. Democracy** ✅
   - C. Military strength
   - D. Industrialization
   - **Explanation**: Fundamental to democracy.

2. **Question**: Belgium is located in:
   - A. Asia
   - **B. Europe** ✅
   - C. Africa
   - D. America
   - **Explanation**: European country.

3. **Question**: Sri Lanka became independent in:
   - A. 1945
   - **B. 1948** ✅
   - C. 1950
   - D. 1952
   - **Explanation**: 1948 from British.

4. **Question**: Majoritarianism led to civil war in:
   - A. Belgium
   - **B. Sri Lanka** ✅
   - C. India
   - D. Nepal
   - **Explanation**: Sinhala vs Tamil conflict.

5. **Question**: Horizontal distribution of power means:
   - **A. Legislature, Executive, Judiciary** ✅
   - B. Center and States
   - C. Political parties
   - D. Interest groups
   - **Explanation**: Separation of powers.

---

### Chapter 14: Federalism

1. **Question**: India is a:
   - A. Unitary state
   - **B. Federal state** ✅
   - C. Confederal state
   - D. Monarchy
   - **Explanation**: Federal system.

2. **Question**: Subjects in Union List are decided by:
   - **A. Central government** ✅
   - B. State government
   - C. Both
   - D. Local bodies
   - **Explanation**: Central subjects.

3. **Question**: Languages in Eighth Schedule:
   - A. 18
   - **B. 22** ✅
   - C. 24
   - D. 15
   - **Explanation**: 22 scheduled languages.

4. **Question**: Panchayati Raj is:
   - A. State government
   - **B. Local government** ✅
   - C. Central government
   - D. Judiciary
   - **Explanation**: Third tier of government.

5. **Question**: 73rd Amendment deals with:
   - A. Municipalities
   - **B. Panchayats** ✅
   - C. States
   - D. Union Territories
   - **Explanation**: Rural local bodies.

---

### Chapter 15: Democracy and Diversity

1. **Question**: Democracy means:
   - A. Rule by one
   - B. Rule by few
   - **C. Rule by people** ✅
   - D. Rule by military
   - **Explanation**: Government of the people.

2. **Question**: Social divisions are based on:
   - A. Caste
   - B. Religion
   - C. Language
   - **D. All of the above** ✅
   - **Explanation**: Multiple factors.

3. **Question**: Overlapping differences create:
   - A. Harmony
   - **B. Deep social divisions** ✅
   - C. Unity
   - D. Peace
   - **Explanation**: Reinforced divisions.

4. **Question**: Cross-cutting differences:
   - **A. Reduce conflict** ✅
   - B. Increase conflict
   - C. Create war
   - D. End diversity
   - **Explanation**: Create common grounds.

5. **Question**: Homogeneous society means:
   - A. Diverse
   - **B. Similar people** ✅
   - C. Unequal
   - D. Divided
   - **Explanation**: Uniform population.

---

# 16. FUTURE ENHANCEMENTS

## Phase 2 Features (Post-MVP)

| Feature | Description | Priority |
|---------|-------------|----------|
| **Teacher Dashboard** | Monitor student progress | High |
| **School Leaderboards** | Gamified competition | Medium |
| **Custom Question Papers** | AI-generated tests | High |
| **Multi-language Support** | Kannada, Hindi, Tamil | High |
| **Voice Learning** | Audio explanations | Medium |
| **Peer Discussion Forum** | Student community | Low |
| **Video Explanations** | Visual learning content | Medium |
| **Parent Portal** | Progress monitoring for parents | Low |
| **Offline AI Hints** | Cache AI responses | Medium |
| **Advanced Analytics** | Detailed learning insights | High |

---

# 17. FINAL DELIVERABLES

## Project Submission Checklist

### ✅ Code Deliverables
- [ ] Complete Android Studio project
- [ ] Source code (Kotlin + Jetpack Compose)
- [ ] MVVM architecture implementation
- [ ] Room database with all tables
- [ ] 225 preloaded questions (15 × 3 × 5)
- [ ] Gemini API integration
- [ ] WorkManager notification system
- [ ] Navigation graph
- [ ] UI theme and components

### ✅ Documentation
- [ ] README.md with setup instructions
- [ ] API documentation
- [ ] Database schema diagram
- [ ] User manual
- [ ] Developer guide
- [ ] Code comments

### ✅ Testing
- [ ] Unit tests for ViewModels
- [ ] Database tests
- [ ] UI tests (Compose)
- [ ] Manual testing report
- [ ] Performance test results

### ✅ Deployment
- [ ] Signed APK file
- [ ] App icon and assets
- [ ] Proguard rules
- [ ] Release notes
- [ ] Play Store listing draft

---

