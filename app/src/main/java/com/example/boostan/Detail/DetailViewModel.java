package com.example.boostan.Detail;
import com.example.boostan.Model.Detail;
import com.example.boostan.Model.Products;
import java.util.List;
import io.reactivex.Single;

public class DetailViewModel {
    private DetailRepo detailRepo=new DetailRepo();
    public Single<List<Detail>> getDetail(String id){
        return detailRepo.getDetail(id);
    }
    }
