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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rive.runtime.kotlin.core.Rive
import com.example.myfitnessapp.databinding.ActivitySignInBinding
import com.example.myfitnessapp.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val ourmachinename = "Login Machine"
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Rive.init(this)
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
        auth = Firebase.auth
        var em = findViewById<EditText>(R.id.email)
        var pass = findViewById<EditText>(R.id.password)


        val btn = findViewById<Button>(R.id.signupbtn)
        btn.setOnClickListener {
            var email = em.text.toString()
            var password = pass.text.toString()
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("hello", "createUserWithEmail:success")
                        Toast.makeText(baseContext,"Authentication Success",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,SignInActivity::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Bye", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }
}