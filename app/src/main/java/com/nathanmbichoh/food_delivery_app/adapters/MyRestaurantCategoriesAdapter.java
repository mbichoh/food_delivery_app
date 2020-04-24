package com.nathanmbichoh.food_delivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathanmbichoh.food_delivery_app.R;

public class MyRestaurantCategoriesAdapter extends RecyclerView.Adapter<MyRestaurantCategoriesAdapter.MyRestaurantCatViewHolder> {

    private String[] txtCatName;
    private String[] txtCatCount;
    private int[] txtCatIcon;

    public static class MyRestaurantCatViewHolder extends RecyclerView.ViewHolder{

        private TextView txtCategoryName, txtCategoryCount, txtCategoryIcon;

        public MyRestaurantCatViewHolder(View view){
            super(view);

            txtCategoryName     = (TextView) view.findViewById(R.id.txtCategoryName);
            txtCategoryCount    = (TextView) view.findViewById(R.id.txtCategoryTotalNumCount);
            txtCategoryIcon     = (TextView) view.findViewById(R.id.txtIconCategory);
        }
    }

    public MyRestaurantCategoriesAdapter(String[] catName, String[] catCount, int[] catIcon){
        txtCatName  = catName;
        txtCatCount = catCount;
        txtCatIcon  = catIcon;
    }

    @NonNull
    @Override
    public MyRestaurantCatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_categories, parent, false);
        MyRestaurantCatViewHolder myRestaurantCatViewHolder = new MyRestaurantCatViewHolder(view);

        return myRestaurantCatViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRestaurantCatViewHolder holder, int position) {
        holder.txtCategoryName.setText(txtCatName[position]);
        holder.txtCategoryCount.setText(txtCatCount[position]+" Places");
        holder.txtCategoryIcon.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, txtCatIcon[position], 0);
    }

    @Override
    public int getItemCount() {
        return txtCatName.length;
    }
}
