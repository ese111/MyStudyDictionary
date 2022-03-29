package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val studentsList = mutableListOf<Students>(
        Students("김학생", 13, "남", "img"),
        Students("박학생", 14, "남", "img_1"),
        Students("이학생", 15, "여", "img_2"),
        Students("나학생", 12, "남", "img_3"),
        Students("하학생", 17, "여", "img_4"),
        Students("유학생", 14, "남", "img_5"),
        Students("최학생", 15, "여", "img_6"),
        Students("전학생", 22, "남", "img_7"),
        Students("라학생", 17, "여", "img_8"),
        Students("성학생", 18, "남", "img_9"),
        Students("권학생", 14, "여", "img_10"),
        Students("강학생", 13, "남", "img_11"),
        Students("제갈학생", 12, "여", "img_12"),
        Students("독고학생", 14, "남", "img_13"),
        Students("송학생", 11, "여", "img_14"),
        Students("학생", 13, "남", "img_15"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = ListAdapter(this, studentsList)
//        val listView = findViewById<ListView>(R.id.list_view)
//        listView.adapter = adapter
        val adapter = RecyclerAdapter(this, studentsList)
        val recyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        recyclerView.adapter = adapter
        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }
}