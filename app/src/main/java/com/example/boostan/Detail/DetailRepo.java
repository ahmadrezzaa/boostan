package com.example.boostan.Detail;

import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public class DetailRepo implements DetailDataSource {
    private DetailApi detailApi=new DetailApi();


    @Override
    public Single<List<Detail>> getDetail(String id) {
        return detailApi.getDetail(id);
    }
}
