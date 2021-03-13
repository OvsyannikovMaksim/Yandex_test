package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.ui.StocksFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab_layout)
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //выбор
                Log.d("TAG", "sel "+tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //повторное нажатие на выбранный уже
                Log.d("TAG", "resel "+tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //показывыает какой был выбран до переключения
                Log.d("TAG", "unsel "+tab)
            }
        })


        if (savedInstanceState == null) {
            fragmentTransaction
                .add(R.id.container, StocksFragment())
                .commit()
        }
    }



}