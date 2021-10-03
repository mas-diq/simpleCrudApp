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
        @Field("subtitle") subtitle: String,
        @Field("imageURL") imageURL: String
    ): Call<CreateResponse>

    // Update one data
    @FormUrlEncoded
    @PUT("api/posts/{id}")
    fun putPost(
        @Path("id") id: String?,
        @Field("title") title: String?,
        @Field("subtitle") subtitle: String?,
        @Field("imageURL") imageURL: String?,
        @Field("published") published: Boolean? = true
    ): Call<PostsResponse>

    // Delete one data
    @DELETE("api/posts/{id}")
    fun deletePost(@Path("id") id: String): Call<Void>
}