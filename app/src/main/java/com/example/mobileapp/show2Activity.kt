package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class show2Activity : AppCompatActivity() {
    private var databaseHelper9: DatabaseHelper? = null
    private var result9: TextView? = null
    private var arrayList9: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show2)
        supportActionBar!!.title="Mobile Application"
        databaseHelper9 = DatabaseHelper(this)
        result9 = findViewById(R.id.textView_2) as TextView


        arrayList9 = databaseHelper9!!.allinterestList1
        result9!!.text = ""

        for (i in arrayList9!!.indices) {
            result9!!.text = result9!!.text.toString() + arrayList9!![i] + "\n"
        }
    }
}
