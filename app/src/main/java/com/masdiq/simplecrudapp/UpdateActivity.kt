package com.masdiq.simplecrudapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.response.PostsResponse
import com.masdiq.simplecrudapp.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_update.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        btn_submit_update.setOnClickListener {
            updatePost()
        }
    }

    private fun updatePost() {
        RetrofitClient.instance.putPost(
            tv_id_update.text.toString(),
            tv_title_update.text.toString(),
            tv_content_update.text.toString(),
            tv_place_update.text.toString(),
        ).enqueue(object : Callback<PostsResponse> {
            override fun onResponse(call: Call<PostsResponse>, response: Response<PostsResponse>) {
                val responseText = "Data has updated"
                tv_status_update.text = responseText
            }

            override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                tv_status_update.text = t.message
            }
        })
    }
}