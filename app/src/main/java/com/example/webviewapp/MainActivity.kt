package com.example.webviewapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.webviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val items: Array<String> = resources.getStringArray(R.array.website_list)
            var checkItem = 0
            val m1 = MediaPlayer.create(this, R.raw.sound_1)
            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("Website")
                .setSingleChoiceItems(items, checkItem) { dialog, which ->
                    // action code
                    Toast.makeText(this, items[which], Toast.LENGTH_SHORT).show()
                    checkItem = which
                }
                .setPositiveButton("OK") { dialog, which ->
                    // action code for positive response
                    m1?.start()
                    Toast.makeText(this, which.toString(), Toast.LENGTH_SHORT).show()

                    webView = binding.webView
                    webView!!.webViewClient = WebViewClient()
                    when (items[checkItem]) {
                        "394276" -> webView!!.loadUrl("https://nhentai.to/g/394276")
                        "400019" -> webView!!.loadUrl("https://nhentai.to/g/400019")
                        "310428" -> webView!!.loadUrl("https://nhentai.to/g/310428")
                        "271008" -> webView!!.loadUrl("https://nhentai.to/g/271008")
                        "302340" -> webView!!.loadUrl("https://nhentai.to/g/302340")
                    }
                    val webSettings =webView!!.settings
                    webSettings.javaScriptEnabled = true

                }
                .setNegativeButton("CANCEL") { dialog, which ->
                    // action code for negative response
                    // m1?.start()

                }
                .show()
        }
    }
    override fun onBackPressed() {
        if (webView!!.canGoBack()){
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}