package com.aksharadeepa.tutor

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DailyReminderWorker(
    private val appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        createChannel()
        if (Build.VERSION.SDK_INT >= 33 &&
            ContextCompat.checkSelfPermission(appContext, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            return Result.success()
        }
        val notification = NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.app_icon)
            .setContentTitle("Complete today's learning goal")
            .setContentText("One quiz can keep your streak alive and improve your mastery map.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()
        NotificationManagerCompat.from(appContext).notify(1001, notification)
        return Result.success()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Study reminders",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            appContext.getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }

    private companion object {
        const val CHANNEL_ID = "study_reminders"
    }
}
