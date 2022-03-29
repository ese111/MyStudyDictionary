package com.example.recyclerviewtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(private val context: Context, private val studentList: MutableList<Students>) : BaseAdapter() {
    override fun getCount() = studentList.size

    override fun getItem(position: Int) = studentList[position]

    override fun getItemId(p0: Int) = 0L

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_view_item, null)

        val dogPhoto = view.findViewById<ImageView>(R.id.image)
        val dogBreed = view.findViewById<TextView>(R.id.name)
        val dogAge = view.findViewById<TextView>(R.id.age)
        val dogGender = view.findViewById<TextView>(R.id.gender)

        val student = studentList[position]
        val resourceId = context.resources.getIdentifier(student.photo, "drawable", context.packageName)
        dogPhoto.setImageResource(resourceId)
        dogBreed.text = student.name
        dogAge.text = student.age.toString()
        dogGender.text = student.gender

        Log.d("ListAdapter", "getView")

        return view
    }

}