package com.dragoncorp.mqttbroker

import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast
import io.moquette.server.Server

class MQTTBrokerService : Service() {

    private var sLooper : Looper? = null
    private var sHandler : ServiceHandler? = null

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message){
            try{
                Thread.sleep(5*1000)
            }catch (e:InterruptedException){
                Thread.currentThread().interrupt()
            }

            stopSelf(msg.arg1)
        }
    }

    override fun onCreate() {
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()
            sLooper = looper
            sHandler = ServiceHandler(looper)
        }
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext,"Starting MQTT service...", Toast.LENGTH_SHORT).show()
        Server().startServer()
        sHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            sHandler?.sendMessage(msg)
        }
        return START_STICKY
        //return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent?): IBinder? {
        //TODO("Not sure if I wanna implement binding")
        return null
    }
    override fun onDestroy() {
        Toast.makeText(applicationContext,"MQTT service stopped!", Toast.LENGTH_SHORT).show()
        Server().stopServer()
        super.onDestroy()
    }}