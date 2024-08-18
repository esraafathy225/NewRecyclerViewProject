package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users: List<User>)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    //view holder

    class UserViewHolder(val row : View) : RecyclerView.ViewHolder(row){
        // hold objects of views
        val tvName = row.findViewById<TextView>(R.id.tv_name)
        val tvEmail = row.findViewById<TextView>(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // convert xml file of user to view object
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user,parent,false)
        return UserViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // bind data inside views
        val user = users.get(position)
        holder.tvName.text=user.name
        holder.tvEmail.text=user.email
    }


}