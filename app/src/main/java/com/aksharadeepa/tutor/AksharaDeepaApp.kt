package com.aksharadeepa.tutor

import android.app.Application
import androidx.room.Room
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class AksharaDeepaApp : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "akshara_deepa.db"
        ).build()
        container = AppContainer(
            repository = TutorRepository(database.tutorDao(), applicationContext),
            hintGenerator = HintGenerator(BuildConfig.GEMINI_API_KEY)
        )
        scheduleDailyReminder()
    }

    private fun scheduleDailyReminder() {
        val request = PeriodicWorkRequestBuilder<DailyReminderWorker>(1, TimeUnit.DAYS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "daily-study-reminder",
            ExistingPeriodicWorkPolicy.UPDATE,
            request
        )
    }
}

data class AppContainer(
    val repository: TutorRepository,
    val hintGenerator: HintGenerator
)
