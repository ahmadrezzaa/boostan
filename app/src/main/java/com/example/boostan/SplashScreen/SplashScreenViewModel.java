package com.example.boostan.SplashScreen;

import com.example.boostan.Model.Version;

import java.util.List;

import io.reactivex.Single;

public class SplashScreenViewModel {
    private SplashScreenRepository repository=new SplashScreenRepository();
    Single<List<Version>> getVersion(int id){
       return repository.getVersion(id);
    }
}
