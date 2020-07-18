package com.nathanmbichoh.food_delivery_app.restaurantcafes;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.nathanmbichoh.food_delivery_app.R;
import com.nathanmbichoh.food_delivery_app.adapters.ViewPagerAdapter;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.BreakfastFragment;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.DinnerFragment;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.LunchFragment;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.PopularFragment;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.TodaySalesFragment;
import com.nathanmbichoh.food_delivery_app.fragment.restaurant_cafes.VegetarianFragment;

public class RestaurantCafeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cafe);

        ViewPager viewPagerCats = (ViewPager) findViewById(R.id.viewPagerCafesCategories);
        TabLayout tabLayoutCats = (TabLayout) findViewById(R.id.tabCafeCategories);

        //fragments
        TodaySalesFragment todaySalesFragment = new TodaySalesFragment();
        PopularFragment popularFragment = new PopularFragment();
        BreakfastFragment breakfastFragment = new BreakfastFragment();
        LunchFragment lunchFragment = new LunchFragment();
        DinnerFragment dinnerFragment = new DinnerFragment();
        VegetarianFragment vegetarianFragment = new VegetarianFragment();

        //add tabs to viewpager
        tabLayoutCats.setupWithViewPager(viewPagerCats);

        //register fragments to viewpagerAdapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(todaySalesFragment, "Today Sales");
        viewPagerAdapter.addFragment(popularFragment, "Popular");
        viewPagerAdapter.addFragment(breakfastFragment, "Breakfast");
        viewPagerAdapter.addFragment(lunchFragment, "Lunch");
        viewPagerAdapter.addFragment(dinnerFragment, "Dinner");
        viewPagerAdapter.addFragment(vegetarianFragment, "Vegetarian");
        //add viewPageAdapter to viewPage
        viewPagerCats.setAdapter(viewPagerAdapter);

        //bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.homeMenuBottomNav);

        //badge icon cart
        BadgeDrawable badgeDrawableCart = bottomNavigationView.getOrCreateBadge(R.id.cartMenuBottomNav);
        badgeDrawableCart.setVisible(true);
        badgeDrawableCart.setNumber(5);
        //badge icon notifications
        BadgeDrawable badgeDrawableNotifications = bottomNavigationView.getOrCreateBadge(R.id.notificationMenuBottomNav);
        badgeDrawableNotifications.setVisible(true);
        badgeDrawableNotifications.setNumber(3);
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
            case R.id.notificationMenuBottomNav:
                Toast.makeText(getApplicationContext(), "TO NOTIFICATIONS", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
