package com.example.myfitnessapp

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import de.hdodenhof.circleimageview.CircleImageView

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_started)
        val btn = findViewById<CircleImageView>(R.id.arrow)
        val la = findViewById<LottieAnimationView>(R.id.la)
        la.playAnimation()
        la.addAnimatorListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                la.playAnimation()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })
        btn.isClickable = true
        btn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
    }
}