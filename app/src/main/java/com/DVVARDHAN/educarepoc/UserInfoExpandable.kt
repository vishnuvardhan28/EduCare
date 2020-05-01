package com.DVVARDHAN.educarepoc


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_info_expandable.*

class UserInfoExpandable : AppCompatActivity() {

    val header: MutableList<String> = ArrayList()
    val body: HashMap<String,Int> = HashMap<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_expandable)
        header.add("Personl Information")

        body.put("Personl Information",R.layout.activity_adduser)

        expandableListView.setAdapter(ExpandableListAdapter(this,header,body))

    }
}
