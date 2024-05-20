package com.example.myfitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import de.hdodenhof.circleimageview.CircleImageView


class workout_fragment : Fragment() {
    private lateinit var webView: WebView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.workout,container,false)
        webView=view.findViewById(R.id.wv)
        webView.loadUrl("https://my-gym-trainer.vercel.app/fitness.html")
        return view
    }

}