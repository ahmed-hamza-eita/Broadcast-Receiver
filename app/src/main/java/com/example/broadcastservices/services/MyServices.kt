package com.example.broadcastservices.services

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.broadcastservices.Const
import com.example.broadcastservices.R


//STEP 1
class MyServices : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mBuilder = Notification.Builder(this, Const.NFT_CHANNEL)
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            mBuilder.setContentText("App is running")
            mBuilder.setContentTitle("TEST ForeGround Services")
            startForeground(System.currentTimeMillis().toInt(), mBuilder.build())
        } else {
            // الNotification زماان
            val mBuilder = NotificationCompat.Builder(this, "TEST")
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            mBuilder.setContentText("App is running")
            mBuilder.setContentTitle("TEST ForeGround Services")
            startForeground(1, mBuilder.build())


        }
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