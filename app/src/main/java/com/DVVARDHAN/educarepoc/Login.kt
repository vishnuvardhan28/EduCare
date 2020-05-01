package com.DVVARDHAN.educarepoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.ResultSet

class Login : AppCompatActivity() {
    companion object
    {
        var Aadhar_ID:String?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        btn_adduser.setOnClickListener {
            val intent = Intent(this, UserInfoExpandable::class.java)
            startActivity(intent)

        }


    }

fun login(view: View)
{

try {


    val user = etv_username.text
    val pswd = etv_pswd.text
    var sql: String = "select Aadhar_ID from Login where UserName= '" + user + "' AND Password= '" + pswd+"'"
    val sqlQueryexec: MainActivity = MainActivity()
    var result: ResultSet = sqlQueryexec.CheckConnection(sql)
    var status:Boolean=false
    while (result.next()) {

       status=true
        Aadhar_ID=result.getString("Aadhar_ID")
    }

    if(status==true)
    {
        var intent=Intent(this,HomePage::class.java)
        startActivity(intent)
    }
    else{

        tv_msg.text="Entered wrong userid or password"
    }


}
catch (ex:Exception)
{
    Log.d("RetrieveErr","Msg:"+ex.toString())
}





}











    }





