package com.masdiq.simplecrudapp.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.Presenter.CrudPresenter
import com.masdiq.simplecrudapp.R
import com.masdiq.simplecrudapp.Model.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_delete.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteActivity : AppCompatActivity() {
    private lateinit var crudPresenter: CrudPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        crudPresenter.deletePost()
    }

    fun delete() {
        btn_delete.setOnClickListener {
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
}