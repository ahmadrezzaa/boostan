package com.example.boostan.Search;

import com.example.boostan.Model.Products;
import com.example.boostan.WebApi.ApiProvider;
import com.example.boostan.WebApi.ApiService;

import java.util.List;

import io.reactivex.Single;

public class SearchApi implements SearchDataSource {
    private ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<List<Products>> getSearch(String search) {
        return apiService.getSearch(search);
    }
}
