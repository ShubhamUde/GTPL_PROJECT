package com.internshipproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.internshipproject.Fragment.HomeFragment
import com.internshipproject.Fragment.PersonFragment


class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        loadFragment(HomeFragment.newInstance())

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.home -> {
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.person -> {
                    fragment = PersonFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }

        }

    }

    private fun loadFragment(newInstance: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myFrameLayout, newInstance)
            commit()
        }
    }
}