package com.sokcuri.twimgspeedproxy

import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.support.v7.preference.PreferenceManager
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("BootReceiver", "OK")

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        if (sharedPref.getBoolean("alwaysRun", false)) {
            var serviceController = ServiceController(
                context as Context,
                ProxyService::javaClass.get(ProxyService())
            )
            serviceController.startService()
        }
    }
}