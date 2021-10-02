package com.masdiq.simplecrudapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        btn_create.setOnClickListener {
//            createPost()
        }
    }

//    private fun createPost() {
//        RetrofitClient.instance
//    }
}