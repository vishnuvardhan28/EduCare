package com.DVVARDHAN.educarepoc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_adduser.*
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.ResultSet
import java.text.SimpleDateFormat
import java.util.*

class Adduser : AppCompatActivity() {


    var cal = Calendar.getInstance()
    val myFormat = SimpleDateFormat("EEEE, MMM d,yyyy", Locale.US)
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)





    }

    public fun CheckConnection(sql:String) {
        try {
            val AdduserInst:ConnectionClass =  ConnectionClass()
            if (ConnectionClass.con==null)
            {

                var status =   AdduserInst.setConnection()
                // tvConnStatus.text=status
            }

            if (ConnectionClass.con!=null)
            {
                var result: ResultSet

                result= AdduserInst.ExecuteQuery(sql)

            }
        }catch (ex:Exception)
        {
            Log.d("ASK","Exception="+ex.toString())
        }



    }

}
