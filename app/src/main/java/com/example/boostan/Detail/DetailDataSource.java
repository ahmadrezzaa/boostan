package com.example.boostan.Detail;
import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;
import java.util.List;
import io.reactivex.Single;

public interface DetailDataSource {
    Single<List<Detail>> getDetail(String id);

}
