package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rive.runtime.kotlin.core.Rive
import com.example.myfitnessapp.databinding.ActivitySignInBinding
import com.example.myfitnessapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val ourmachinename = "Login Machine"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Rive.init(this)
        binding.name.setOnFocusChangeListener {view , hasFocus ->
            if(hasFocus){
                binding.signupchar.controller.setBooleanState(ourmachinename, "isChecking", true)
            }else{
                binding.signupchar.controller.setBooleanState(ourmachinename, "isChecking", false)
            }
        }
        binding.name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    binding.signupchar.controller.setNumberState(ourmachinename, "numLook", s!!.length.toFloat())
                } catch (e : Exception){
                }

            }

        })
        binding.email.setOnFocusChangeListener {view , hasFocus ->
            if(hasFocus){
                binding.signupchar.controller.setBooleanState(ourmachinename, "isChecking", true)
            }else{
                binding.signupchar.controller.setBooleanState(ourmachinename, "isChecking", false)
            }
        }
        binding.email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    binding.signupchar.controller.setNumberState(ourmachinename, "numLook", s!!.length.toFloat())
                } catch (e : Exception){
                }

            }

        })

            val btn = findViewById<Button>(R.id.signupbtn)
            btn.setOnClickListener {
                startActivity(Intent(this,OptionsActicvity::class.java))
            }
    }
}