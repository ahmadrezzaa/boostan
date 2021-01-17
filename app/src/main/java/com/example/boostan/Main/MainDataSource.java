package com.example.boostan.Main;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public interface MainDataSource {
    Single<List<Products>> getProducts();

}
