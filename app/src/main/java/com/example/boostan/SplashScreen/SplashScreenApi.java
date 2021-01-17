package com.example.boostan.SplashScreen;

import com.example.boostan.Model.Version;
import com.example.boostan.WebApi.ApiProvider;
import com.example.boostan.WebApi.ApiService;

import java.util.List;

import io.reactivex.Single;

public class SplashScreenApi implements SplashScreenDataSource {
    private ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<List<Version>> getVersion(int id) {
        return apiService.getVersion(id);
    }
}
