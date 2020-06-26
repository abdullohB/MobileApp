package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Show1Activity : AppCompatActivity() {
    private var databaseHelper8: DatabaseHelper? = null
    private var result8: TextView? = null
    private var arrayList8: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show1)
        supportActionBar!!.title="Mobile Application"
        databaseHelper8 = DatabaseHelper(this)
        result8 = findViewById(R.id.textView_1) as TextView
//        bt_show = findViewById(R.id.bt_show) as Button

        arrayList8 = databaseHelper8!!.allinterestList
        result8!!.text = ""

        for (i in arrayList8!!.indices) {
            result8!!.text = result8!!.text.toString()  + arrayList8!![i] + "\n"
        }

    }

}
