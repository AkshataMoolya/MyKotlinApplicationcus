package com.farmapp.customerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.farmapp.customerapp.adapter.OrdersListAdapter
import com.farmapp.customerapp.models.OrderModel
import kotlinx.android.synthetic.main.activity_orders.*
import java.io.*
import java.lang.Exception

class OrdersActivity : AppCompatActivity(), OrdersListAdapter.OrderListClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
     /*   setupViewPager(viewPager2)

        tabLayout!!.setupWithViewPager(viewPager2)*/


        val categoriesModel = getRestaurantData()
        initRecyclerView(categoriesModel)
    }
    private fun initRecyclerView(restaurantList: List<OrderModel?>?) {
        val recyclerViewRestaurant = findViewById<RecyclerView>(R.id.recyclerViewRestaurant)

        recyclerViewRestaurant?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = OrdersListAdapter(restaurantList,this)
        recyclerViewRestaurant?.adapter =adapter

        adapter.notifyDataSetChanged()


    }

    private fun getRestaurantData(): List<OrderModel?>? {
        //val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val inputStream: InputStream = resources.openRawResource(R.raw.orderslist)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n : Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)

            }

        }catch (e: Exception){}
        val jsonStr: String = writer.toString()
        val gson = Gson()
        val orderModel = gson.fromJson<Array<OrderModel>>(jsonStr, Array<OrderModel>::class.java).toList()

        return orderModel
    }

 /*   private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Ongoingorders(), "Home")
        // adapter.addFragment(AboutUsFragment(), "About Us")
        adapter.addFragment(Previousorders(), "Contact Us")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }*/

    override fun onItemClick(orderModel: OrderModel) {
        /*   val intent = Intent(context, RestaurantMenuActivity::class.java)
           intent.putExtra("RestaurantModel", restaurantModel)
           startActivity(intent)*/
    }
}