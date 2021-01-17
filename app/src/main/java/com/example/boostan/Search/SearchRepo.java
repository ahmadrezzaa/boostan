package com.example.boostan.Search;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public class SearchRepo implements SearchDataSource {
    private SearchApi searchApi=new SearchApi();
    @Override
    public Single<List<Products>> getSearch(String search) {
        return searchApi.getSearch(search);
    }
}
