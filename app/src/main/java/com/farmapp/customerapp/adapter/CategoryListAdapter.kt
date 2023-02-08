package com.farmapp.customerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farmapp.customerapp.R
import com.farmapp.customerapp.models.RestaurentModel
import java.util.*

class CategoryListAdapter(val restaurantList: List<RestaurentModel?>?, val clickListener:CategoryListClickListener): RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_banner_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(restaurantList?.get(position))
        holder.itemView.setOnClickListener {
            clickListener.onItemClick1(restaurantList?.get(position)!!)
        }
    }

    override fun getItemCount(): Int
    {
        return restaurantList?.size!!
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        ///val tvRestaurantName: TextView = view.findViewById(R.id.tvCategoryName)
        /* val tvRestaurantAddress: TextView = view.findViewById(R.id.tvRestaurantAddress)
         val tvRestaurantHours: TextView = view.findViewById(R.id.tvRestaurantHours) */
        fun bind(restaurentModel: RestaurentModel?) {
            //tvRestaurantName.text = restaurentModel?.name

            Glide.with(thumbImage)
                .load(restaurentModel?.image)
                .into(thumbImage)
        }
    }

    interface CategoryListClickListener {
        fun onItemClick1(restaurantModel: RestaurentModel)
    }

}