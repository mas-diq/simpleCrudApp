package com.masdiq.simplecrudapp.View

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.Presenter.CrudPresenter
import com.masdiq.simplecrudapp.R
import com.masdiq.simplecrudapp.Model.response.CreateResponse
import com.masdiq.simplecrudapp.Model.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_create.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {
    private lateinit var crudPresenter: CrudPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        crudPresenter.createPost()
    }

    fun create() {
        btn_submit_create.setOnClickListener {
            with(RetrofitClient) {
                instance.createData(
                    tv_title_create.text.toString(),
                    tv_content_create.text.toString(),
                    tv_place_create.text.toString()
                ).enqueue(object : Callback<CreateResponse> {
                    override fun onResponse(
                        call: Call<CreateResponse>,
                        response: Response<CreateResponse>
                    ) {
                        val responseText = "${response.body()?.title} has added"
                        tv_status_create.text = responseText
                    }

                    override fun onFailure(call: Call<CreateResponse>, t: Throwable) {
                        tv_status_create.text = t.message
                    }
                })
            }
        }
    }
}