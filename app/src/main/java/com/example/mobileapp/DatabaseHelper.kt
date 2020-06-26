package com.example.mobileapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class DatabaseHelper  (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

//แบบคงที่
    val allinterestList: ArrayList<String>
        @SuppressLint("Recycle")
        get() {

            val interestArrayList = ArrayList<String>()
            val gradesArrayList1 = ArrayList<String>()


            var s_m_loan = 0.0 //จำนวนเงินทั้งหมด
            var s_m_inter = 0.0 //อัตราดอกเบี้ย
            var s_m_period= 0.0 //s_m_period
            var loan = ""
            var interest = ""
            var period = ""

            val selectQuery = "SELECT * FROM $TABLE_INTEREST"

            val db = this.readableDatabase

            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {

                    loan = c.getString(c.getColumnIndex(LOAN))
                    interest = c.getString(c.getColumnIndex(INTEREST))
                    period = c.getString(c.getColumnIndex(PERIOD))

                    interestArrayList.add(
                        "loan: " + loan + "  interest: " + interest + "   period: " +
                                period
                    )
                    s_m_inter = loan.toDouble()*interest.toDouble()/100
                    s_m_loan = loan.toDouble()+(s_m_inter*(2))
                    s_m_period = s_m_loan/period.toDouble()

                    s_m_inter = String.format("%.2f", s_m_inter).toDouble()
                    s_m_loan = String.format("%.2f", s_m_loan).toDouble()
                    s_m_period = String.format("%.2f", s_m_period).toDouble()


                    interestArrayList.add("Interest per year : " + s_m_inter.toDouble())
                    interestArrayList.add("All you have to pay : " + s_m_loan.toDouble())
                    interestArrayList.add("Each pay period : " + s_m_period.toDouble())
                    interestArrayList.add("____________________________________________\n")

                } while (c.moveToNext())
                Log.d("array", interestArrayList.toString())

            }

            return interestArrayList
        }

//แบบธนาคาร
    val allinterestList1: ArrayList<String>
        @SuppressLint("Recycle")
        get() {

            val interestArrayList = ArrayList<String>()
            val interestArrayList1 = ArrayList<String>()


            var s_m_loan = 0.0 //จำนวนเงินทั้งหมด
            var s_m_inter = 0.0 //อัตราดอกเบี้ย
            var s_m_period= 0.0 //s_m_period
            var loan = ""
            var interest = ""
            var period = ""
            var myArray = arrayOf(31,28,31,30,31,30,31,31,31,31,30,31,31,28,31,30,31,30,31,31,31,31,30,31)
            var interofyear=0.0
            var intertomonth = 0.0
            var m_ofmonth=0.0
            var m_balance=0.0
            var sum_pay_tomonth=0.0
            var sum_of_interest=0.0
            var money_pay=0.0

//            var interofmonth=0.0
//            var m_balance=0.0
            val selectQuery = "SELECT * FROM $TABLE_INTEREST"

            val db = this.readableDatabase

            val c = db.rawQuery(selectQuery, null)


                if (c.moveToFirst()) {
                do {

                    loan = c.getString(c.getColumnIndex(LOAN))
                    interest = c.getString(c.getColumnIndex(INTEREST))
                    period = c.getString(c.getColumnIndex(PERIOD))
//
//                    interestArrayList.add(
//                        " loan: " + loan + "  interest: " + interest + "   period: " +
//                                period
//
//                    )
                    m_balance=loan.toDouble()
                    for (i in 0..period.toInt()-1) {

                        interofyear=m_balance.toDouble()*interest.toDouble()/100/365
                        intertomonth = interofyear.toDouble()*myArray[i]


                        m_ofmonth = loan.toDouble()/period.toDouble()


                        sum_pay_tomonth =   m_ofmonth + intertomonth


                        m_balance = m_balance.toDouble() - m_ofmonth.toDouble()
                        sum_of_interest=sum_of_interest.toDouble()+intertomonth
                        money_pay= loan.toDouble()+sum_of_interest.toDouble()

                        intertomonth = String.format("%.2f", intertomonth).toDouble()
                        m_ofmonth = String.format("%.2f", m_ofmonth).toDouble()
                        sum_pay_tomonth = String.format("%.2f", sum_pay_tomonth).toDouble()
                        m_balance = String.format("%.2f", m_balance).toDouble()

                        interestArrayList.add("period : " + (i+1) + "       day : " + myArray[i] )
                        interestArrayList.add("interest : " + intertomonth)
                        interestArrayList.add("installment : " + m_ofmonth)
                        interestArrayList.add("Each pay period : " + sum_pay_tomonth)
                        interestArrayList.add("balance : " + m_balance )
                        interestArrayList.add("______________________________________________\n")


                    }

                    sum_of_interest = String.format("%.2f", sum_of_interest).toDouble()
                    money_pay = String.format("%.2f", money_pay).toDouble()

                    interestArrayList.add("sum of interest : " + sum_of_interest)
                    interestArrayList.add("money to pay : " + money_pay)
     //               interestArrayList.add("_______________________________________________________________\n")
                    interestArrayList.add("\n***************************************************\n")


                } while (c.moveToNext())
                Log.d("array", interestArrayList.toString())

            }

            return interestArrayList
        }





    init {

        Log.d("table", CREATE_TABLE_INTEREST)
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_INTEREST)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS '$TABLE_INTEREST'")
        onCreate(db)
    }

    fun resetDatabase() {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS '$TABLE_INTEREST'")
        db.execSQL(CREATE_TABLE_INTEREST)
    }

    fun addinterestDetail(
        loan: String,
        interest: String,
        period: String
    ): Long {
        val db = this.writableDatabase
        // Creating content values
        val values = ContentValues()
        values.put(LOAN, loan)
        values.put(INTEREST, interest)
        values.put(PERIOD, period)

        // insert row in students table


        return db.insert(TABLE_INTEREST, null, values)
    }


    companion object {
        var DATABASE_NAME = "interest_database"
        private val DATABASE_VERSION = 1
        private val TABLE_INTEREST = "interest"
        private val LOAN = "loan"
        private val INTEREST = "interest"
        private val PERIOD = "period"



        private val CREATE_TABLE_INTEREST = ("CREATE TABLE " + TABLE_INTEREST +
                "(" + LOAN + " TEXT ," + INTEREST +
                " TEXT, " + PERIOD + " TEXT); " )
    }
}









