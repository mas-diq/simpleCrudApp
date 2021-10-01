package com.masdiq.simplecrudapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_crud.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pindah activity
        btn_crud.setOnClickListener {
            val moveCrud = Intent(this, CrudActivity::class.java)
            startActivity(moveCrud)
        }

        // Pindah activity
        btn_upload_file.setOnClickListener {
            val moveUpload = Intent(this, CrudActivity::class.java)
            startActivity(moveUpload)
        }
    }
}