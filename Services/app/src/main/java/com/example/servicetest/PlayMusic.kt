package com.example.servicetest

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.media.MediaPlayer
import android.util.Log


class PlayMusic : IntentService("PlayMusic") {


    override fun onCreate() {
        super.onCreate()
//        musicPlayer = MediaPlayer.create(
//            this,
//            R.raw.music
//        )
    }

    override fun onHandleIntent(intent: Intent?) {
      Log.d(TAG, "onHandleIntent" + (musicPlayer == null))
        if(musicPlayer == null)
            musicPlayer = MediaPlayer.create(
                this,
                R.raw.music
            )
        when(intent?.action){
            "STOP" -> {
                musicPlayer?.release()
                musicPlayer = null
            }
            "PLAY" -> musicPlayer?.start()
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }


    companion object {

      const val TAG = "PlayMusic"
        var musicPlayer: MediaPlayer? = null

    }
}
