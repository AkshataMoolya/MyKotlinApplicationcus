package com.farmapp.customerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.farmapp.customerapp.adapter.NotificationsListAdapter
import com.farmapp.customerapp.models.NotificationModel
import java.io.*
import java.lang.Exception

class Notifications : AppCompatActivity(), NotificationsListAdapter.NotificationlistClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        /*   setupViewPager(viewPager2)

           tabLayout!!.setupWithViewPager(viewPager2)*/


        val notificationModel = getRestaurantData()
        initRecyclerView(notificationModel)
    }
    private fun initRecyclerView(restaurantList: List<NotificationModel?>?) {
        val recyclerViewRestaurant = findViewById<RecyclerView>(R.id.notificationlist)

        recyclerViewRestaurant?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = NotificationsListAdapter(restaurantList,this)
        recyclerViewRestaurant?.adapter =adapter

        adapter.notifyDataSetChanged()


    }

    private fun getRestaurantData(): List<NotificationModel?>? {
        //val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val inputStream: InputStream = resources.openRawResource(R.raw.notification)
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
        val notificationModel = gson.fromJson<Array<NotificationModel>>(jsonStr, Array<NotificationModel>::class.java).toList()

        return notificationModel
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

    override fun onItemClick(notificationModel: NotificationModel) {
        /*   val intent = Intent(context, RestaurantMenuActivity::class.java)
           intent.putExtra("RestaurantModel", restaurantModel)
           startActivity(intent)*/
    }
}