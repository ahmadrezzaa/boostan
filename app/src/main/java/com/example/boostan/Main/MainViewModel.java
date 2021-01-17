package com.example.boostan.Main;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public class MainViewModel {
    private MainRepo mainRepo=new MainRepo();
    public Single<List<Products>> getProducts(){
        return mainRepo.getProducts();
    }

}
