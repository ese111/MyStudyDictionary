package com.example.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity(), Contract.View {
    private var liveText: MutableLiveData<String> = MutableLiveData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = Presenter(this)
        val text = findViewById<TextView>(R.id.text_test)
        val btn = findViewById<Button>(R.id.btn_change)
        liveText.observe(this, Observer {
            text.text = it
        })

        btn.setOnClickListener {
            presenter.plusCount()
            liveText.value = "${presenter.getCount()}"
        }
    }
}