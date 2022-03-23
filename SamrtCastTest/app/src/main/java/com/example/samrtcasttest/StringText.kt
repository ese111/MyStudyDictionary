package com.example.samrtcasttest

import android.widget.Button
import android.widget.TextView

class StringText(override val id: Int, var stringText: String) : BaseText {
    fun changeText(btn: Button) {
        btn.text = stringText
    }
}