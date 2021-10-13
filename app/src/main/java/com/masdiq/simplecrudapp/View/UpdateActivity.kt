package com.masdiq.simplecrudapp.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.Presenter.CrudPresenter
import com.masdiq.simplecrudapp.R
import com.masdiq.simplecrudapp.Model.response.PostsResponse
import com.masdiq.simplecrudapp.Model.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_update.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {
    private lateinit var crudPresenter: CrudPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        crudPresenter.updatePost()
    }

    fun update() {
        btn_submit_update.setOnClickListener {
            RetrofitClient.instance.putPost(
                tv_id_update.text.toString(),
                tv_title_update.text.toString(),
                tv_content_update.text.toString(),
                tv_place_update.text.toString(),
            ).enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    val responseText = "Data has updated"
                    tv_status_update.text = responseText
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    tv_status_update.text = t.message
                }
            })
        }
    }
}