package com.example.boostan.SplashScreen;

import com.example.boostan.Model.Version;

import java.util.List;

import io.reactivex.Single;

public class SplashScreenRepository implements SplashScreenDataSource{
    private SplashScreenApi api=new SplashScreenApi();
    @Override
    public Single<List<Version>> getVersion(int id) {
        return api.getVersion(id);
    }
}
