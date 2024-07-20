package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfitnessapp.databinding.ActivityResetPasswordBinding
import com.example.myfitnessapp.databinding.ActivityUserBinding
import com.google.android.material.textfield.TextInputEditText

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val btn = findViewById<AppCompatButton>(R.id.appCompatButton)
        binding.appCompatButton.setOnClickListener{
            if(binding.edt1.text.toString().isNotEmpty() && binding.edt2.text.toString().isNotEmpty()&&binding.edt3.text.toString().isNotEmpty()&&binding.edt4.text.toString().isNotEmpty()&&binding.edt5.text.toString().isNotEmpty()) {
                val edt1 = binding.edt1.text.toString()
                val edt2 = binding.edt2.text.toString()
                val edt3 = binding.edt3.text.toString()
                val edt4 = binding.edt4.text.toString()
                val edt5 = binding.edt5.text.toString()
                val edt6 = binding.edt6.text.toString()
                val data = User(edt1,edt2,edt3,edt4,edt5,edt6)
                FirebaseInstance.db.collection("users")
                    .document(data.name)
                    .set(data)
                    .addOnSuccessListener {
                        Toast.makeText(this,"Data stored successfully",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, bottom_navigation::class.java)
                        Log.d("MyTag", "onCreate: ${data.name}")
                        intent.putExtra("name",data.name)
                        startActivity(intent)
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"Failed to store data",Toast.LENGTH_SHORT).show()
                    }
            }else{
                Toast.makeText(this,"All fields are mandatory to fill . Please try again ",Toast.LENGTH_LONG).show()
            }
        }
    }
}