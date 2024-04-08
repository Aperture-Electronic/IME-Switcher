package com.aperture.imeswitcher

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class IMESwitchNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val imeSwIntent = Intent(context, IMESwitchActivity::class.java)
        imeSwIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(imeSwIntent)
    }
}