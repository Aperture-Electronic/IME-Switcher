package com.aperture.imeswitcher

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder

class IMESwitchService : Service() {
    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "IMESwitchNotifyChannel"
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationBuilder : Notification.Builder

    override fun onCreate() {
        super.onCreate()

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel()
        startNotificationService()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel(){
        val channel = NotificationChannel(CHANNEL_ID, "IME Switch Notify Channel", NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(channel)
    }

    private fun startNotificationService(){
        val intent = Intent(this, IMESwitchNotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        notificationBuilder = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("IME Switch")
            .setContentText("Tap to Switch between IMEs")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .setVisibility(Notification.VISIBILITY_PUBLIC)
            .setOngoing(true)
            .setAutoCancel(false)
            .setCategory(Notification.CATEGORY_SERVICE)

        val notification = notificationBuilder.build()
        notification.flags = notification.flags.or(Notification.FLAG_NO_CLEAR)

        startForeground(NOTIFICATION_ID, notification)
    }

    private fun updateNotification(x: String) {
        notificationBuilder.setContentText(x)
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }
}