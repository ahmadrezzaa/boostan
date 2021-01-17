package com.example.boostan.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boostan.Main.MainActivity;
import com.example.boostan.Model.Version;
import com.example.boostan.R;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashScreen extends AppCompatActivity {
    final int SPLASH_DISPLAY_LENGTH = 3000;
    TextView txtVersion;
    int id = 1;
    SplashScreenViewModel viewModel = new SplashScreenViewModel();
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setupViews();
        checkConnection();


    }

    private void setupViews() {
        txtVersion = findViewById(R.id.txt_splashScreen_version);
    }

    private void checkVersion() {
        viewModel.getVersion(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Version>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull List<Version> versions) {

                        if (versions.get(0).getId() < id) {
                            Toast.makeText(SplashScreen.this, "Please Update", Toast.LENGTH_SHORT).show();
                        } else if (versions.get(0).getId() == id) {
                            txtVersion.setText(versions.get(0).getVersion());
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    /* Create an Intent that will start the Menu-Activity. */
                                    Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                                    SplashScreen.this.startActivity(mainIntent);
                                    SplashScreen.this.finish();
                                }
                            }, SPLASH_DISPLAY_LENGTH);
                        }
                    }


                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("error", e.toString());
                    }
                });
    }

    private boolean checkConnection() {
        // Check Connect to Internet
        ConnectivityManager cm = (ConnectivityManager) getSystemService(SplashScreen.this.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetwork() == null) {
            Toast.makeText(this, "عدم اتصال به اینترنت", Toast.LENGTH_LONG).show();
        } else {
            checkVersion();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}