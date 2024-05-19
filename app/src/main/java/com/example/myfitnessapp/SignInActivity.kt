package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.core.Rive
import com.example.myfitnessapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val ourmachinename = "Login Machine"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Rive.init(this)
        binding.email.setOnFocusChangeListener {view , hasFocus ->
            if(hasFocus){
                binding.signinchar.controller.setBooleanState(ourmachinename, "isChecking", true)
            }else{
                binding.signinchar.controller.setBooleanState(ourmachinename, "isChecking", false)
            }
        }
        binding.email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    binding.signinchar.controller.setNumberState(ourmachinename, "numLook", s!!.length.toFloat())
                } catch (e : Exception){
                }

            }

        })
        binding.password.setOnFocusChangeListener {view , hasFocus ->
            if(hasFocus){
                binding.signinchar.controller.setBooleanState(ourmachinename, "isHandsUp", true)
            }else{
                binding.signinchar.controller.setBooleanState(ourmachinename, "isHandsUp", false)
            }
        }
        binding.loginbtn.setOnClickListener{
            binding.password.clearFocus()
            Handler().postDelayed({
                if(binding.email.text!!.isEmpty()|| binding.password.text!!.isEmpty()||(binding.email.text.toString() != "aksingh9363@gmail.com"||binding.password.text.toString() !="chutiya123")){
                    binding.signinchar.controller.fireState(ourmachinename, "trigFail")
                }else{
                    binding.signinchar.controller.fireState(ourmachinename, "trigSuccess")
                }
            },200)

        }
        val btn = findViewById<Button>(R.id.signupbtn)
        btn.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        val btn1 = findViewById<Button>(R.id.loginbtn)
        btn1.setOnClickListener {
            if(binding.email.text.toString() == "aksingh9363@gmail.com"&& binding.password.text.toString() == "chutiya123"){
                startActivity(Intent(this,OptionsActicvity::class.java))
            }else{
                Toast.makeText(this@SignInActivity,"Wrong id or password",Toast.LENGTH_SHORT).show()
            }

        }
    }
}