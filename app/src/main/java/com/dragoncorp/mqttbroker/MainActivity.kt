package com.dragoncorp.mqttbroker

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.moquette.server.Server


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.button).setOnClickListener()
    }

    fun startMQTTService(view: View) {
        Intent(this, MQTTBrokerService::class.java).also { intent ->
            startService(intent)
        }
    }
}
