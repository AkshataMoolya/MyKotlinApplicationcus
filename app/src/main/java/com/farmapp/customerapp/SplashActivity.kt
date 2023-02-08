package com.farmapp.customerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.farmapp.customerapp.R
import android.widget.ImageView
import com.bumptech.glide.Glide


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val imageView: ImageView = findViewById<android.view.View>(R.id.imageview) as ImageView
        Glide.with(this).asGif().load(R.raw.farmer).into(imageView)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 2000)
    }
}