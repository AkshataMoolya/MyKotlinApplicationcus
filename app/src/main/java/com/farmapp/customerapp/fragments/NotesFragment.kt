package com.farmapp.customerapp.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.farmapp.customerapp.R
import com.farmapp.customerapp.RestaurantMenuActivity
import com.farmapp.customerapp.adapter.CategoryListAdapter
import com.farmapp.customerapp.adapter.RestaurantListAdapter
import com.farmapp.customerapp.models.RestaurentModel
import kotlinx.android.synthetic.main.homefragment.*
import java.io.*
import java.lang.Exception

class NotesFragment : Fragment(),RestaurantListAdapter.RestaurantListClickListener, CategoryListAdapter.CategoryListClickListener{

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)



       /* val restaurantModel = getRestaurantData()
        initRecyclerView(restaurantModel)


        val categoriesModel = getRestaurantData1()
        initRecyclerView1(categoriesModel)*/

    }

    private fun initRecyclerView(restaurantList: List<RestaurentModel?>?) {
        val recyclerViewRestaurant = getActivity()?.findViewById<RecyclerView>(R.id.recyclerViewRestaurant)

        // recyclerViewRestaurant.layoutManager = LinearLayoutManager(this)
        recyclerViewRestaurant?.layoutManager = GridLayoutManager(activity,2)
        val adapter = RestaurantListAdapter(restaurantList,this)
        recyclerViewRestaurant?.adapter =adapter

    }
    private fun initRecyclerView1(restaurantList: List<RestaurentModel?>?) {
        val recyclerViewCategories = getActivity()?.findViewById<RecyclerView>(R.id.categories)

        // recyclerViewRestaurant.layoutManager = LinearLayoutManager(this)
        recyclerViewCategories?.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        val adapter1 = CategoryListAdapter(restaurantList,this)
        recyclerViewCategories?.adapter =adapter1
    }

    private fun getRestaurantData(): List<RestaurentModel?>? {
        //val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val inputStream: InputStream = resources.openRawResource(R.raw.categories)
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


    private fun getRestaurantData1(): List<RestaurentModel?>? {
        //val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val inputStream: InputStream = resources.openRawResource(R.raw.banner)
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
        val restaurantModel1 = gson.fromJson<Array<RestaurentModel>>(jsonStr, Array<RestaurentModel>::class.java).toList()

        return restaurantModel1
    }


    override fun onItemClick(restaurantModel: RestaurentModel) {
        val intent = Intent(context, RestaurantMenuActivity::class.java)
        intent.putExtra("RestaurantModel", restaurantModel)
        startActivity(intent)
    }

    override fun onItemClick1(restaurantModel: RestaurentModel) {
        /*  val intent = Intent(context, RestaurantMenuActivity::class.java)
          intent.putExtra("RestaurantModel", restaurantModel)
          startActivity(intent)*/
    }
}