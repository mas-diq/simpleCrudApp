package com.masdiq.simplecrudapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.simplecrudapp.response.PostsResponse
import com.masdiq.simplecrudapp.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_read.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ReadActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        getRecyclerView()
        readData()
    }

    private fun getRecyclerView() {
        rv.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
    }

    private fun readData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitClient.BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retofitData = retrofitBuilder.readData()

        retofitData.enqueue(object : Callback<List<PostsResponse>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<PostsResponse>?>,
                response: Response<List<PostsResponse>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                rv.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<PostsResponse>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}