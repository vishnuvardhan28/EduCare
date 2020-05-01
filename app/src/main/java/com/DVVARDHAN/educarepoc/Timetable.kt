package com.DVVARDHAN.educarepoc


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timetable.*
import kotlinx.android.synthetic.main.timetbl_item.view.*
import java.sql.ResultSet

class Timetable : AppCompatActivity() {
 lateinit var ClassCode:String
    var adapter:TimetblAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        var TimeLst:ArrayList<TimetblLst> = ArrayList()
        var TimeLstitems:TimetblLst?=null
        val sqlQueryexecInst: MainActivity = MainActivity()

        try {
            var sql: String = "select ClassCode from Student where Aadhar_ID= '" + Login.Aadhar_ID +"'"
            //  val sqlQueryexec: MainActivity = MainActivity()
            var result: ResultSet = sqlQueryexecInst.CheckConnection(sql)
            var status:Boolean=false
            while (result.next())
            {
                ClassCode=result.getString("ClassCode")


            }
        }catch(ex:Exception)
        {
            Log.d("TimetblERRMSG","Msg:"+ex.toString())
}

  

        try {
            // Following sql stmt will join the view and Teachers table and fetch the result from that combination

        //    var sql: String = "select distinct PeriodID,Time,SubName,Day_of_Week,TeacherName from vtTimetableTeacherName join Teachers ON vtTimetableTeacherName.TeacherID=Teachers.TeacherID ORDER BY Day_of_Week , PeriodID "

          var sql:String="select distinct TimeTable.PeriodID,TimeTable.Time,TimeTable.DayCode,Subject.SubName,Teachers.TeacherName ,TimeTable.Day_of_Week from TimeTable join Subject ON TimeTable.SubjectCode=Subject.SubCode join Teachers ON TimeTable.TeacherID=Teachers.TeacherID where TimeTable.ClassCode= '"+ClassCode+"' ORDER BY TimeTable.Day_of_Week ,TimeTable.PeriodID ASC"


            var result: ResultSet = sqlQueryexecInst.CheckConnection(sql)
            var status:Boolean=false
            while(result.next())
            {
                val obj:TimetblLst= TimetblLst()
                obj.periodName=result.getString("PeriodID")
                obj.timeName=result.getString("Time")
                obj.subName=result.getString("SubName")
                obj.dayName=result.getString("DayCode")
                obj.teacherName=result.getString("TeacherName")
                TimeLst.add(obj)

            }


        }catch(ex:Exception)
        {
            Log.d("TimetblERRMSG","Msg:"+ex.toString())
        }
















adapter= TimetblAdapter(this,TimeLst)
        lv_timetbl.adapter=adapter

    }

    class TimetblAdapter:BaseAdapter
    {
          var timelst=ArrayList<TimetblLst>()
        var context:Context?=null
        constructor(context:Context,timelst:ArrayList<TimetblLst>)
        {
              this.context=context
            this.timelst=timelst

        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val timetblview:View= View.inflate(context,R.layout.timetbl_item,null)
              var sltdItem=timelst[position]
            timetblview.tv_day.text=sltdItem.dayName
            timetblview.tv_period.text=sltdItem.periodName
            timetblview.tv_sub.text=sltdItem.subName
            timetblview.tv_time.text=sltdItem.timeName
            timetblview.tv_teacher.text=sltdItem.teacherName

                  return timetblview

 }

        override fun getItem(position: Int): Any {
            return timelst[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return timelst.size
        }


    }




}
