package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.FavoriteFragment
import com.example.myapplication.ui.SearchFragment
import com.example.myapplication.ui.StocksFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //выбор
                Log.d("TabLayout", "sel "+tab?.position)
                chooseFragment(tab?.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //повторное нажатие на выбранный уже
                Log.d("TabLayout", "sel "+tab?.position)
                chooseFragment(tab?.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //показывыает какой был выбран до переключения
            }
        })

        binding.textInputEditText.setOnClickListener{
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SearchFragment())
                    .addToBackStack(null)
                    .commit()
            binding.textInputEditText.setText(null)
            binding.tabLayout.visibility=GONE
            binding.outlinedTextField.endIconMode= TextInputLayout.END_ICON_CLEAR_TEXT
            binding.outlinedTextField.setEndIconDrawable(R.drawable.ic_baseline_clear_24)
            binding.outlinedTextField.setStartIconDrawable(R.drawable.ic_baseline_keyboard_backspace_24)
            binding.outlinedTextField.setStartIconOnClickListener {
                supportFragmentManager.popBackStack()
                binding.outlinedTextField.setEndIconDrawable(null)
                binding.outlinedTextField.setStartIconDrawable(R.drawable.ic_baseline_search_24)
                binding.tabLayout.visibility = VISIBLE
                binding.outlinedTextField.endIconMode= TextInputLayout.END_ICON_NONE
                binding.textInputEditText.setText(R.string.find_company_or_ticker)
            }
        }


        if (savedInstanceState == null) {
            fragmentTransaction
                .add(R.id.container, StocksFragment())
                .commit()
        }
    }

    fun chooseFragment(tabPos:Int?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when(tabPos){
            0->fragmentTransaction
                    .replace(R.id.container, StocksFragment())
                    .commit()

            1->fragmentTransaction
                    .replace(R.id.container, FavoriteFragment())
                    .commit()
        }
    }

}

