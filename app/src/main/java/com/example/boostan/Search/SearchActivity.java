package com.example.boostan.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.boostan.Cactus.AdapterRecyclerList;
import com.example.boostan.Detail.DetailActivity;
import com.example.boostan.Favorit.FavoritActivity;
import com.example.boostan.Main.MainActivity;
import com.example.boostan.Model.Products;
import com.example.boostan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
EditText edtSearch;
RecyclerView rvSearchList;
BottomNavigationView navigationView;
SearchViewModel viewModel=new SearchViewModel();
CompositeDisposable disposable=new CompositeDisposable();
    AdapterSearch adapterSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setupViews();
        clickOnView();

    }

    private void clickOnView() {
        navigationView.setSelected(true);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@androidx.annotation.NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu:
                        Intent intentHome=new Intent(SearchActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.fav_menu:
                        Intent intentFav=new Intent(SearchActivity.this, FavoritActivity.class);
                        startActivity(intentFav);
                        break;
                }
                return true;
            }
        });
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtSearch.setFocusableInTouchMode(true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edtSearch.getText().toString().equals("")){
                    viewModel.getSearch(String.valueOf(s)).subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<List<Products>>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {
                                    disposable.add(d);
                                }

                                @Override
                                public void onSuccess(@NonNull List<Products> products) {
                                    adapterSearch.onBind(products);
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {
                                    Log.e("error",e.toString());
                                }
                            });
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupViews() {
        navigationView=findViewById(R.id.nav_search_btnNav);
        edtSearch=findViewById(R.id.edt_search_search);
        rvSearchList=findViewById(R.id.rv_search_list);
        rvSearchList.setLayoutManager(new LinearLayoutManager(this));
       adapterSearch=new AdapterSearch(SearchActivity.this, new AdapterSearch.SearchOnClickView() {
            @Override
            public void onClickView(String id) {
            Intent intent=new Intent(SearchActivity.this, DetailActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
            }
        });
        rvSearchList.setAdapter(adapterSearch);
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}