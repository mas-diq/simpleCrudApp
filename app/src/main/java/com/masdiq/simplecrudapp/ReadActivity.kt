package com.masdiq.simplecrudapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.simplecrudapp.retrofit.ApiInterface
import com.masdiq.simplecrudapp.retrofit.MyDataItem
import kotlinx.android.synthetic.main.activity_read.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://6e06-180-254-69-211.ngrok.io/"

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
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retofitData = retrofitBuilder.readData()

        retofitData.enqueue(object : Callback<List<MyDataItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                rv.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}