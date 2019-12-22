package com.game.kotvitz.war.activity

import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.game.kotvitz.war.GameMedia
import com.game.kotvitz.war.LocaleManager
import com.game.kotvitz.war.R
import com.game.kotvitz.war.ScreenDesigner


class LanguageChoice : AppCompatActivity() {

    private val gameMedia = GameMedia()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_choice)
        ScreenDesigner.callFullScreenMode(window)
        volumeControlStream = AudioManager.STREAM_MUSIC
        val langEn = findViewById<ImageView>(R.id.langEn)
        val mainMenu = Intent(this, MainMenuActivity::class.java)
        langEn.setOnClickListener {
            gameMedia.playClickSound(baseContext)
            LocaleManager.setLocale("en-us", mainMenu, resources)
            startActivity(mainMenu)
        }
        val langPol = findViewById<ImageView>(R.id.langPol)
        langPol.setOnClickListener {
            gameMedia.playClickSound(baseContext)
            LocaleManager.setLocale("pl", mainMenu, resources)
            startActivity(mainMenu)
        }
    }

    override fun onBackPressed() {
        gameMedia.playClickSound(baseContext)
        moveTaskToBack(true)
    }
}