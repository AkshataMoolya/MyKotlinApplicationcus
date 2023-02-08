package com.farmapp.customerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemsAdapter(private val onboardingItems: List<OnboardingItem>):
    RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {

    inner class OnboardingItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val imageOnboarding=view.findViewById<ImageView>(R.id.imageOnboarding)
        private val title=view.findViewById<TextView>(R.id.textTitle)
        private val description=view.findViewById<TextView>(R.id.textDescription)

        fun bind(onboardingItem: OnboardingItem){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            title.text=onboardingItem.title
            description.text=onboardingItem.discription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
   LayoutInflater.from(parent.context).inflate(
       R.layout.onboarding_item_container,
       parent,
       false)
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItems[position])
    }

    override fun getItemCount(): Int {
      return onboardingItems.size
    }
}