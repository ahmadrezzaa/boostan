package com.example.boostan.SplashScreen;

import com.example.boostan.Model.Version;

import java.util.List;

import io.reactivex.Single;

public interface SplashScreenDataSource {
    Single<List<Version>> getVersion(int id);
}
