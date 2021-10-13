package com.masdiq.simplecrudapp.View

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.simplecrudapp.Presenter.CrudPresenter
import com.masdiq.simplecrudapp.R
import com.masdiq.simplecrudapp.Model.response.PostsResponse
import com.masdiq.simplecrudapp.Model.retrofit.ApiInterface
import com.masdiq.simplecrudapp.Model.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var crudPresenter: CrudPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crudPresenter.recolor()
        crudPresenter.toCreate()
        crudPresenter.toUpdate()
        crudPresenter.toDelete()
        crudPresenter.getRV()
        crudPresenter.getData()
    }

    fun recolorTopBar() {
        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.primaryColor)
    }

    fun moveToCreate() {
        btn_create.setOnClickListener {
            val moveCreate = Intent(this, CreateActivity::class.java)
            startActivity(moveCreate)
        }
    }

    fun moveToUpdate() {
        btn_edit.setOnClickListener {
            val moveUpdate = Intent(this, UpdateActivity::class.java)
            startActivity(moveUpdate)
        }
    }

    fun moveToDelete() {
        btn_delete.setOnClickListener {
            val moveDelete = Intent(this, DeleteActivity::class.java)
            startActivity(moveDelete)
        }
    }

    fun getRecyclerView() {
        rv.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
    }

    fun readData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RetrofitClient.BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.readData()

        retrofitData.enqueue(object : Callback<List<PostsResponse>?> {
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
                Log.d("SplashActivity", "onFailure: " + t.message)
            }
        })
    }
}