package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import app.rive.runtime.kotlin.core.Rive
import com.example.myfitnessapp.databinding.ActivitySignInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val ourmachinename = "Login Machine"
    private lateinit var auth : FirebaseAuth
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
                if(binding.email.text!!.isEmpty()|| binding.password.text!!.isEmpty()||(binding.email.text.toString() != "abc@gmail.com"||binding.password.text.toString() !="abc123")){
                    binding.signinchar.controller.fireState(ourmachinename, "trigFail")
                }else{
                    binding.signinchar.controller.fireState(ourmachinename, "trigSuccess")
                }
            },200)

        }
        var em = findViewById<EditText>(R.id.email)

        var pasd = findViewById<EditText>(R.id.password)

        val btn = findViewById<Button>(R.id.signupbtn)
        btn.setOnClickListener {

            startActivity(Intent(this,SignUpActivity::class.java))
        }

        auth = Firebase.auth
        val btn1 = findViewById<Button>(R.id.loginbtn)
        btn1.setOnClickListener {
            var email = em.text.toString()
            var password = pasd.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("hello", "signInWithEmail:success")
                        startActivity(Intent(this,bottom_navigation::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("bye", "signInWithEmail:failure = ${task.exception!!.message}")
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        }
        val rp = findViewById<Button>(R.id.reset_password)
        rp.setOnClickListener {
            var email = em.text.toString()
            startActivity(Intent(this,ResetPassword::class.java).putExtra("id",email))
        }
    }
}