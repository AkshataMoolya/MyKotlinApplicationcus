package com.farmapp.customerapp

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.farmapp.customerapp.fragments.HomeFragment
import com.farmapp.customerapp.fragments.NotesFragment
import com.farmapp.customerapp.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_menu_main2.*


class MenuMainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }


    /*  private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.articlesFragment -> {
                viewPager.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.imagesFragment -> {
                viewPager.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.categoryFragment -> {
                viewPager.currentItem = 2
                return@OnItemSelectedListener true
            }
        }
        false
    }*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main2)
        bottomNavigationView.background = null
        //bottomNavigationView.menu.getItem(2).isEnabled = false

        val homeFragment = HomeFragment()
        val NotesFragment = NotesFragment()
        val profileFragment = ProfileFragment()


        loadFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> loadFragment(homeFragment)
                R.id.fav -> loadFragment(homeFragment)
                R.id.profile -> loadFragment(profileFragment)
                R.id.setting -> loadFragment(homeFragment)
            }
            true
        }
        /*bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.fav -> {
                    loadFragment(NotesFragment())
                    true
                }
                R.id.profile -> {
                    loadFragment(NotesFragment())
                    true
                }
                R.id.setting -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> {
                   // loadFragment(HomeFragment())
                    false
                }
            }
        }*/
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }

    }

    override fun onBackPressed() {
        finish()
    }
}