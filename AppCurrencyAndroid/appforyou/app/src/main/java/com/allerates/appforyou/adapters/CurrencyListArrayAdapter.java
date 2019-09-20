package com.allerates.appforyou.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.DialogActivity;

import java.util.List;

/**
 * Created by rikmen00@gmail.com on 13.09.2018.
 */

public class CurrencyListArrayAdapter extends ArrayAdapter<DialogActivity.Currency> {

    private final List<DialogActivity.Currency> list;
    private final Activity context;

    static class ViewHolder {
        protected TextView name;
        protected ImageView flag;
        protected LinearLayout linearLayout;
    }

    public CurrencyListArrayAdapter(Activity context, List<DialogActivity.Currency> list) {
        super(context, R.layout.activity_countrycode_row, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.activity_countrycode_row, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.flag = (ImageView) view.findViewById(R.id.flag);
            viewHolder.linearLayout = (LinearLayout) view.findViewById(R.id.lin_di);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(list.get(position).getName());
        holder.flag.setImageDrawable(list.get(position).getFlag());
       // holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
        return view;
    }
}
