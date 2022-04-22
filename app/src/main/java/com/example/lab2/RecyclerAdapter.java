package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView managerImage;
        private TextView staffText;
        private TextView textName;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            managerImage = itemView.findViewById(R.id.item_employee_iv_manager);
            textName = itemView.findViewById(R.id.item_employee_tv_fullname);
            staffText = itemView.findViewById(R.id.item_employee_tv_position);
            linearLayout = itemView.findViewById(R.id.item_employee_bai6);
        }
    }
    private Context context;
    private ArrayList<Employee> listEmployee;
    public RecyclerAdapter(Context context, ArrayList<Employee> listEmployee){
        this.context = context;
        this.listEmployee = listEmployee;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View employeeView = inflater.inflate(R.layout.item_employee_bai6, parent, false);
        ViewHolder viewHolder = new ViewHolder(employeeView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position){
        Employee employee = listEmployee.get(position);
        holder.textName.setText(employee.getFullName());
        if (employee.isManager){
            holder.managerImage.setVisibility(View.VISIBLE);
            holder.staffText.setVisibility(View.GONE);
        }
        else {
            holder.managerImage.setVisibility(View.GONE);
            holder.staffText.setVisibility(View.VISIBLE);
            holder.staffText.setText(context.getString(R.string.staff));
        }

        if (position % 2 == 0){
            holder.linearLayout.setBackgroundResource(R.color.white);
        }
        else{
            holder.linearLayout.setBackgroundResource(R.color.light_blue);
        }

    }
    @Override
    public int getItemCount() {
        return listEmployee.size();
    }

}
