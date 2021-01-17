package com.example.boostan.Search;

import com.example.boostan.Model.Products;

import java.util.List;

import io.reactivex.Single;

public class SearchViewModel {
    private SearchRepo searchRepo=new SearchRepo();
    public Single<List<Products>> getSearch(String search){
        return searchRepo.getSearch(search);
    }
}
