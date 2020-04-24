package com.nathanmbichoh.food_delivery_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import android.widget.TextView;

import com.nathanmbichoh.food_delivery_app.adapters.MyRestaurantFavsAdapter;

public class MainPageActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TextView txtTotalRestaurants;
    private SearchView txtSearchRestaurant;

    private RecyclerView recyclerViewListRes;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    String mResNames[]  = {"The Tav, Westlands", "Blend, Thika", "Gallitos, CBD", "Chiefs Place, Parklands", "Pizza Inn, Thika", "KFC, Two Rivers", "Sizzly, Mirage"};
    String mFavPoints[] = {"256", "209", "199", "157", "135", "96", "82" };
    Float mResRate[]    = {5f, 5f, 4.0f, 4.0f, 4.0f, 3.0f, 2.0f};
    int imagesRes[]     = {R.mipmap.tav, R.mipmap.blend, R.mipmap.gallitos, R.mipmap.chief, R.mipmap.pizza, R.mipmap.kfc, R.mipmap.sizzley};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        txtTotalRestaurants = (TextView) findViewById(R.id.txtTotalNumRestaurant);

        txtSearchRestaurant = (SearchView) findViewById(R.id.txtSearchRestaurant);

        recyclerViewListRes = (RecyclerView) findViewById(R.id.recyclerViewListRes);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);

        //adapter class
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListRes.setLayoutManager(layoutManager);
        mAdapter = new MyRestaurantFavsAdapter(mResNames, mFavPoints, imagesRes, mResRate);
        recyclerViewListRes.setAdapter(mAdapter);

        //total favourite restaurant count
        String favRestaurantsCount = String.valueOf(mAdapter.getItemCount());
        txtTotalRestaurants.setText(". "+favRestaurantsCount+" Restaurants");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_page, menu);
        return  true;
    }
}
