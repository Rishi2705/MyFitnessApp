package com.example.myfitnessapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class suggetion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suggetion)
        val advice=intent.getStringExtra("advice")
        val string=advice
        val sd=findViewById<TextView>(R.id.txt)
        sd.text=string

    }
}