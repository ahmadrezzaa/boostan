package com.example.boostan.Detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boostan.Favorit.FavoritActivity;
import com.example.boostan.Main.MainActivity;
import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;
import com.example.boostan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {
    ImageView imgImage,imgFav;
    TextView txtName, txtIntroduction, txtLight, txtWater, txtSoil,
            txtFertilizer, txtPests, txtToxic,txtReproduction,txtTemperate
            ,txtPrune,txtHumidity,txtFurtherInfo;
    BottomNavigationView bottomNavigationView;
    String id;
    int position;
    DetailViewModel viewModel = new DetailViewModel();
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupViews();
        observDetail();
        setOnClickView();
    }
    // Get Data in Server
    private void observDetail() {
        viewModel.getDetail(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Detail>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull List<Detail> details) {
                        txtName.setText(details.get(0).getName());
                        txtIntroduction.setText(details.get(0).getIntroduction());
                        txtLight.setText(details.get(0).getLight());
                        txtWater.setText(details.get(0).getWater());
                        txtSoil.setText(details.get(0).getSoil());
                        txtFertilizer.setText(details.get(0).getFertilizer());
                        txtPests.setText(details.get(0).getPests());
                        txtToxic.setText(details.get(0).getToxic());
                        txtReproduction.setText(details.get(0).getReproduction());
                        txtTemperate.setText(details.get(0).getTemperate());
                        txtPrune.setText(details.get(0).getPrune());
                        txtHumidity.setText(details.get(0).getHumidity());
                        txtFurtherInfo.setText(details.get(0).getFurther_information());
                        Picasso.get().load(details.get(0).getImage()).into(imgImage);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                                    Log.e("error",e.toString());
                    }
                });
    }

    private void setOnClickView() {
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Intent intentMain = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intentMain);
                        break;
                    case R.id.fav_menu:
                        Intent intentFav = new Intent(DetailActivity.this, FavoritActivity.class);
                        startActivity(intentFav);
                        break;
                }
                return true;
            }
        });
    }

    private void setupViews() {
        // Get Id
        id = getIntent().getExtras().getString("id");
        position=getIntent().getExtras().getInt("position");

        imgImage = findViewById(R.id.img_detail_image);
        imgFav = findViewById(R.id.img_detail_fav);
        txtName = findViewById(R.id.txt_detail_name);
        txtIntroduction = findViewById(R.id.txt_detail_introduction);
        txtLight = findViewById(R.id.txt_detail_light);
        txtWater = findViewById(R.id.txt_detail_water);
        txtSoil = findViewById(R.id.txt_detail_soil);
        txtFertilizer = findViewById(R.id.txt_detail_fertilizer);
        txtPests = findViewById(R.id.txt_detail_pests);
        txtToxic = findViewById(R.id.txt_detail_toxic);
        txtReproduction = findViewById(R.id.txt_detail_reproduction);
        txtTemperate = findViewById(R.id.txt_detail_temperate);
        txtPrune = findViewById(R.id.txt_detail_prune);
        txtHumidity = findViewById(R.id.txt_detail_humidity);
        txtFurtherInfo = findViewById(R.id.txt_detail_furtherInfo);
        bottomNavigationView = findViewById(R.id.nav_detail_btnNav);
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}