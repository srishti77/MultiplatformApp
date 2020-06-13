package com.example.multiplatformapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.ktor.util.InternalAPI
import kotlinx.android.synthetic.main.activity_main.*

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    @InternalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_text.text = getMessage()

        getData {
            quote.visibility = View.VISIBLE
            quote.setText(it)
        }

    }
}