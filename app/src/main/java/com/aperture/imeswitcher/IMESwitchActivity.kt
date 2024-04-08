package com.aperture.imeswitcher

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton


class IMESwitchActivity : ComponentActivity() {
    enum class IMESwitchDialogState{
        IDLE,
        PICKING,
        CHOSEN
    }

    private var imeSwitchDialogState = IMESwitchDialogState.IDLE
    private var imeManager: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imeSwitchDialogState = IMESwitchDialogState.IDLE
        imeManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        Handler(Looper.getMainLooper()).postDelayed({
            openIMESwitchDialog()
            imeSwitchDialogState = IMESwitchDialogState.PICKING
        }, 500);
    }

    override fun onDestroy() {
        super.onDestroy()
        imeManager = null
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (imeSwitchDialogState == IMESwitchDialogState.PICKING){
            imeSwitchDialogState = IMESwitchDialogState.CHOSEN
        }
        else if (imeSwitchDialogState == IMESwitchDialogState.CHOSEN) {
            onInputMethodPicked()
            imeSwitchDialogState = IMESwitchDialogState.IDLE
        }
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun onInputMethodPicked() {
        val currentIME = imeManager?.currentInputMethodInfo?.loadLabel(packageManager).toString()
        Toast.makeText(this, "Selected IME is $currentIME", Toast.LENGTH_SHORT).show()

        finishAffinity()
    }

    private fun openIMESwitchDialog(){
        imeManager?.showInputMethodPicker()
    }
}
