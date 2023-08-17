package com.z1tech.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialActivity : AppCompatActivity() {
    val mInterstitialAdId ="/22100121508/montest/net_one97_paytm/ellipsis_dfp_in_app_paytm_secure_in_ellipsis_pre_1"
    private var interstitial: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)
        InterstitialAd.load(this@InterstitialActivity,
            mInterstitialAdId,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitial = interstitialAd
                    interstitial!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                        override fun onAdFailedToShowFullScreenContent(error: AdError) {
                            Toast.makeText(
                                this@InterstitialActivity,
                                "Failed to show interstitial: $error",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                        override fun onAdDismissedFullScreenContent() {
                            val intent = Intent(this@InterstitialActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                    if (interstitial != null) {
                        interstitial!!.show(this@InterstitialActivity)
                    }

                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Toast.makeText(
                        this@InterstitialActivity,
                        "Failed to load interstitial: $loadAdError",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }
}