package com.nathanmbichoh.food_delivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathanmbichoh.food_delivery_app.R;

public class MyRestaurantFavsAdapter extends RecyclerView.Adapter<MyRestaurantFavsAdapter.MyRestaurantFavViewHolder> {

    private String restaurantName[];
    private String restaurantFav[];
    private int restaurantImg[];
    private Float restaurantStar[];

    public int countRes;

    public static class MyRestaurantFavViewHolder extends RecyclerView.ViewHolder{
        private TextView txtRestaurantName, txtFavouriteRes;
        private ImageView imageRestaurant;
        private RatingBar aFloatRestaurant;

        public MyRestaurantFavViewHolder (View view){
            super(view);

            txtRestaurantName   = (TextView) view.findViewById(R.id.textRestaurantName);
            txtFavouriteRes     = (TextView) view.findViewById(R.id.txtNumFavourite);
            imageRestaurant     = (ImageView) view.findViewById(R.id.imgRes);
            aFloatRestaurant    = (RatingBar) view.findViewById(R.id.rateRestaurant);
        }
    }

    public MyRestaurantFavsAdapter(String rName[], String rFav[], int rImg[], Float rStar[]){
            restaurantName  = rName;
            restaurantFav   = rFav;
            restaurantImg   = rImg;
            restaurantStar  = rStar;
    }

    @NonNull
    @Override
    public MyRestaurantFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_restaurants, parent, false);

        MyRestaurantFavViewHolder myRestaurantFavViewHolder = new MyRestaurantFavViewHolder(view);
        return myRestaurantFavViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRestaurantFavViewHolder holder, int position) {
        holder.imageRestaurant.setImageResource(restaurantImg[position]);
        holder.txtRestaurantName.setText(restaurantName[position]);
        holder.txtFavouriteRes.setText(restaurantFav[position]);
        holder.aFloatRestaurant.setRating(restaurantStar[position]);
    }

    @Override
    public int getItemCount() {
        countRes = restaurantName.length;
        return countRes;
    }
}
