package com.example.recyclerviewproject

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        val users = mutableListOf<User>(
            User("Ahmed Mohamed","Ahmed@gmail.com"),
            User("Mahmoud Mohamed","Mahmoud@gmail.com"),
            User("Mona Ahmed","Mona@gmail.com"),
            User("Menna Ali","Menna@gmail.com"),
            User("Youssef Mohamed","Youssef@gmail.com"),
            User("Ahmed Mohamed","Ahmed@gmail.com"),
            User("Mahmoud Ahmed","Mahmoud@gmail.com"),
            User("Yasmine Ahmed","Mona@gmail.com"),
            User("Mohamed Ali","Menna@gmail.com"),
            User("Farida Mohamed","Youssef@gmail.com")
        )

        val userAdapter=UserAdapter(users)
        //binding.rvUsers.layoutManager=LinearLayoutManager(this)
        binding.rvUsers.adapter=userAdapter


        binding.toolbar.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.profile -> {
                    Toast.makeText(this,R.string.profile_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this,R.string.settings_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.change_lang -> {
                    updateLocale(this,"ar")
                    true
                }
                R.id.search -> {
                    Toast.makeText(this,R.string.search_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(this,R.string.home_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(this,R.string.home_clicked,Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
        }}

        binding.floatingActionButton.setOnClickListener {
            Snackbar.make(binding.coordinatorLayout, R.string.user_added, Snackbar.LENGTH_LONG)
                .setAction(R.string.dimiss) {
                    // Responds to click on the action
                }
                .show()
        }

    }

    fun updateLocale(context: Context, languageCode: String) {

        // locale  ar  direction

        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            context.createConfigurationContext(config)
        } else {
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
        // Update layout direction
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        //restart activity

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

