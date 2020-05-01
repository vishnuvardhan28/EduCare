package com.DVVARDHAN.educarepoc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class DairyExpandableListAdapter(var context:Context,var header:ArrayList<String>,var body:ArrayList<ArrayList<String>>) :BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String {
        return this.header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView=convertView
        if(convertView==null)
        {
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.layout_dairygroup,null)
        }
        val title=convertView!!.findViewById<TextView>(R.id.tv_listTitle)
        title.text=getGroup(groupPosition) as String
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
       return 1
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
       return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
       return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {

        var convertView=convertView
        if(convertView==null)
        {
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.layout_dairychild,null)
        }
         val concepts=convertView!!.findViewById<TextView>(R.id.tv_subtitle)
        val comments=convertView!!.findViewById<TextView>(R.id.tv_subcomments)
        val homework=convertView!!.findViewById<TextView>(R.id.tv_subhomework)

           concepts.text = getChild(groupPosition, 0) as String
            comments.text = getChild(groupPosition, 1) as String
            homework.text = getChild(groupPosition, 2) as String




        return convertView



    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
      return  childPosition.toLong()
    }

    override fun getGroupCount(): Int {
       return header.size
    }
}