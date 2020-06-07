package com.example.multiplatformapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.ktor.util.InternalAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity(), CoroutineScope {


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

    val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}


