package com.example.webservices.retrofit

import com.example.webservices.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/posts.json")
    fun getData():Call<DataModel>


}