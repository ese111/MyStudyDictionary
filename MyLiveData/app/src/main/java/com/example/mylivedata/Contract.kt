package com.example.mylivedata

interface Contract {
    interface View

    interface Presenter {
        fun getCount() : Int

        fun plusCount()
    }
}