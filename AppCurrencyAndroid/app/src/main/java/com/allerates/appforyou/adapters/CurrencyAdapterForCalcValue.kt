package com.allerates.appforyou.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.model.ArticleForValue
import com.squareup.picasso.Picasso


class CurrencyAdapterForCalcValue(val moviesList: List<ArticleForValue>):
        RecyclerView.Adapter<CurrencyAdapterForCalcValue.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var year: TextView = view.findViewById(R.id.year)
        var genre: TextView = view.findViewById(R.id.genre)
        var from: TextView = view.findViewById(R.id.from_txt)
        var to: TextView = view.findViewById(R.id.to_txt)
        var courseValue: TextView = view.findViewById(R.id.course_value)
        var currencyImg: ImageView = view.findViewById(R.id.currency_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.info_list_value, parent, false)
            return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val context: Context
        val s: String

        val article = moviesList[position]
        // holder.title.setText(article.getTitle());
        // holder.genre.setText(article.getGenre());
        // holder.year.setText(article.getYear());
        holder.from.text = String.format("1 %s ", article.to)
        holder.to.text = String.format("%s ", article.from)
        holder.courseValue.text = String.format("%s ", article.courseValue)
        context = article.context
        //s = article.getImage();
        Picasso.with(article.context).load(article.image)
                .into(holder.currencyImg)
    }

    override fun getItemCount() = moviesList.size
}