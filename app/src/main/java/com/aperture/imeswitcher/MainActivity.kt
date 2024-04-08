package com.aperture.imeswitcher

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            val intent = Intent()
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName)
            intent.putExtra("app_package", packageName)
            intent.putExtra("app_uid", applicationInfo.uid)
            startActivity(intent)
        }

        startForegroundService(Intent(this, IMESwitchService::class.java))
    }

    override fun onResume() {
        super.onResume()
        moveTaskToBack(false)
    }
}
