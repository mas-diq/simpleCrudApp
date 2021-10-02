package com.masdiq.simplecrudapp.retrofit

import com.masdiq.simplecrudapp.response.CreateResponse
import com.masdiq.simplecrudapp.response.PostsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    // Get all data
    @GET("api/posts")
    fun readData(): Call<List<PostsResponse>>

    // create one data
    @FormUrlEncoded
    @POST("api/posts")
    fun createData(
        @Field("title") title: String,
        @Field("subtitle") subtitle: String,
        @Field("imageURL") imageURL: String
    ): Call<CreateResponse>
}