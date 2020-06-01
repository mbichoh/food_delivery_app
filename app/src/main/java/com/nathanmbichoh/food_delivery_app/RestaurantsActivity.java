package com.nathanmbichoh.food_delivery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nathanmbichoh.food_delivery_app.adapters.MyRestaurantCafesAdapter;
import com.nathanmbichoh.food_delivery_app.fragment.CustomDialogFragment;

public class RestaurantsActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    private TextView btnFilter;

    private BottomNavigationView bottomNavigationView;

    private RecyclerView recyclerViewListResCafe;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int     imgCafes[] = {R.mipmap.tav, R.mipmap.blend, R.mipmap.gallitos, R.mipmap.chief, R.mipmap.pizza, R.mipmap.kfc, R.mipmap.sizzley};
    private String  txtCafeName[] = {"The Tav", "Blend", "Milan", "Chiefs Place", "Pizza Inn", "KFC", "Sizzly"};
    private String  txtCafeLocation[] ={"Mirage, Westlands", "Thika, Kiambu", "Tuskys Chania, Thika", "LC Waikiki, Parklands", "Moi Avenue, Str 14", "Off Chiromo, Kileleshwa", "Ruiru, Thika Road"};
    private String  txtCafeDeliveryTime[] = {" 1h", " 2h", " 2h", " 1h", " 1.5h", " 1h", " 1.5h"};
    private String  txtCafeDeliveryCharge[] = {"Delivery Ksh200", "Free Delivery", "Delivery Ksh320", "Delivery Ksh100", "Free Delivery", "Delivery Ksh200", "Free Delivery"};
    private String  txtCafeRating[] = {"4,5", "5,5", "4,5", "2,5", "1,5", "2,5", "3,5"};
    private String  txtCafeLikes[] = {"(200)", "(459)", "(15)", "(334)", "(98)", "(134)", "(201)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        btnFilter = (TextView) findViewById(R.id.txtBtnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        recyclerViewListResCafe = (RecyclerView) findViewById(R.id.recyclerViewListResCafes);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewListResCafe.setLayoutManager(layoutManager);
        mAdapter = new MyRestaurantCafesAdapter(imgCafes, txtCafeName, txtCafeLocation, txtCafeDeliveryTime, txtCafeDeliveryCharge, txtCafeRating, txtCafeLikes);
        recyclerViewListResCafe.setAdapter(mAdapter);

        //bottom navigation view
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.homeMenuBottomNav);

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartMenuBottomNav);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(5);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeMenuBottomNav:
                Toast.makeText(getApplicationContext(), "TO HOME", Toast.LENGTH_LONG).show();
                return true;
            case R.id.ordersMenuBottomNav:
                Toast.makeText(getApplicationContext(), "TO ORDERS", Toast.LENGTH_LONG).show();
                return true;
            case R.id.cartMenuBottomNav:
                Toast.makeText(getApplicationContext(), "TO CART", Toast.LENGTH_LONG).show();
                return true;
            case R.id.profileMenuBottomNav:
                startActivity(new Intent(RestaurantsActivity.this, ProfileActivity.class));
                return true;
        }
        return false;
    }

    //showing filter layout as dialog
    public void showDialog(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, customDialogFragment)
                .addToBackStack(null).commit();

    }
}
