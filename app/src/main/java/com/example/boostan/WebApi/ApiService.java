package com.example.boostan.WebApi;

import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;
import com.example.boostan.Model.Version;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
@GET("product.php")
    Single<List<Products>> getProducts();

@GET("detail.php")
    Single<List<Detail>> getDetail(@Query("id")String id);

    @GET("search.php")
    Single<List<Products>> getSearch(@Query("search") String search);

    @GET("check_version.php")
    Single<List<Version>> getVersion(@Query("id")int id);
}
