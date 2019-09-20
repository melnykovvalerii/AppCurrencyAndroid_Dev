package com.allerates.appforyou.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.allerates.appforyou.R;
import com.allerates.appforyou.model.ArticleForValue;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rikmen on 13.06.2018.
 */

public class CurrencyAdapterForCalcValue extends RecyclerView.Adapter<CurrencyAdapterForCalcValue.MyViewHolder> {

    private List<ArticleForValue> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre, from, to, courseValue;
        public ImageView currencyImg;

        public MyViewHolder(View view) {
            super(view);
            try {
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            from = (TextView) view.findViewById(R.id.from_txt);
            to = (TextView) view.findViewById(R.id.to_txt);
            courseValue = (TextView) view.findViewById(R.id.course_value);
            currencyImg = (ImageView) view.findViewById(R.id.currency_img);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public CurrencyAdapterForCalcValue(List<ArticleForValue> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public CurrencyAdapterForCalcValue.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_list_value, parent, false);

        return new CurrencyAdapterForCalcValue.MyViewHolder(itemView);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onBindViewHolder(CurrencyAdapterForCalcValue.MyViewHolder holder, int position) {
        try {
        Context context;
        String s;

        ArticleForValue article = moviesList.get(position);
       // holder.title.setText(article.getTitle());
       // holder.genre.setText(article.getGenre());
       // holder.year.setText(article.getYear());
        holder.from.setText(String.format("1 %s ", article.getTo()));
        holder.to.setText(String.format("%s ", article.getFrom()));
        holder.courseValue.setText(String.format("%s ", article.getCourseValue()));
        context = article.getContext();
        //s = article.getImage();
        Picasso.with(article.getContext()).load(article.getImage())
                .into(holder.currencyImg);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}