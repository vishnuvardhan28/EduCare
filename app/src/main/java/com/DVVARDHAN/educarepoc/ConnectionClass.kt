package com.DVVARDHAN.educarepoc



import android.os.StrictMode
import android.util.Log
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class ConnectionClass {

    companion object {
        var con: Connection? = null
    }
    fun setConnection():String
    {
        var status:String
        try{

            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

            val ip:String="192.168.1.108"
            val ConnURL:String="jdbc:jtds:sqlserver://"+ip+";instance=SQLEXPRESS;user=sa;password=admin@123;databasename=dashboard;"
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            con=DriverManager.getConnection(ConnURL)
            Log.e("ASK","Connection called")
            status="Success"

        }
        catch (ex:Exception)
        {
            Log.e("ASK","Exception is:"+ex.toString() )
            status="failed"
        }


        return status
    }
    fun ExecuteQuery(sql:String):ResultSet{

        var stmt: Statement? = null
        var resultset: ResultSet? = null

        stmt= con!!.createStatement()

        resultset=stmt.executeQuery(sql)
        return resultset
    }





}


