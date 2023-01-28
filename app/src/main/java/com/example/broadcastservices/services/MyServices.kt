package com.example.broadcastservices.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


//STEP 1
class MyServices : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.e("TAG", "onStartCommand")
        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        Log.e("TAG", "onTaskRemoved")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy")
    }
}