package com.farmapp.customerapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farmapp.customerapp.*
import com.farmapp.customerapp.models.RestaurentModel

class MyListAdapter(val restaurantList: List<RestaurentModel?>?, val clickListener: MyListAdapter.RestaurantListClickListener): RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_profile_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(restaurantList?.get(position))
       /* holder.itemView.setOnClickListener {
            clickListener.onItemClick(restaurantList?.get(position)!!)
        }*/

        if(position==0){
            holder.itemView.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    val activity=v!!.context as AppCompatActivity
                    /*val demofragment=HomeFragment()
                    activity.supportFragmentManager.beginTransaction().replace(R.id.container,demofragment).addToBackStack(null).commit()
               */
                    val intent = Intent(v.context, OrdersActivity::class.java)
                    v.context.startActivity(intent)
                }
            })
        }
        else if(position==1){
            holder.itemView.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    val activity=v!!.context as AppCompatActivity
                    /*val demofragment=HomeFragment()
                    activity.supportFragmentManager.beginTransaction().replace(R.id.container,demofragment).addToBackStack(null).commit()
               */
                    val intent = Intent(v.context, MyProfile::class.java)
                    v.context.startActivity(intent)
                }
            })
        }
        else if(position==4){
            holder.itemView.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    val activity=v!!.context as AppCompatActivity
                    /*val demofragment=HomeFragment()
                    activity.supportFragmentManager.beginTransaction().replace(R.id.container,demofragment).addToBackStack(null).commit()
               */
                    val intent = Intent(v.context, Notifications::class.java)
                    v.context.startActivity(intent)
                }
            })
        }
        else if(position==6){
            holder.itemView.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    val activity=v!!.context as AppCompatActivity
                    /*val demofragment=HomeFragment()
                    activity.supportFragmentManager.beginTransaction().replace(R.id.container,demofragment).addToBackStack(null).commit()
               */
                    val intent = Intent(v.context, ContactUs::class.java)
                    v.context.startActivity(intent)
                }
            })
        }







    }

    override fun getItemCount(): Int {
        return restaurantList?.size!!
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        val tvRestaurantName: TextView = view.findViewById(R.id.profilemenu)
        /* val tvRestaurantAddress: TextView = view.findViewById(R.id.tvRestaurantAddress)
         val tvRestaurantHours: TextView = view.findViewById(R.id.tvRestaurantHours)
 */
        fun bind(restaurentModel: RestaurentModel?) {
            tvRestaurantName.text = restaurentModel?.name

            Glide.with(thumbImage)
                .load(restaurentModel?.image)
                .into(thumbImage)
        }

    }



    interface RestaurantListClickListener {
        fun onItemClick(restaurantModel: RestaurentModel)
    }

}