package com.example.samrtcasttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val one = findViewById<Button>(R.id.btn1)
        val two = findViewById<Button>(R.id.btn2)
        val three = findViewById<Button>(R.id.btn3)
        val four = findViewById<Button>(R.id.btn4)

        val list = mutableListOf<StringText>()
        for (i in 0 until 4) {
            list.add(StringText(i, "hi${i}"))
        }

        one.text = list[0].stringText
        two.text = list[1].stringText
        three.text = list[2].stringText
        four.text = list[3].stringText

        one.setOnClickListener {
            smartCast(one, list[0])
        }

        two.setOnClickListener {
            smartCast(two, list[1])
        }

        three.setOnClickListener {
            smartCast(three, list[2])
        }

        four.setOnClickListener {
            smartCast(four, list[3])
        }
    }

    private fun smartCast(btn: Button, text: BaseText) {
        text as BaseText
        text as IntText
        text.intText = 10
        btn.text = text.intText.toString()
    }
}