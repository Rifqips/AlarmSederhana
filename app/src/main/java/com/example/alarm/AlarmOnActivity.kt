package com.example.alarm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alarm_on.*

class AlarmOnActivity : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "com.example.alarm"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_on)

        var mp = MediaPlayer.create(applicationContext,R.raw.nice_alarm_sound)
        mp.start()

        btn_stopalarm.setOnClickListener{
            mp.stop()
            val kembaliset  = Intent(this,MainActivity::class.java)
            startActivity(kembaliset)
        }

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent  = Intent(this,AlarmOnActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                .setContentTitle("Alarm Berdering")
                .setContentText("Belajar Notifikasi")
                .setSmallIcon(R.drawable.ic_access_alarms_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_access_alarms_black_24dp))

        }else{
            builder = Notification.Builder(this)
                .setContentTitle("Alarm Berdering")
                .setContentText("Belajar Notifikasi")
                .setSmallIcon(R.drawable.ic_access_alarms_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_access_alarms_black_24dp))

        }

        notificationManager.notify(1234,builder.build())
    }
}
