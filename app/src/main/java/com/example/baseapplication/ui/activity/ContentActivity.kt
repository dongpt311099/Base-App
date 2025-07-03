package com.example.baseapplication.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityContentBinding
import com.example.baseapplication.ui.fragment.HomeFragment
import com.example.baseapplication.ui.fragment.SettingsFragment
import com.example.baseapplication.ui.fragment.ToolsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentActivity : BaseActivity() {

    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.getRoot())
        supportFragmentManager.beginTransaction().replace(binding.container.id, HomeFragment()).commit()

        binding.bottomNavigation.setOnItemSelectedListener {item->
            when(item.itemId){
                R.id.Home->{
                    binding.title.text = getString(R.string.finance)
                    supportFragmentManager.beginTransaction().replace(binding.container.id,
                        HomeFragment()).commit()
                    true
                }
                R.id.Tools->{
                    binding.title.text = getString(R.string.tools)
                    supportFragmentManager.beginTransaction().replace(binding.container.id,
                        ToolsFragment()).commit()
                    true
                }
                R.id.History->{
                    binding.title.text = getString(R.string.history)
                    supportFragmentManager.beginTransaction().replace(binding.container.id,
                        SettingsFragment()).commit()
                    true
                }
                R.id.Settings->{
                    binding.title.text = getString(R.string.settings)
                    supportFragmentManager.beginTransaction().replace(binding.container.id,
                        SettingsFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}