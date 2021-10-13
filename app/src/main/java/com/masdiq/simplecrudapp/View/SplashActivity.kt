package com.masdiq.simplecrudapp.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.simplecrudapp.Presenter.CrudPresenter
import com.masdiq.simplecrudapp.R

class SplashActivity : AppCompatActivity() {
    private lateinit var crudPresenter: CrudPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        crudPresenter.color()
        crudPresenter.delay()
    }

    fun recolorTopBar() {
        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.primaryColor)
    }

    fun delay() {
        // Delay splash for 3 sec
        Handler(mainLooper).postDelayed({
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
            finish()
        }, 3000)
    }
}