package com.example.wip

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UpdatedList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updated_list)


            //get data from intent
            val intent = intent
            val name = intent.getStringExtra("Name")
            val description = intent.getStringExtra("Description")
            val start = intent.getStringExtra("Start Date")
            val end = intent.getStringExtra("End Date")
            val Hrs = intent.getStringExtra("Hrs")
            val mini = intent.getStringExtra("Min Goal")
            val Maxi = intent.getStringExtra("Max Goal")

            //textview
            val result: TextView = findViewById<TextView>(R.id.TvData)
            //setText
            result.text = "Name: "+ name +"\nDescription: "+ description + "\nStart: "+ start + "\nEnd Date:" + end + "\nHours:" + "4" + "\nMinimum hours" + "1" + "\nMaximum hours:" + "5"

            val button:Button =  findViewById<Button>(R.id.btn_Done)
            button.setOnClickListener {
                val intent = Intent(this, AddTask::class.java)
                startActivity(intent)
            }


        }
    }

