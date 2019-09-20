package com.allerates.appforyou.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.allerates.appforyou.R;

/**
 * Created by rikmen00@gmail.com on 25.09.2018.
 */


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private TypedArray imgs;
    private String[] partsList;

    public ImageAdapter(Context c, String[] parts) {
        mContext = c;
        partsList = parts;
    }

    public int getCount() {
        return partsList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View grid;

        if (convertView == null) {
            grid = new View(mContext);
            //LayoutInflater inflater = getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid = inflater.inflate(R.layout.cellgrid, parent, false);
        } else {
            grid = (View) convertView;
        }

        ImageView imageView = (ImageView) grid.findViewById(R.id.full_image_view);
        TextView textView = (TextView) grid.findViewById(R.id.textpart);

        getImageFromCur(partsList, imageView, position, textView);


        return grid;
    }

    public void getImageFromCur (String[] parts, ImageView imageView, int position, TextView textCurrency) {
            if(parts[position].equals(mContext.getString(R.string.btc_string))) {
                imageView.setBackgroundResource(R.mipmap.ic_btc);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.etc_string))){
                imageView.setBackgroundResource(R.mipmap.ic_etc);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.xrp_string))){
                imageView.setBackgroundResource(R.mipmap.ic_xrp);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.eth_string))){
                imageView.setBackgroundResource(R.mipmap.ic_eth);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.aur_string))){
                imageView.setBackgroundResource(R.mipmap.ic_aur);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.dash_string))){
                imageView.setBackgroundResource(R.mipmap.ic_dash);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.maid_string))) {
                imageView.setBackgroundResource(R.mipmap.ic_maid);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.ltc_string))){
                imageView.setBackgroundResource(R.mipmap.ic_ltc);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.xmr_string))) {
                imageView.setBackgroundResource(R.mipmap.ic_xmr);
                textCurrency.setText(parts[position]);
            }
            else if (parts[position].equals(mContext.getString(R.string.xem_string))) {
                imageView.setBackgroundResource(R.mipmap.ic_xem);
                textCurrency.setText(parts[position]);
            }
    }
}