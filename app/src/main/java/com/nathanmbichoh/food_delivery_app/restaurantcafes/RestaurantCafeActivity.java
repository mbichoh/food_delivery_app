package com.nathanmbichoh.food_delivery_app.restaurantcafes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.nathanmbichoh.food_delivery_app.R;

public class RestaurantCafeActivity extends AppCompatActivity {

    private ViewPager viewPagerCats;
    private TabLayout tabLayoutCats;

//    private FoodAFragment foodAFragment;
//    private FoodBFragment foodBFragment;
//    private FoodCFragment foodCFragment;
//    private FoodDFragment foodDFragment;
//    private FoodEFragment foodEFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cafe);

        viewPagerCats = (ViewPager) findViewById(R.id.viewPagerCafesCategories);
        tabLayoutCats = (TabLayout) findViewById(R.id.tabCafeCategories);

    }
}
