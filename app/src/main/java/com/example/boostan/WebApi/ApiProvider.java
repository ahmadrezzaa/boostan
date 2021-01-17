package com.example.boostan.WebApi;

public class ApiProvider {
    private static ApiService apiService;
    public static ApiService apiProvider(){
        if(apiService==null){
            apiService=ApiClient.getClient().create(ApiService.class);
        }
        return apiService;
    }
}
