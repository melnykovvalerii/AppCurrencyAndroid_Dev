package com.allerates.appforyou.adapters

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.TAG
import com.allerates.appforyou.model.User


class UsersRecyclerAdapter(val listUsers: List<User>):
        RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_recycler, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        try {
            holder.textViewName.text = listUsers[position].name
            holder.textViewEmail.text = listUsers[position].email
            holder.textViewPassword.text = listUsers[position].password
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return try {
            Log.v(TAG, "" + listUsers.size)
            listUsers.size
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewName: AppCompatTextView
        var textViewEmail: AppCompatTextView
        var textViewPassword: AppCompatTextView

        init {
            textViewName = view.findViewById(R.id.textViewName)
            textViewEmail = view.findViewById(R.id.textViewEmail)
            textViewPassword = view.findViewById(R.id.textViewPassword)
        }
    }
}
