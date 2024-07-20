package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashScrenActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_scren)
        auth = Firebase.auth
        /*val iv = findViewById<ImageView>(R.id.imageView)*/
        supportActionBar?.hide()
        /*val iv = findViewById<ImageView>(R.id.imageView)
        iv.alpha = 0f
        iv.animate().setDuration(1000).alpha(1f).withEndAction{
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }*/

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val iv = findViewById<ImageView>(R.id.imageView)
            iv.alpha = 0f
            iv.animate().setDuration(1000).alpha(1f).withEndAction{
                startActivity(Intent(this,bottom_navigation::class.java))
                overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,androidx.appcompat.R.anim.abc_fade_out)
                finish()
            }
        }else{
            val iv = findViewById<ImageView>(R.id.imageView)
            iv.alpha = 0f
            iv.animate().setDuration(1000).alpha(1f).withEndAction{
                startActivity(Intent(this,GetStartedActivity::class.java))
                overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,androidx.appcompat.R.anim.abc_fade_out)
                finish()
            }
        }
    }
}