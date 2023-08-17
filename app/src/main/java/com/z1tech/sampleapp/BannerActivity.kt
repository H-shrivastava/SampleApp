package com.z1tech.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

class BannerActivity : AppCompatActivity() {

    // required for GAM setup
    val id ="/22100121508,22915391943/akash_test/z1tech_flapster/ellipsis_dfp_in_app_flapster_b_ellipsis_pre_1"
    private var adView: AdView? = null
    private var bannerAd:FrameLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        bannerAd=findViewById(R.id.bannerAd)

        //GAM Initialisation
        adView = AdView(this)
        adView!!.setAdSize(AdSize.BANNER)
        adView!!.setAdUnitId(id)
        adView!!.setAdListener(object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                Toast.makeText(
                    this@BannerActivity,
                    "Failed to load banner: $loadAdError",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        adView!!.loadAd(AdRequest.Builder().build())
        bannerAd?.removeAllViews()
        bannerAd?.addView(adView)
    }

}