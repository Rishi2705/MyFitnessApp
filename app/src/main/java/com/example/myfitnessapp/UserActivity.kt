package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        var edt1 = findViewById<TextInputEditText>(R.id.edt1)
        var edt2 = findViewById<TextInputEditText>(R.id.edt2)
        var edt3 = findViewById<TextInputEditText>(R.id.edt3)
        var edt4 = findViewById<TextInputEditText>(R.id.edt4)
        var edt5 = findViewById<TextInputEditText>(R.id.edt5)
        val btn = findViewById<AppCompatButton>(R.id.appCompatButton)
        btn.setOnClickListener{
            if(edt1.text.toString().isNotEmpty() && edt2.text.toString().isNotEmpty()&&edt3.text.toString().isNotEmpty()&&edt4.text.toString().isNotEmpty()&&edt5.text.toString().isNotEmpty()) {
                startActivity(Intent(this, bottom_navigation::class.java))
                finish()
            }else{
                Toast.makeText(this,"All fields are mandatory to fill . Please try again ",Toast.LENGTH_LONG).show()
            }
        }
    }
}