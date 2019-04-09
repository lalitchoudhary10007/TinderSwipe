package com.example.testtt1;

import com.example.testtt1.POJOModels.EmpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("employees")
    Call<List<EmpResponse>> getTopRatedMovies();

}
