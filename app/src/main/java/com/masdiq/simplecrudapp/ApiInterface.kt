package com.masdiq.simplecrudapp

import com.masdiq.simpleretrofit.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/posts")
    fun getData(): Call<List<MyDataItem>>
}