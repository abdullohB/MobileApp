package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {
    private var loan: EditText? = null
    private var interest: EditText? = null
    private var period: EditText? = null

    private var bt_save: Button? = null
    private var bt_reset: Button? = null
    private var bt_show: Button? = null
    private var bt_shownew: Button? = null

    private var databaseHelper: DatabaseHelper? = null
    private var result: TextView? = null
    private var arrayList: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.title="Mobile Application"
        databaseHelper = DatabaseHelper(this)
        bt_save = findViewById(R.id.send_money_button) as Button
        bt_show = findViewById(R.id.histoty_button) as Button
//        bt_shownew = findViewById(R.id.bt_shownew) as Button



        bt_save!!.setOnClickListener {
            val intent = Intent(this, Show1Activity::class.java)
            startActivity(intent)
        }


        bt_show!!.setOnClickListener {

            val intent = Intent(this, show2Activity::class.java)
            startActivity(intent)

        }



    }
}



