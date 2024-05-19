package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OptionsActicvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options_acticvity)
        val rg = findViewById<RadioGroup>(R.id.rg)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val rv = rg.checkedRadioButtonId
            val rv1 = findViewById<RadioButton>(rv)
            if (rv1.text.toString() == "User") {
                startActivity(Intent(this, DoctorActivity::class.java))
            } else if (rv1.text.toString() == "Trainer") {
                startActivity(Intent(this, DoctorActivity::class.java))
            } else if (rv1.text.toString() == "Dietitian") {
                startActivity(Intent(this, DoctorActivity::class.java))
            }
            else if(rv1.text.toString() == "Doctor"){
                startActivity(Intent(this, DoctorActivity::class.java))
            }
        }
    }
}