package com.masdiq.simplecrudapp.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/posts")
    fun readData(): Call<List<MyDataItem>>

    @GET("api/posts")
    fun createData(): Call<MyData>
}