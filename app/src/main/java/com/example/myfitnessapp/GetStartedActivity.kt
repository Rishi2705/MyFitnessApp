package com.example.myfitnessapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_started)
        val la = findViewById<LottieAnimationView>(R.id.la)
        la.playAnimation()
        r
        la.resumeAnimation()
    }
}