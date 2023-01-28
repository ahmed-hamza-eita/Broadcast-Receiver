package com.example.broadcastservices

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastservices.broadcast.MyBroadcast
import com.example.broadcastservices.services.MyServices

//STEP 4
val myBroadcast = MyBroadcast()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //STEP 5
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(myBroadcast, intentFilter)


        //STEP 3
        val intent = Intent(this, MyServices::class.java)
        startService(intent)

        val intent2 = Intent(this, MainActivity2::class.java)
        startService(intent2)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        //STEP 6
        unregisterReceiver(myBroadcast)
    }
}