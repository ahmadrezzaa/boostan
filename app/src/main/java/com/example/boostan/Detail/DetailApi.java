package com.example.boostan.Detail;


import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;
import com.example.boostan.WebApi.ApiProvider;
import com.example.boostan.WebApi.ApiService;

import java.util.List;

import io.reactivex.Single;

public class DetailApi implements DetailDataSource {
    private ApiService apiService= ApiProvider.apiProvider();


    @Override
    public Single<List<Detail>> getDetail(String id) {
        return apiService.getDetail(id);
    }
}
