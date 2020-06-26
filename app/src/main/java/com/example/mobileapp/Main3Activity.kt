package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Main3Activity : AppCompatActivity() {
    private var loan1: EditText? = null
    private var interest1: EditText? = null
    private var period1: EditText? = null

    private var bt_save1: Button? = null
    private var bt_reset1: Button? = null
    private var bt_show1: Button? = null
    private var bt_shownew1: Button? = null

    private var databaseHelper1: DatabaseHelper? = null
    private var result1: TextView? = null
    private var arrayList1: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar!!.title="Mobile Application"
        databaseHelper1 = DatabaseHelper(this)
//        result1 = findViewById(R.id.text_result2) as TextView


        loan1 = findViewById(R.id.i_lona2) as EditText
        interest1 = findViewById(R.id.i_inter2) as EditText
        period1 = findViewById(R.id.i_period2) as EditText

        bt_save1 = findViewById(R.id.bt_save2) as Button
        bt_reset1 = findViewById(R.id.bt_reset2) as Button
//        bt_show1 = findViewById(R.id.bt_show2) as Button
        bt_shownew1 = findViewById(R.id.bt_shownew2) as Button


        bt_save1!!.setOnClickListener {
            databaseHelper1!!.addinterestDetail(loan1!!.text.toString(),interest1!!.text.toString(),period1!!.text.toString())

            loan1!!.setText("")
            interest1!!.setText("")
            period1!!.setText("")

            Toast.makeText(this@Main3Activity, "Stored Successfully!", Toast.LENGTH_SHORT).show()
        }

        bt_reset1!!.setOnClickListener {
            databaseHelper1!!.resetDatabase()
        }

//        bt_show!!.setOnClickListener {
//            arrayList = databaseHelper!!.allinterestList
//            result!!.text = ""
//
//            for (i in arrayList!!.indices) {
//                result!!.text = result!!.text.toString()  + arrayList!![i] + "\n"
//            }
////            val intent = Intent(this, page2Activity::class.java)
////            startActivity(intent)
//
//        }


        bt_shownew1!!.setOnClickListener {
//            arrayList1 = databaseHelper1!!.allinterestList1
//            result1!!.text = ""
//
//            for (i in arrayList1!!.indices) {
//                result1!!.text = result1!!.text.toString() + arrayList1!![i] + "\n"
//            }
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }




    }
}