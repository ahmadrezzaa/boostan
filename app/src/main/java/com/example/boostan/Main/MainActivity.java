package com.example.boostan.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.boostan.Cactus.CactusActivity;
import com.example.boostan.Favorit.FavoritActivity;
import com.example.boostan.Flower.FlowerActivity;
import com.example.boostan.Plants.PlantsActivity;
import com.example.boostan.R;
import com.example.boostan.Search.SearchActivity;
import com.example.boostan.Trees.TreesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends AppCompatActivity {
    CardView crvCactus, crvFlower, crvPlants, crvTrees;
    BottomNavigationView bottomNavigationView;
    MainViewModel viewModel = new MainViewModel();
    CompositeDisposable disposable = new CompositeDisposable();
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setOnClickView();

    }


    private void setOnClickView() {
        bottomNavigationView.setSelectedItemId(R.id.fav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fav_menu:
                        Intent intentFav = new Intent(MainActivity.this, FavoritActivity.class);
                        startActivity(intentFav);
                        break;
                    case R.id.search_menu:
                        Intent intentSearch = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intentSearch);
                        break;
                }
                return true;
            }

        });


        crvCactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CactusActivity.class);
                startActivity(intent);
            }
        });
        crvPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlantsActivity.class);
                startActivity(intent);
            }
        });
        crvFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlowerActivity.class);
                startActivity(intent);
            }
        });
        crvTrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TreesActivity.class);
                startActivity(intent);
            }
        });

    }


    private void setupViews() {
        crvCactus = findViewById(R.id.crv_homeFrg_cactus);
        crvFlower = findViewById(R.id.crv_homeFrg_flower);
        crvPlants = findViewById(R.id.crv_homeFrg_plants);
        crvTrees = findViewById(R.id.crv_homeFrg_trees);
        bottomNavigationView = findViewById(R.id.nav_main_btnNav);

    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "برای خروج از برنامه بروی دکمه خروج دوباره کنید!", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}