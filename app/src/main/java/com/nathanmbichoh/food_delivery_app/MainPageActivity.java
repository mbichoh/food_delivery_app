package com.nathanmbichoh.food_delivery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.TextView;

import com.nathanmbichoh.food_delivery_app.adapters.MyRestaurantCategoriesAdapter;
import com.nathanmbichoh.food_delivery_app.adapters.MyRestaurantFavsAdapter;

public class MainPageActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TextView txtTotalRestaurants, txtTotalCats;
    private SearchView txtSearchRestaurant;

    private RecyclerView recyclerViewListRes, recyclerViewListCat;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //favourite restaurants
    String mResNames[] = {"The Tav, Westlands", "Blend, Thika", "Milan, Westlands", "Chiefs Place, Parklands", "Pizza Inn, Thika", "KFC, Two Rivers", "Sizzly, Mirage"};
    String mFavPoints[] = {"256", "209", "199", "157", "135", "96", "82"};
    Float mResRate[] = {5f, 5f, 4.0f, 4.0f, 4.0f, 3.0f, 2.0f};
    int imagesRes[] = {R.mipmap.tav, R.mipmap.blend, R.mipmap.gallitos, R.mipmap.chief, R.mipmap.pizza, R.mipmap.kfc, R.mipmap.sizzley};

    //food categories
    String mCatNames[] = {"Cafe", "Fast Foods", "Coffee", "Desserts", "Pizza Inn", "Cake", "Chicken Inn", "Drinks", "Chinese"};
    String mCatCount[] = {"510", "457", "300", "276", "244", "203", "167", "149", "123"};
    int mCatIcon[] = {R.drawable.ic_cafe, R.drawable.ic_french_fries, R.drawable.ic_coffee, R.drawable.ic_desserts, R.drawable.ic_pizza_slice, R.drawable.ic_027_cupcake, R.drawable.ic_chicken, R.drawable.ic_drink, R.drawable.ic_noodles};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        txtTotalRestaurants = (TextView) findViewById(R.id.txtTotalNumRestaurant);
        txtTotalCats = (TextView) findViewById(R.id.txtTotalCategories);

        txtSearchRestaurant = (SearchView) findViewById(R.id.txtSearchRestaurant);

        recyclerViewListRes = (RecyclerView) findViewById(R.id.recyclerViewListRes);
        recyclerViewListCat = (RecyclerView) findViewById(R.id.recyclerViewListCat);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);

        //restaurant favourites adapter class
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListRes.setLayoutManager(layoutManager);
        mAdapter = new MyRestaurantFavsAdapter(mResNames, mFavPoints, imagesRes, mResRate);
        recyclerViewListRes.setAdapter(mAdapter);

        //total favourite restaurant count
        String favRestaurantsCount = String.valueOf(mAdapter.getItemCount());
        txtTotalRestaurants.setText(". " + favRestaurantsCount + " Restaurants");

        //restaurant categories adapter calling class
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListCat.setLayoutManager(layoutManager);
        mAdapter = new MyRestaurantCategoriesAdapter(mCatNames, mCatCount, mCatIcon);
        recyclerViewListCat.setAdapter(mAdapter);

        //total food categories count
        String foodCategoryCount = String.valueOf(mAdapter.getItemCount());
        txtTotalCats.setText(". " + foodCategoryCount + " Categories");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class));
            case R.id.action_help:
                startActivity(new Intent(this, VerificationActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
