package com.masdiq.simplecrudapp.retrofit

import com.masdiq.simplecrudapp.response.CreateResponse
import com.masdiq.simplecrudapp.response.PostsResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    // Get all data
    @GET("api/posts")
    fun readData(): Call<List<PostsResponse>>

    // create one data
    @FormUrlEncoded
    @POST("api/posts")
    fun createData(
        @Field("title") title: String,
        @Field("content") subtitle: String,
        @Field("place") place: String
    ): Call<CreateResponse>

    // Update one data
    @FormUrlEncoded
    @PUT("api/posts/{id}")
    fun putPost(
        @Path("id") id: String?,
        @Field("title") title: String?,
        @Field("content") subtitle: String?,
        @Field("place") place: String?,
    ): Call<PostsResponse>

    // Delete one data
    @DELETE("api/posts/{id}")
    fun deletePost(@Path("id") id: String): Call<Void>
}