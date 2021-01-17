package com.example.boostan.Main;

import com.example.boostan.Model.Products;
import com.example.boostan.WebApi.ApiClient;
import com.example.boostan.WebApi.ApiProvider;
import com.example.boostan.WebApi.ApiService;

import java.util.List;

import io.reactivex.Single;

public class MainApi implements MainDataSource {
   private ApiService apiService=ApiProvider.apiProvider();
    @Override
    public Single<List<Products>> getProducts() {
        return apiService.getProducts();
    }

}
