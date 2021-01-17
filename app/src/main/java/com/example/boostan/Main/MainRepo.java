package com.example.boostan.Main;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public class MainRepo implements MainDataSource {
    private MainApi mainApi=new MainApi();
    @Override
    public Single<List<Products>> getProducts() {
        return mainApi.getProducts();
    }

}
