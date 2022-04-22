package com.example.lab2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;
    public ThumbnailAdapter(Activity context, int layoutID, ArrayList<Thumbnail> objects){
        super(context, layoutID, objects);
        this.context = context;
    }

    public View getCustomView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.popup_spinner, null, false);
        }

        Thumbnail thumbnail = getItem(position);
        TextView spinnerString = (TextView) convertView.findViewById(R.id.item_spinner_string);
        ImageView spinnerImage = (ImageView) convertView.findViewById(R.id.item_spinner_image);
        LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_spinner_view);

        spinnerString.setText(thumbnail.getName());
        spinnerImage.setImageResource(thumbnail.getImg());


        return convertView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_view, null, false);
        }

        Thumbnail thumbnail = getItem(position);
        TextView spinnerString = (TextView) convertView.findViewById(R.id.item_spinner_selected);


        spinnerString.setText(thumbnail.getName());


        return convertView;
    }

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.popup_spinner, null, false);
        }

        Thumbnail thumbnail = getItem(position);
        TextView spinnerString = (TextView) convertView.findViewById(R.id.item_spinner_string);
        ImageView spinnerImage = (ImageView) convertView.findViewById(R.id.item_spinner_image);
        LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_spinner_view);

        spinnerString.setText(thumbnail.getName());
        spinnerImage.setImageResource(thumbnail.getImg());


        return convertView;
    }
}
