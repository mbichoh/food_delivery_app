package com.nathanmbichoh.food_delivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathanmbichoh.food_delivery_app.R;

public class MyRestaurantCafesAdapter extends RecyclerView.Adapter<MyRestaurantCafesAdapter.MyRestaurantCafesViewHolder> {

    private int     cafeImg[];
    private String  txtCafeName[];
    private String  txtCafeLocation[];
    private String  txtCafeDeliveryTime[];
    private String  txtCafeDeliveryCharge[];
    private String  txtCafeRating[];
    private String  txtCafeLikes[];

    public static class MyRestaurantCafesViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCafes;
        private TextView txtVCafeName, txtVCafeLocation, txtVCafeDeliveryTime, txtVCafeDeliveryCharge, txtVCafeRating, txtVCafeLikes;

        public MyRestaurantCafesViewHolder(View view){
            super(view);
            imgCafes                = (ImageView) view.findViewById(R.id.imgResCafe);
            txtVCafeName            = (TextView) view.findViewById(R.id.txtResCafeName);
            txtVCafeLikes           = (TextView) view.findViewById(R.id.txtResCafeLikes);
            txtVCafeRating          = (TextView) view.findViewById(R.id.txtResCafeRating);
            txtVCafeLocation        = (TextView) view.findViewById(R.id.txtResCafeLocation);
            txtVCafeDeliveryTime    = (TextView) view.findViewById(R.id.txtResCafeDeliveryTime);
            txtVCafeDeliveryCharge  = (TextView) view.findViewById(R.id.txtResCafeDeliveryFee);

        }
    }

    public  MyRestaurantCafesAdapter(int cafesImg[], String cafeName[], String cafeLocation[], String cafeDeliveryTime[], String cafeDeliveryCharge[], String cafeRating[], String cafeLikes[]){
        cafeImg                = cafesImg;
        txtCafeName             = cafeName;
        txtCafeLocation         = cafeLocation;
        txtCafeDeliveryTime     = cafeDeliveryTime;
        txtCafeDeliveryCharge   = cafeDeliveryCharge;
        txtCafeRating           = cafeRating;
        txtCafeLikes            = cafeLikes;
    }

    @NonNull
    @Override
    public MyRestaurantCafesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_cafes, parent, false);

        MyRestaurantCafesViewHolder myRestaurantCafesViewHolder = new MyRestaurantCafesViewHolder(view);
        return myRestaurantCafesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRestaurantCafesViewHolder holder, int position) {
        holder.imgCafes.setImageResource(cafeImg[position]);
        holder.txtVCafeName.setText(txtCafeName[position]);
        holder.txtVCafeLocation.setText(txtCafeLocation[position]);
        holder.txtVCafeDeliveryTime.setText(txtCafeDeliveryTime[position]);
        holder.txtVCafeDeliveryCharge.setText(txtCafeDeliveryCharge[position]);
        holder.txtVCafeRating.setText(txtCafeRating[position]);
        holder.txtVCafeLikes.setText(txtCafeLikes[position]);
    }

    @Override
    public int getItemCount() {
        return txtCafeName.length;
    }
}
