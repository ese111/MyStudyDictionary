package com.example.mylivedata

class Presenter(view: Contract.View) : Contract.Presenter {
    private val data = Data()
    override fun getCount() = data.getCount()

    override fun plusCount() = data.plusCount()
}