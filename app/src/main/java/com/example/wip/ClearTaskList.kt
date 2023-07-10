package com.example.wip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ClearTaskList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clear_task_list)

        val button: Button = findViewById<Button>(R.id.addTask)
        button.setOnClickListener{
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)


        }
    }
}