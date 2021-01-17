package com.example.boostan.Cactus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.boostan.Detail.DetailActivity;
import com.example.boostan.Favorit.FavoritActivity;
import com.example.boostan.Main.MainActivity;
import com.example.boostan.Main.MainViewModel;
import com.example.boostan.Model.Products;
import com.example.boostan.R;
import com.example.boostan.Search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CactusActivity extends AppCompatActivity {
    RecyclerView rvList;
    BottomNavigationView bottomNavigationView;
    MainViewModel viewModel = new MainViewModel();
    CompositeDisposable disposable = new CompositeDisposable();
    AdapterRecyclerList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cactus);
        setupViews();
        setOnClickView();
        observProducts();
    }

    private void setOnClickView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Intent intentMain = new Intent(CactusActivity.this, MainActivity.class);
                        startActivity(intentMain);
                        break;
                    case R.id.fav_menu:
                        Intent intentFav = new Intent(CactusActivity.this, FavoritActivity.class);
                        startActivity(intentFav);
                        break;
                    case R.id.search_menu:
                        Intent intentSearch = new Intent(CactusActivity.this, SearchActivity.class);
                        startActivity(intentSearch);
                        break;
                }
                return true;
            }
        });
    }

    private void setupViews() {
        rvList = findViewById(R.id.rv_cactus_list);
        rvList.setLayoutManager(new LinearLayoutManager(CactusActivity.this));
        bottomNavigationView = findViewById(R.id.nav_cactus_btnNav);


    }

    private void observProducts() {

        viewModel.getProducts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Products>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull List<Products> products) {

                        for (int i = 0; i < products.size(); i++) {
                            if (products.get(i).getCatId().equals("1")) {
                                rvList.setAdapter(adapter);
                                adapter = new AdapterRecyclerList(CactusActivity.this, products, new AdapterRecyclerList.SetOnClickView() {
                                    @Override
                                    public void onClickView(String id) {
                                        Intent intent = new Intent(CactusActivity.this, DetailActivity.class);
                                        intent.putExtra("id", id);
                                        startActivity(intent);
                                    }
                                });
                                adapter.notifyDataSetChanged();
                            }

                        }
                    }
                            
                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.e("error", e.toString());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}