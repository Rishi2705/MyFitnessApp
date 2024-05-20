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
        enableEdgeToEdge()
        setContentView(R.layout.activity_trainer_main)
        var btn = findViewById<Button>(R.id.button)
        var edt1 = findViewById<EditText>(R.id.editText)
        var edt2 = findViewById<EditText>(R.id.edttxt1)
        var inte = edt1.editableText.toString()
        btn.setOnClickListener {
            edt2.text = inte.e

        }
    }
}