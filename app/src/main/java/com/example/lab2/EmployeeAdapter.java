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
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Activity context;
    public EmployeeAdapter(Activity context, int layoutID, ArrayList<Employee> objects){
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_employee, null, false);
        }
//        Get Item
        Employee employee = getItem(position);

//        Get View
        TextView tvFullName = (TextView) convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = (TextView) convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = (ImageView) convertView.findViewById(R.id.item_employee_iv_manager);
        LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_employee_ll_parent);

//        Get FullName
        if (employee.getFullName() != null){
            tvFullName.setText(employee.getFullName());
        }
        else{
            tvFullName.setText("");
        }
        if (employee.isManager){
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
        }
        else {
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText(context.getString(R.string.staff));
        }
        if (position % 2 == 0){
            llParent.setBackgroundResource(R.color.white);
        }else{
            llParent.setBackgroundResource(R.color.light_blue);
        }


        return convertView;

    }
}
