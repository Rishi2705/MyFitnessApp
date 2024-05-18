package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SplashScrenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_scren)
        val iv = findViewById<ImageView>(R.id.imageView)
        supportActionBar?.hide()
        iv.alpha = 0f
        iv.animate().setDuration(1000).alpha(1f).withEndAction{
            startActivity(Intent(this,GetStartedActivity::class.java))
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }

    }
}