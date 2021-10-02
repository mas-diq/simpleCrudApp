package com.masdiq.simplecrudapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_delete.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        btn_delete.setOnClickListener {
            deletePosts()
        }
    }

    private fun deletePosts() {
        RetrofitClient.instance.deletePost(
            tv_delete.text.toString()
        ).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                tv_status_delete.text = "Data has been deleted"
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                tv_status_delete.text = t.message
            }

        })
    }
}