package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var bt_show: Button? = null
    private var bt_shownew: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title="Mobile Application"

        bt_show = findViewById(R.id.send_money_button) as Button
        bt_shownew = findViewById(R.id.histoty_button) as Button

        bt_show!!.setOnClickListener {
            //            arrayList = databaseHelper!!.allinterestList
//            result!!.text = ""
//
//            for (i in arrayList!!.indices) {
//                result!!.text = result!!.text.toString()  + arrayList!![i] + "\n"
//            }
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)

        }


        bt_shownew!!.setOnClickListener {
            //            arrayList = databaseHelper!!.allinterestList1
//            result!!.text = ""
//
//            for (i in arrayList!!.indices) {
//                result!!.text = result!!.text.toString() + arrayList!![i] + "\n"
//            }
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}



