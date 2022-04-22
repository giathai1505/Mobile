package com.example.lab2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    public DishAdapter(Activity context, int layoutID, ArrayList<Dish> objects){
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, null, false);
        }

        Dish dish = getItem(position);

        ImageView background = (ImageView) convertView.findViewById(R.id.grid_item_image);
        TextView text = (TextView) convertView.findViewById(R.id.grid_item_text);
        ImageView promotion = (ImageView) convertView.findViewById(R.id.grid_promotion);

        background.setImageResource(dish.thumbnail.getImg());
        text.setText(dish.getDishName());
        text.setSelected(true);

        if (dish.isPromotion){
            promotion.setVisibility(View.VISIBLE);
        }
        else{
            promotion.setVisibility(View.GONE);
        }


        return convertView;
    }
}
