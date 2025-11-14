package com.example.wellnessapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.content.getSystemService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WellnessApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }
    
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService<NotificationManager>()
            
            // Canal para recordatorios de rutinas
            val reminderChannel = NotificationChannel(
                REMINDER_CHANNEL_ID,
                "Recordatorios de Rutinas",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificaciones para recordar tus rutinas de bienestar"
                enableVibration(true)
                setShowBadge(true)
            }
            
            // Canal para notificaciones push de Firebase
            val pushChannel = NotificationChannel(
                PUSH_CHANNEL_ID,
                "Notificaciones Push",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notificaciones generales de la aplicación"
                enableVibration(true)
            }
            
            // Canal para clases en vivo
            val liveClassChannel = NotificationChannel(
                LIVE_CLASS_CHANNEL_ID,
                "Clases en Vivo",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificaciones sobre clases en vivo"
                enableVibration(true)
                setShowBadge(true)
            }
            
            notificationManager?.createNotificationChannels(
                listOf(reminderChannel, pushChannel, liveClassChannel)
            )
        }
    }
    
    companion object {
        const val REMINDER_CHANNEL_ID = "wellness_reminders"
        const val PUSH_CHANNEL_ID = "wellness_push"
        const val LIVE_CLASS_CHANNEL_ID = "wellness_live_class"
    }
}