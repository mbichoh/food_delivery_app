package com.nathanmbichoh.food_delivery_app.restaurantcafes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.nathanmbichoh.food_delivery_app.ProfileActivity;
import com.nathanmbichoh.food_delivery_app.R;
import com.nathanmbichoh.food_delivery_app.RestaurantsActivity;

public class RestaurantCafeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private ViewPager viewPagerCats;
    private TabLayout tabLayoutCats;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cafe);

        viewPagerCats = (ViewPager) findViewById(R.id.viewPagerCafesCategories);
        tabLayoutCats = (TabLayout) findViewById(R.id.tabCafeCategories);

        //bottom navigation view
        bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                startActivity(new Intent(RestaurantCafeActivity.this, ProfileActivity.class));
                return true;
        }
        return false;
    }
}
