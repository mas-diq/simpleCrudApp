package com.masdiq.simplecrudapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.response.CreateResponse
import kotlinx.android.synthetic.main.activity_create.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        btn_submit_create.setOnClickListener {
            createPost()
        }
    }

    private fun createPost() {
        with(RetrofitClient) {

            instance.createData(
                tv_title.text.toString(),
                tv_subtitle.text.toString(),
                tv_imageURL.text.toString()
            ).enqueue(object : Callback<CreateResponse> {
                override fun onResponse(
                    call: Call<CreateResponse>,
                    response: Response<CreateResponse>
                ) {
                    val responseText = "Title ${response.body()?.title} has added"
                    tv_status_create.text = responseText
                }

                override fun onFailure(call: Call<CreateResponse>, t: Throwable) {
                    tv_status_create.text = t.message
                }
            })
        }
    }
}