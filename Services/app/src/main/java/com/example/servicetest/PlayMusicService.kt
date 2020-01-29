package com.example.servicetest

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class PlayMusicService : Service() {
    lateinit var musicPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
        musicPlayer = MediaPlayer.create(
            this,
            R.raw.music
        )//initialize music player
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        super.onStartCommand(intent, flags, startId)
        musicPlayer.start()
        return flags//this return statement specifies flags
    }

    override fun onBind(intent: Intent): IBinder?{
        Log.d(TAG, "onBind")
       return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        musicPlayer.release()
    }
    companion object{
        const val TAG = "PlayMusicService"
    }
}
