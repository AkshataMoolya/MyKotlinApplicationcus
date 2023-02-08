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
import com.farmapp.customerapp.adapter.OrdersListAdapter
import com.farmapp.customerapp.models.OrderModel
import java.io.*
import java.lang.Exception

class Ongoingorders : Fragment(), OrdersListAdapter.OrderListClickListener {
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.homefragment, container, false)

        val view: View = inflater!!.inflate(R.layout.fragment_ongoingorders, container, false)

        return view
    }


    companion object {
        fun newInstance() = Ongoingorders()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        val categoriesModel = getRestaurantData()
        initRecyclerView(categoriesModel)

    }

    private fun initRecyclerView(restaurantList: List<OrderModel?>?) {
        val recyclerViewRestaurant = getActivity()?.findViewById<RecyclerView>(R.id.recyclerViewRestaurant)

        recyclerViewRestaurant?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
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


    override fun onItemClick(orderModel: OrderModel) {
     /*   val intent = Intent(context, RestaurantMenuActivity::class.java)
        intent.putExtra("RestaurantModel", restaurantModel)
        startActivity(intent)*/
    }

}