package com.farmapp.customerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.farmapp.customerapp.R
import com.farmapp.customerapp.adapter.MyListAdapter
import com.farmapp.customerapp.models.RestaurentModel
import java.io.*
import java.lang.Exception


class ProfileFragment : Fragment(),MyListAdapter.RestaurantListClickListener{
    private lateinit var viewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_profile, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_profile, container, false)

      /*  val context = context as MenuMainActivity

        val centerlist = resources.getStringArray(R.array.profile)
        val imglist = resources.getStringArray(R.array.profileimg)

        val lv = view.findViewById(R.id.profilelist) as ListView
        val adapter = MyListAdapter(context, centerlist,imglist)
        lv.adapter = adapter
*/
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // initViews()

        val restaurantModel = getRestaurantData()
        initRecyclerView(restaurantModel)

    }

    companion object {
        fun newInstance() = ProfileFragment()
    }


    private fun initRecyclerView(restaurantList: List<RestaurentModel?>?) {
        val recyclerViewProfile= getActivity()?.findViewById<RecyclerView>(R.id.profilelist)

        // recyclerViewRestaurant.layoutManager = LinearLayoutManager(this)
        recyclerViewProfile?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val adapter = MyListAdapter(restaurantList,this)
        recyclerViewProfile?.adapter =adapter

        adapter.notifyDataSetChanged()

    }

    private fun getRestaurantData(): List<RestaurentModel?>? {
        //val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val inputStream: InputStream = resources.openRawResource(R.raw.profielist)
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
        val restaurantModel = gson.fromJson<Array<RestaurentModel>>(jsonStr, Array<RestaurentModel>::class.java).toList()

        return restaurantModel
    }

    override fun onItemClick(restaurantModel: RestaurentModel) {
       /* val intent = Intent(context, ProfileActivity::class.java)
        intent.putExtra("RestaurantModel", restaurantModel)
        startActivity(intent)*/




    }
}