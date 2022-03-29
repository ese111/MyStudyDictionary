package com.example.recyclerviewtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, val students: List<Students>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val photo = itemView?.findViewById<ImageView>(R.id.image)
        val name = itemView?.findViewById<TextView>(R.id.name)
        val age = itemView?.findViewById<TextView>(R.id.age)
        val gender = itemView?.findViewById<TextView>(R.id.gender)

        fun bind (students: Students, context: Context) {

            if (students.photo != "") {
                val resourceId = context.resources.getIdentifier(students.photo, "drawable", context.packageName)
                photo?.setImageResource(resourceId)
            } else {
                photo?.setImageResource(R.mipmap.ic_launcher)
            }

            name?.text = students.name
            age?.text = students.age.toString()
            gender?.text = students.gender

            Log.d("RecyclerAdapter", "bind")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        Log.d("RecyclerAdapter", "onCreateViewHolder")
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("RecyclerAdapter", "onBindViewHolder")
        holder.bind(students[position], context)
    }

    override fun getItemCount() = students.size
}