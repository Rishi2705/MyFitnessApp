package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [modify.newInstance] factory method to
 * create an instance of this fragment.
 */
class modify : Fragment() {
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = layoutInflater.inflate(R.layout.fragment_modify,container,false)
        btn1 = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)
        btn1.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity,SignInActivity::class.java))
        }
        btn2.setOnClickListener{
            val firebaseAuth = FirebaseAuth.getInstance()
            val currentUser = firebaseAuth.currentUser

            currentUser!!.delete().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("4", "OK! Works fine!")
                    startActivity(
                        Intent(
                            activity,
                            SignInActivity::class.java
                        )
                    )

                }
            }.addOnFailureListener { e ->
                Log.e(
                    "5",
                    "Ocurrio un error durante la eliminación del usuario",
                    e
                )
                Toast.makeText(activity,"Error123",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment modify.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            modify().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}