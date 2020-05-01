package com.DVVARDHAN.educarepoc


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dairy.*
import java.lang.Exception
import java.sql.ResultSet

class Dairy : AppCompatActivity() {


     var ClassCode:String?=null
     var Section:String?=null
  var subjects:ArrayList<String> = ArrayList()
   var subdetails:ArrayList<ArrayList<String>> = ArrayList<ArrayList<String>>()



    var dt="23/04/2020"  // For time being Date value is hardCoded but this should be fetched as per the system Date&time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)

        val sqlQueryexecInst: MainActivity = MainActivity()

try
{
    var sql: String = "select ClassCode,Section  from Student where Aadhar_ID= '" + Login.Aadhar_ID +"'"
  //  val sqlQueryexec: MainActivity = MainActivity()
    var result: ResultSet = sqlQueryexecInst.CheckConnection(sql)
    var status:Boolean=false
     while (result.next())
     {
         ClassCode=result.getString("ClassCode")
         Section=result.getString("Section")

     }
}
catch (ex:Exception)
{

}

       if(ClassCode!=null && Section!=null) {
           try {
               var sql: String = "select SubName from Subject inner join Dairy ON Dairy.SubjectCode=Subject.SubCode where Dairy.ClassCode= '" + ClassCode + "' AND Dairy.Date= '" + dt + "'"

               var result: ResultSet = sqlQueryexecInst.CheckConnection(sql)
               var status: Boolean = false
               while (result.next()) {
                   subjects.add(result.getString("SubName"))



               }

           } catch (ex: Exception) {

           }
       }



        if(ClassCode!=null && dt!=null) {
            try {
                var sql: String = "select Topic,Comments,Homework from Dairy where ClassCode= '" + ClassCode + "' AND Date= '" + dt + "'"
              //  val sqlQueryexecInst: MainActivity = MainActivity()
                var result: ResultSet = sqlQueryexecInst.CheckConnection(sql)
                var status: Boolean = false
                var i=0
                var j=0
                while (result.next())
                {
                    var details:ArrayList<String> = ArrayList()
                  details.add(result.getString("Topic"))

                    details.add(result.getString("Comments"))
                   details.add(result.getString("Homework"))

              subdetails.add(details)
                }




            } catch (ex: Exception)
            {
                Log.d("Err","MSG="+ex.toString())
            }
        }


expandableListView.setAdapter(DairyExpandableListAdapter(this,subjects,subdetails))


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)


        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==R.id.profile)
        {
            val intent= Intent(this,Profile::class.java)
            startActivity(intent)

        }
        else if(item!!.itemId==R.id.Home)
        {
            val intent= Intent(this,HomePage::class.java)
            startActivity(intent)
        }
        else if(item.itemId.toString()=="timetable")
        {
            val intent= Intent(this,Timetable::class.java)
            startActivity(intent)

        }
        else if(item.itemId.toString()=="attendance")
        {
            val intent= Intent(this,Attendance::class.java)
            startActivity(intent)

        }
        else if(item.itemId.toString()=="result")
        {
            val intent= Intent(this,Results::class.java)
            startActivity(intent)

        }




        return super.onOptionsItemSelected(item)
    }

}
