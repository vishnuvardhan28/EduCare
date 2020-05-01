package com.DVVARDHAN.educarepoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    public fun CheckConnection(sql:String):ResultSet {
        var result: ResultSet?=null
        try {

            val AdduserInst:ConnectionClass =  ConnectionClass()
            if (ConnectionClass.con==null)
            {

                var status =   AdduserInst.setConnection()
                // tvConnStatus.text=status
            }

            if (ConnectionClass.con!=null)
            {


                result= AdduserInst.ExecuteQuery(sql)



            }
        }catch (ex:Exception)
        {
            Log.d("ASK","Exception="+ex.toString())
        }


return result!!
    }
}
