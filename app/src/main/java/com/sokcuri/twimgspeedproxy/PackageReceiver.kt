package com.sokcuri.twimgspeedproxy

import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.support.v7.preference.PreferenceManager
import android.util.Log

class PackageReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("PackageReceiver", "OK")
        val action = intent?.action
        when (action) {
            Intent.ACTION_MY_PACKAGE_REPLACED-> {

                val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
                if (sharedPref.getBoolean("serviceRun", false)) {
                    Log.d("PackageReceiver", "ACTION_MY_PACKAGE_REPLACED")

                    var serviceController = ServiceController(
                        context as Context,
                        ProxyService::javaClass.get(ProxyService())
                    )

                    serviceController.startService()
                }
            }
        }
    }
}