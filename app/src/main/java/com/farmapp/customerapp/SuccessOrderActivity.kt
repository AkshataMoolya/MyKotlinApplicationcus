package com.farmapp.customerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.farmapp.customerapp.models.RestaurentModel
import kotlinx.android.synthetic.main.activity_success_order.*

class SuccessOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_order)

        val restaurantModel: RestaurentModel? = intent.getParcelableExtra("RestaurantModel")
        val actionbar: ActionBar? = supportActionBar
        actionbar?.setTitle(restaurantModel?.name)
        actionbar?.setDisplayHomeAsUpEnabled(false)

        back_to_home_btn.setOnClickListener {
            /*setResult(RESULT_OK)
            finish()*/

            val intent = Intent(this, OrdertrackActivity::class.java)
            startActivity(intent)
        }
    }
}