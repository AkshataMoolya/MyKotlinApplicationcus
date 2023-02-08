package com.farmapp.customerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farmapp.customerapp.R
import com.farmapp.customerapp.models.NotificationModel

class NotificationsListAdapter (val notificationlist: List<NotificationModel?>?, val clickListener: NotificationsListAdapter.NotificationlistClickListener): RecyclerView.Adapter<NotificationsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_notification_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(notificationlist?.get(position))
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(notificationlist?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        return notificationlist?.size!!
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val notificationid: TextView = view.findViewById(R.id.notificationtext)

        fun bind(notificationModel: NotificationModel?) {
            notificationid.text = notificationModel?.notification
        }
    }

    interface NotificationlistClickListener {
        fun onItemClick(notificationModel: NotificationModel)
    }

}