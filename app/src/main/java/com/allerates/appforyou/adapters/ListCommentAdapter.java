package com.allerates.appforyou.adapters;

/**
 * Created by rikmen00@gmail.com on 19.02.2019.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.allerates.appforyou.R;
import com.allerates.appforyou.request.AllPointComment;

import java.util.List;

public class ListCommentAdapter extends RecyclerView.Adapter<ListCommentAdapter.MyViewHolder> {

    private List<AllPointComment> commentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, textComment;
        public RatingBar ratingPoint;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_name);
            textComment = (TextView) view.findViewById(R.id.text_comment);
            ratingPoint = (RatingBar) view.findViewById(R.id.rating_point);
        }
    }


    public ListCommentAdapter(List <AllPointComment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_list_commend_activity, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(commentList.get(position).getExName());
        holder.textComment.setText(commentList.get(position).getTextComment());
        float f = Float.parseFloat(commentList.get(position).getRating());
        holder.ratingPoint.setRating(f);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}