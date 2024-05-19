package com.example.fitness_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottom_navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val Workout=workout_fragment()
        val supplement=supplement_fragment()
        val motivation=motivation_fragment()
        setcurrrentfragment(Workout)
        val btmnav=findViewById<BottomNavigationView>(R.id.btmnav)
        btmnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.workout -> setcurrrentfragment(Workout)
                R.id.supplement->setcurrrentfragment(supplement)
                R.id.motivation->setcurrrentfragment(motivation)
            }
            true
        }

    }
    private fun setcurrrentfragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame,fragment)
            commit()
        }

}