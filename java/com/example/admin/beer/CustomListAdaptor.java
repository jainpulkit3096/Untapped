package com.example.admin.beer;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.beer.R;

public class CustomListAdaptor extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] heading;

    private final String[] about;
    private final Integer[] imgid;

    public CustomListAdaptor(Activity context, String[] heading, String[] about, Integer[] imgid)
    {
        super(context, R.layout.custom_row_list_view,heading);
        this.context = context;
        this.heading = heading;
        this.imgid = imgid;
        this.about = about;
    }

    public View getView(int position, View view,ViewGroup parent )
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_row_list_view, null, true);

        TextView tvContent = (TextView) rowView.findViewById(R.id.listheading);
        TextView tvContent3 = (TextView) rowView.findViewById(R.id.listabout);
        ImageView ivImage = (ImageView) rowView.findViewById(R.id.listimage);

        tvContent.setText(heading[position]);

        tvContent3.setText(about[position]);
        ivImage.setImageResource(imgid[position]);
        return rowView;
    }
}