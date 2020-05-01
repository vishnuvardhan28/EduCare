package com.DVVARDHAN.educarepoc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_adduser.*
import kotlinx.android.synthetic.main.activity_adduser.view.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class ExpandableListAdapter(var context:Context,var header:MutableList<String>,var body:HashMap<String,Int>) :BaseExpandableListAdapter(){
    lateinit var gender_sltd:String
    lateinit var role_sltd:String
    lateinit var religion_sltd:String
    lateinit var reservation_sltd:String
    lateinit var state_sltd:String
    lateinit var country_sltd:String
    lateinit var dist_sltd:String
    lateinit var dob_sltd:String
   lateinit var date_stld:String

    override fun getGroup(groupPosition: Int): String {
        return    this.header.get(groupPosition)

    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
      return true
    }

    override fun hasStableIds(): Boolean {
       return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

var convertView=convertView
        if(convertView==null)
        {
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.layout_group,null)
        }
              val title=convertView!!.findViewById<TextView>(R.id.tv_title)
        title.text=getGroup(groupPosition)
        return convertView


    }

       override fun getChildrenCount(groupPosition: Int): Int {
        return body.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Int{
        return childPosition
    }

    override fun getGroupId(groupPosition: Int): Long {
       return groupPosition.toLong()
    }

    @SuppressLint("NewApi")
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.activity_adduser, null)
        }
        if (true) {

            try {
                val dobfield: EditText = convertView!!.findViewById(R.id.etv_DOB)
                val genderfield: Spinner = convertView!!.findViewById(R.id.dd_gender)
                val countryfield: Spinner = convertView!!.findViewById(R.id.dd_country)
                val statefield: Spinner = convertView!!.findViewById(R.id.dd_state)
                val distfield: Spinner = convertView!!.findViewById(R.id.dd_city)
                val rolefield: Spinner = convertView!!.findViewById(R.id.dd_role)
                val religionfield: Spinner = convertView!!.findViewById(R.id.dd_religion)
                val reservationsfield: Spinner = convertView!!.findViewById(R.id.dd_resrv)


                var cal = Calendar.getInstance()
                val myFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)


                //Date of birth date picker

                dobfield.setOnClickListener {
                    val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(
                            view: DatePicker?,
                            year: Int,
                            month: Int,
                            dayOfMonth: Int
                        ) {
                            cal.set(Calendar.YEAR, year)
                            cal.set(Calendar.MONTH, month)
                            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                            date_stld = myFormat.format(cal.getTime())
                            dobfield.setText(date_stld)

                        }

                    }
                    DatePickerDialog(
                        context, dateSetListener, cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }

                //Selected date is


                dobfield.showSoftInputOnFocus = false


                val roles = arrayOf("Select Role", "Student", "Staff", "Admin")
                val religion = arrayOf("Select Religion", "Hindu", "Muslim", "Christian")
                val reservations = arrayOf("Select", "OC", "BC", "ST", "SC")
                val Genderlst = arrayOf("Male", "Female", "Other")
                val TSdist =
                    arrayOf(
                        "Select Dist",
                        "Hyderabad",
                        "Warangal",
                        "Nalgonda",
                        "Karimnagar",
                        "Khammam"
                    )
                val ApState = arrayOf("Select Dist", "Vijayawada", "Visakapatnam")
                val State = arrayOf("Select State", "Telangana", "AndhraPradesh")
                val Country = arrayOf("Select Country", "India")

                genderfield.adapter =
                    ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, Genderlst)
                genderfield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        gender_sltd = Genderlst[position]
                    }
                }


                countryfield.adapter =
                    ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, Country)
                countryfield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var result: String = Country[position]
                        if (result == "India") {
                            statefield.adapter = ArrayAdapter(
                                context,
                                R.layout.support_simple_spinner_dropdown_item,
                                State
                            )
                        }
                        country_sltd = Country[position]

                    }


                }




                statefield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }


                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var result: String = State[position]
                        if (result == "Telangana") {
                            distfield.adapter = ArrayAdapter(
                                context,
                                R.layout.support_simple_spinner_dropdown_item,
                                TSdist
                            )
                        } else if (result == "AndhraPradesh") {
                            distfield.adapter = ArrayAdapter(
                                context,
                                R.layout.support_simple_spinner_dropdown_item,
                                ApState
                            )
                        }
                        state_sltd = State[position]


                    }


                }



                distfield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        if (state_sltd == "Telangana") {
                            dist_sltd = TSdist[position]
                        } else if (state_sltd == "AndhraPradesh") {
                            dist_sltd = ApState[position]
                        }


                    }


                }



                rolefield.adapter =
                    ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, roles)
                rolefield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        role_sltd = roles[position]
                    }


                }



                religionfield.adapter =
                    ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, religion)
                religionfield.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        religion_sltd = religion[position]
                    }


                }


                reservationsfield.adapter =
                    ArrayAdapter(
                        context,
                        R.layout.support_simple_spinner_dropdown_item,
                        reservations
                    )
                reservationsfield.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            reservation_sltd = reservations[position]
                        }


                    }


                convertView.btn_adduser.setOnClickListener {

try {
    val AdduserInst: Adduser = Adduser()
    var sql =
        "Insert into Login(Aadhar_ID,UserName,Password,Role,FirstName,LastName,DOB,Identification_Mole1,Identification_Mole2,Religion,Reservation,MotherTounge,Gender,Address,City,District,State,Country,Pincode)Values('" + convertView.etv_aadhar.text +"','"+ convertView.etv_user.text +"','" + convertView.etv_pswd.text +"','" + role_sltd +"','" + convertView.etv_fname.text +"','" + convertView.etv_lname.text + "','" +
     myFormat.format(cal.getTime()) +"','" + convertView.etv_mole1.text +"','"+convertView.etv_mole2.text+"','" + religion_sltd+"','" + reservation_sltd+"','" + convertView.etv_MTounge.text+"','" + gender_sltd+"','" + convertView.etv_addrs.text+"','"+convertView.etv_addrs2.text + "','" + dist_sltd+"','" + state_sltd+"','" + country_sltd+"','" + convertView.etv_pincode.text + "');"

    AdduserInst.CheckConnection(sql)
}catch (ex:Exception)
{
    Log.d("AddUserDBerr", "Error:" + ex.toString())
}
                }

            } catch (ex: Exception) {
                Log.d("AddUser", "Error:" + ex.toString())


            }

        }


            return convertView
        }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
       return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return this.header.size
    }

}