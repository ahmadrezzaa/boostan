package com.example.boostan.Favorit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.boostan.Main.MainActivity;
import com.example.boostan.R;
import com.example.boostan.Search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoritActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);
        setupViews();
        setOnClickView();
    }

    private void setOnClickView() {
        bottomNavigationView.setSelectedItemId(R.id.fav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu:
                        Intent intentHome=new Intent(FavoritActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.search_menu:
                        Intent intentSearch=new Intent(FavoritActivity.this, SearchActivity.class);
                        startActivity(intentSearch);
                        break;
                }
                return true;
            }
        });

    }

    private void setupViews() {
        bottomNavigationView=findViewById(R.id.nav_fav_btnNav);
    }
}