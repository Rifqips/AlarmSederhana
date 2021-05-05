package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class ReciverAlarm : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {

        var i = Intent(context,AlarmOnActivity::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(i)


    }

}