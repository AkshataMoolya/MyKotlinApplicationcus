package com.farmapp.customerapp.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farmapp.customerapp.R
import com.farmapp.customerapp.databinding.ActivityResetPasswordctivityBinding

class ResetPasswordctivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordctivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_passwordctivity)

        binding = ActivityResetPasswordctivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, PasswordResetSuccessActivity::class.java)
            startActivity(intent)
        }

    }
}