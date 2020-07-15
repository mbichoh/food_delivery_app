package com.nathanmbichoh.food_delivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathanmbichoh.food_delivery_app.R;

public class RestaurantCafesFoodAdapter extends RecyclerView.Adapter<RestaurantCafesFoodAdapter.RestaurantCafeFoodsViewHolder> {

    private int[] foodImage;
    private String[] foodName;
    private String[] foodDescription;
    private String[] foodAmount;

    public static class RestaurantCafeFoodsViewHolder extends RecyclerView.ViewHolder{
        private TextView txtFoodTitle;
        private TextView txtFoodDescription;
        private TextView txtFoodPrice;
        private ImageView imgFood;

        public RestaurantCafeFoodsViewHolder(View view){
            super(view);
            txtFoodTitle = view.findViewById(R.id.txtFoodTitle);
            txtFoodDescription = view.findViewById(R.id.txtFoodDescription);
            txtFoodPrice = view.findViewById(R.id.txtFoodPrice);
            imgFood = view.findViewById(R.id.imgFood);
        }
    }

    public RestaurantCafesFoodAdapter(int[] foodImage1, String[] foodName1, String[] foodDescription1, String[] foodAmount1){
        this.foodImage = foodImage1;
        this.foodName = foodName1;
        this.foodDescription = foodDescription1;
        this.foodAmount = foodAmount1;
    }

    @NonNull
    @Override
    public RestaurantCafeFoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_restaurant_foods, parent, false);

        return new RestaurantCafeFoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantCafeFoodsViewHolder holder, int position) {
        holder.imgFood.setImageResource(foodImage[position]);
        holder.txtFoodTitle.setText(foodName[position]);
        holder.txtFoodDescription.setText(foodDescription[position]);
        holder.txtFoodPrice.setText(foodAmount[position]);
    }

    @Override
    public int getItemCount() {
        return foodName.length;
    }
}
