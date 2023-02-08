package com.farmapp.customerapp.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farmapp.customerapp.R
import com.farmapp.customerapp.SignInActivity
import com.farmapp.customerapp.databinding.ActivityPasswordResetSuccessBinding

class PasswordResetSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordResetSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset_success)

        binding = ActivityPasswordResetSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}