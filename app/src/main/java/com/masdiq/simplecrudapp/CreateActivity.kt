package com.masdiq.simplecrudapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.response.CreateResponse
import kotlinx.android.synthetic.main.activity_create.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {

    private var imagePicker: ImageView? = null

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        image_picker.setOnClickListener {
            pickImage()
        }

        btn_submit_create.setOnClickListener {
            createPost()
        }
    }

    fun pickImage() {
        val choooseImage = Intent(Intent.ACTION_PICK)
        choooseImage.type = "image/*"
        startActivityForResult(choooseImage, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            image_picker.setImageURI(data?.data)
            imagePicker = image_picker
        }
    }

    private fun createPost() {
        with(RetrofitClient) {
            instance.createData(
                tv_title.text.toString(),
                tv_subtitle.text.toString(),
                imagePicker.toString()
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