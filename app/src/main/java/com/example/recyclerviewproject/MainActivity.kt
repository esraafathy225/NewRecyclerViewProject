package com.example.recyclerviewproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding

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


        val userAdapter = UserAdapter(users)
        //binding.rvUsers.layoutManager=LinearLayoutManager(this)
        binding.rvUsers.adapter=userAdapter

        binding.toolbar.materialToolbar.setOnMenuItemClickListener {

            when(it.itemId){
                R.id.profile ->{
                    Toast.makeText(this,R.string.profile_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings ->{
                    Toast.makeText(this,R.string.settings_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search ->{
                    Toast.makeText(this,R.string.search_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.change_lang ->{
                    Toast.makeText(this,R.string.lang_clicked,Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}

