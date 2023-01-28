package com.example.broadcastservices.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


//STEP 1
class MyBroadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.e("TAG", "onReceive")
    }
}