package com.allerates.appforyou.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.request.AllPointComment


class ListCommentAdapter(val commentList: List<AllPointComment>):
        RecyclerView.Adapter<ListCommentAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.tv_name)
        var textComment: TextView = view.findViewById(R.id.text_comment)
        var ratingPoint: RatingBar = view.findViewById(R.id.rating_point)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.show_list_commend_activity, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = commentList[position].exName
        holder.textComment.text = commentList[position].textComment
        val f = java.lang.Float.parseFloat(commentList[position].rating)
        holder.ratingPoint.rating = f
    }

    override fun getItemCount() = commentList.size
}