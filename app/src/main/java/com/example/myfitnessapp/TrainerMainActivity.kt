package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TrainerMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var btn = findViewById<Button>(R.id.button)
        
        enableEdgeToEdge()
        setContentView(R.layout.activity_trainer_main)
        val ed=findViewById<EditText>(R.id.editText)
        val bt=findViewById<Button>(R.id.button)
        bt.setOnClickListener {
            val intent =Intent(this,suggetion::class.java)
            val name=ed.text.toString()
            intent.putExtra("advice",name)


            startActivity(intent)
       
       
    }
}}