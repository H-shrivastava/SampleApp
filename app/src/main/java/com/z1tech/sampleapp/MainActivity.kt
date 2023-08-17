package com.z1tech.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.banner).setOnClickListener {
            val intent = Intent(this@MainActivity, BannerActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.interstitial).setOnClickListener {
            val intent = Intent(this@MainActivity, InterstitialActivity::class.java)
            startActivity(intent)
        }
    }
}