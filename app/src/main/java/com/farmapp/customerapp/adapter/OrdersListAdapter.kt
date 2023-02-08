package com.farmapp.customerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farmapp.customerapp.R
import com.farmapp.customerapp.models.OrderModel

class OrdersListAdapter (val restaurantList: List<OrderModel?>?, val clickListener: OrdersListAdapter.OrderListClickListener): RecyclerView.Adapter<OrdersListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_orders_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(restaurantList?.get(position))
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(restaurantList?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList?.size!!
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val orderid: TextView = view.findViewById(R.id.orderid)
        val orderlist: TextView = view.findViewById(R.id.orderlist)
         val totalbill: TextView = view.findViewById(R.id.totalbill)
         val status: TextView = view.findViewById(R.id.status)
        val orderdate: TextView = view.findViewById(R.id.orderdate)

        fun bind(orderModel: OrderModel?) {
            orderid.text = orderModel?.orderid
            orderlist.text = orderModel?.orderlist?.size.toString()+" items >"
            totalbill.text = "₹"+orderModel?.totalbill
            status.text = orderModel?.status
            orderdate.text = orderModel?.date
        }
    }


    interface OrderListClickListener {
        fun onItemClick(orderModel: OrderModel)
    }

}