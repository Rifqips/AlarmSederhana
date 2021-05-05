package com.example.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_setalarm.setOnClickListener{
            var det = jml_detik.text.toString().toInt()
            var i   = Intent(applicationContext, ReciverAlarm::class.java)
            var pi  = PendingIntent.getBroadcast(applicationContext, 111,i,0)
            var am : AlarmManager  = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(det*1000),pi)
            Toast.makeText(applicationContext,"Alarm sudah di set selama $det detik",Toast.LENGTH_LONG).show()
         }

    }

    override fun onClick(v: View?) {

    }


}
