package com.masdiq.simplecrudapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.retrofit.ApiInterface
import com.masdiq.simplecrudapp.retrofit.MyDataItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_read.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

//        btn_create.setOnClickListener {
//            createData()
//        }
    }

//    private fun createData() {
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//            .create(ApiInterface::class.java)
//
//        val retofitData = retrofitBuilder.createData()
//
//        retofitData.enqueue(object : Callback<List<MyDataItem>?> {
//            @SuppressLint("NotifyDataSetChanged")
//            override fun onResponse(
//                call: Call<List<MyDataItem>?>,
//                response: Response<List<MyDataItem>?>
//            ) {
//                val responseBody = response.body()!!
//            }
//
//            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
//                Log.d("MainActivity", "onFailure: " + t.message)
//            }
//        })
//    }
}