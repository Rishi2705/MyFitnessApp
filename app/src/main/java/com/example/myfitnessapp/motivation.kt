package com.example.myfitnessapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.fragment.app.Fragment


class motivation_fragment : Fragment() {
    private lateinit var wb1: WebView
    private lateinit var wb2: WebView
    private lateinit var wb3: WebView
    private lateinit var wb4: WebView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.motivation,container,false)
        wb1 = view.findViewById(R.id.yt1)
        val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KsCrNFrPKU8?si=h3PK5opPJKmQnit-\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        wb1.loadData(video1,"text/html","utf-8")
        wb1.getSettings().javaScriptEnabled = true
        wb1.webChromeClient = WebChromeClient()

        wb2 = view.findViewById(R.id.yt2)
        val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eaRQF-7hhmo?si=3BBUVM1cCIn-gxvy\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        wb2.loadData(video2,"text/html","utf-8")
        wb2.getSettings().javaScriptEnabled = true
        wb2.webChromeClient = WebChromeClient()

        wb3 = view.findViewById(R.id.yt3)
        val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/IpUQElrETw4?si=G_tFa_jakwKBjzfI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        wb3.loadData(video3,"text/html","utf-8")
        wb3.getSettings().javaScriptEnabled = true
        wb3.webChromeClient = WebChromeClient()

        wb4 = view.findViewById(R.id.yt4)
        val video4 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zRf3iMKW87M?si=ldSk7MoFUxN47Ogc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        wb4.loadData(video4,"text/html","utf-8")
        wb4.getSettings().javaScriptEnabled = true
        wb4.webChromeClient = WebChromeClient()


        return view
    }
}