package com.example.sachinrajput.restretrofit_withrecyclerview.interfacebaseURL;

import com.example.sachinrajput.restretrofit_withrecyclerview.pojo.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SachinRajput on 4/26/2020.
 */

public interface RequestInterface {
    @GET("api/users?page=1")
    Call<Data>getData();


}
