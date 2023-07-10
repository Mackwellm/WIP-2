package com.example.wip

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listOfTasks: ListOfTasks, list: ArrayList<TaskModel?>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var mList: ArrayList<TaskModel>? = null
    var context: Context? = null

    fun MyAdapter(context: Context?, mList: ArrayList<TaskModel>?) {
        this.mList = mList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model: TaskModel = mList!!.get(position)
        holder.taskName.setText(model.taskName)
        holder.description.setText(model.description)
        holder.start.setText(model.startDate)
        holder.end.setText(model.enddate)
        holder.hrsworked.setText(model.hoursWorked)
        holder.min.setText(model.minGoal)
        holder.max.setText(model.maxGoal)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskName: TextView
        var description: TextView
        var start: TextView
        var end: TextView
        var hrsworked: TextView
        var min: TextView
        var max: TextView



        init {
            taskName = itemView.findViewById<TextView>(R.id.name_txt)
            description = itemView.findViewById<TextView>(R.id.desc_txt)
            start = itemView.findViewById<TextView>(R.id.start_txt)
            end = itemView.findViewById<TextView>(R.id.end_txt)
            hrsworked = itemView.findViewById<TextView>(R.id.hrs_txt)
            min = itemView.findViewById<TextView>(R.id.min_txt)
            max = itemView.findViewById<TextView>(R.id.max_txt)
        }
    }


}
