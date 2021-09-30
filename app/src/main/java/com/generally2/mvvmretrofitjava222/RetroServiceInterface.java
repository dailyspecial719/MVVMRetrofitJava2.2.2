package com.generally2.mvvmretrofitjava222;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface RetroServiceInterface {

    @POST("users")
    @Headers({"Accept:application/json", "Content-Type:application/json",
                "Authorization: Bearer 783f3082495ebe7a67618526a483cfa51e32908d1694c73b99dae5dad04f524e"})
    Call<UserResponse> createUser(@Body User params);


}
