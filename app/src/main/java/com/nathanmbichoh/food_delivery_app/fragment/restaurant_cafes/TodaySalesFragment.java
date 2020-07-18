package com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.nathanmbichoh.food_delivery_app.R;
import com.nathanmbichoh.food_delivery_app.adapters.RestaurantCafesFoodAdapter;
import com.nathanmbichoh.food_delivery_app.fragment.CustomDialogFragment;
import com.nathanmbichoh.food_delivery_app.fragment.RestaurantCafeFoodDescriptionDialog;

import java.util.Objects;

public class TodaySalesFragment extends Fragment {

    private int[] foodImage = {R.mipmap.kfc,  R.mipmap.tav,  R.mipmap.gallitos, R.mipmap.sizzley, R.mipmap.blend, R.mipmap.chief, R.mipmap.pizza};
    private String[] foodName = {"Beef and Broccoli", "Cheesy Beens Pie", "Easy Meatballs", "Fried Rice with Pork", "Fish and Spinach Bake", "Skillet Lasagna", "Veggie Skillet Eggs"};
    private String[] foodDescription ={"Ground Beef, Soy Sauce, Broccoli, Cornstarch", "Kidney Beans, Corn, Diced Tomatoes with Juice, Beef", "Rice, Milk, Egg, Pepper, Carrot", "Low-sodium Soy Sauce, Pork, Vegetables, Cooked Rice", "Frozen Spinach,  Fish Fillets, Tomato, Green Onions", "Ground Beef, Spaghetti, Wide Noodles, Cottage Cheese", "Eggs, Pepper, Cheese, Oil, Mixed vegetables, Tomato"};
    private String[] foodAmount = {"Ksh 350.00", "Ksh 250.00", "Ksh 300.00", "Ksh 250.00", "Ksh 400.00", "Ksh 560.00", "Ksh 230.00"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.list_todaysales, container, false);

        RecyclerView recyclerViewListCafeFoods = view.findViewById(R.id.recyclerViewListResCafeFoods);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewListCafeFoods.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RestaurantCafesFoodAdapter(foodImage, foodName, foodDescription, foodAmount);
        recyclerViewListCafeFoods.setAdapter(adapter);

        //btn food ID
        Button btnFoodDesc = view.findViewById(R.id.btnBuyFood123);
        //show food dialog
        btnFoodDesc.setOnClickListener(v -> foodOrderDescDialog());

        return  view;
    }

    public void foodOrderDescDialog(){
        DialogFragment restaurantCafeFoodDescriptionDialog = new RestaurantCafeFoodDescriptionDialog();
        assert getFragmentManager() != null;
        restaurantCafeFoodDescriptionDialog.show(getFragmentManager(), "foodDescriptionOrderingDialog");
    }
}
