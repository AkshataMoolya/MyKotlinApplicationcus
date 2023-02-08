package com.farmapp.customerapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.farmapp.customerapp.fragments.HomeFragment
import com.farmapp.customerapp.fragments.NotesFragment


class ViewPagerAdapter(appCompatActivity : AppCompatActivity) : FragmentStateAdapter(appCompatActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> NotesFragment()
            2 -> HomeFragment()
            else -> HomeFragment()
        }
    }
}