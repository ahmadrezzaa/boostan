package com.example.boostan.Search;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public interface SearchDataSource {
    Single<List<Products>> getSearch(String search);
}
