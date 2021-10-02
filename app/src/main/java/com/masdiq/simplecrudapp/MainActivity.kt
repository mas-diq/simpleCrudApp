package com.masdiq.simplecrudapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pindah activity ke create
        btn_create.setOnClickListener {
            val moveCreate = Intent(this, CreateActivity::class.java)
            startActivity(moveCreate)
        }

        // Pindah activity ke read
        btn_read.setOnClickListener {
            val moveRead = Intent(this, ReadActivity::class.java)
            startActivity(moveRead)
        }

        // Pindah activity ke update
        btn_update.setOnClickListener {
            val moveUpdate = Intent(this, UpdateActivity::class.java)
            startActivity(moveUpdate)
        }

        // Pindah activity ke delete
        btn_delete.setOnClickListener {
            val moveDelete = Intent(this, DeleteActivity::class.java)
            startActivity(moveDelete)
        }

        // Pindah activity ke upload
        btn_upload.setOnClickListener {
            val moveUpload = Intent(this, UploadActivity::class.java)
            startActivity(moveUpload)
        }
    }
}