package com.example.coroutine_demo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var counterText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.txtCount)

    }

    fun updateCounter(view: View) {

        counterText.text="${counterText.text.toString().toInt()+1}"
    }
    private suspend fun executeLongRunningTask(){       //Long running task
        for (i in 1..1000000000L)
        {

        }
    }

    fun doAction(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("1","${Thread.currentThread().name}")
            executeLongRunningTask()
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("2","${Thread.currentThread().name}")

        }
        MainScope().launch(Dispatchers.Default) {
            Log.d("3","${Thread.currentThread().name}")

        }

    }

}