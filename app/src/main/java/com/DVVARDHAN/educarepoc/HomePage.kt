package com.DVVARDHAN.educarepoc


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        tv_mrq.isSelected=true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
      menuInflater.inflate(R.menu.main,menu)


    return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==R.id.profile)
        {
            val intent=Intent(this,Profile::class.java)
        startActivity(intent)

        }
       else if(item!!.itemId==R.id.dairy)
        {
            val intent=Intent(this,Dairy::class.java)
        startActivity(intent)
        }
        else if(item.itemId==R.id.timetable)
        {
            val intent=Intent(this,Timetable::class.java)
            startActivity(intent)

        }
        else if(item.itemId.toString()=="attendance")
        {
            val intent=Intent(this,Attendance::class.java)
            startActivity(intent)

        }
        else if(item.itemId.toString()=="result")
        {
            val intent=Intent(this,Results::class.java)
            startActivity(intent)

        }




        return super.onOptionsItemSelected(item)
    }
}
