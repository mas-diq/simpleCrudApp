package com.masdiq.simplecrudapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.response.PostsResponse
import kotlinx.android.synthetic.main.activity_update.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {

    private var imagePicker: ImageView? = null

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        image_picker_update.setOnClickListener {
            pickImage()
        }

        btn_submit_update.setOnClickListener {
            updatePost()
        }
    }

    private fun pickImage() {
        val choooseImage = Intent(Intent.ACTION_PICK)
        choooseImage.type = "image/*"
        startActivityForResult(choooseImage, CreateActivity.IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CreateActivity.IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            image_picker_update.setImageURI(data?.data)
            imagePicker = image_picker_update
        }
    }

    private fun updatePost() {
        RetrofitClient.instance.putPost(
            tv_id_update.text.toString(),
            tv_title_update.text.toString(),
            tv_subtitle_update.text.toString(),
            imagePicker.toString(),
            published = true
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