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
            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("USC CpE Dept. Websites")
                .setSingleChoiceItems(items, checkItem) { dialog, which ->
                    // action code
                    Toast.makeText(this, items[which], Toast.LENGTH_SHORT).show()
                    checkItem = which
                }
                .setPositiveButton("OK") { dialog, which ->
                    // action code for positive response
                    Toast.makeText(this, which.toString(), Toast.LENGTH_SHORT).show()

                    webView = binding.webView
                    webView!!.webViewClient = WebViewClient()
                    when (items[checkItem]) {
                        "CpE Dept. Facebook" -> webView!!.loadUrl("https://www.facebook.com/usccpe")
                        "CpE Council Facebook" -> webView!!.loadUrl("https://www.facebook.com/USCCpECouncil")
                        "CpE Council Instagram" -> webView!!.loadUrl("https://www.instagram.com/usc.cpec/")
                        "CpE Council TikTok" -> webView!!.loadUrl("https://www.tiktok.com/@usc.cpec")
                        "Apply To USC" -> webView!!.loadUrl("https://www.usc.edu.ph/admission/apply-to-usc")
                    }
                    val webSettings =webView!!.settings
                    webSettings.javaScriptEnabled = true

                }
                .setNegativeButton("CANCEL") { dialog, which ->
                    Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
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