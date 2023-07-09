package com.example.wip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val Createbtn = findViewById<Button>(R.id.btn_Create_Cat)



        Createbtn.setOnClickListener {
            val intent = Intent(this, CreateCat::class.java)
            startActivity(intent)
        }


        //new created category name
        val textView = findViewById<TextView>(R.id.txtNewCat1)
        val intent = intent
        val Text = intent.getStringExtra("Category")

        if (Text != null) {
            textView.setText(Text);
        }
        //new category
        val textView2 = findViewById<TextView>(R.id.btn_hmw)
        textView2.setOnClickListener {
            val intent = Intent(this, ListOfTasks::class.java)
            startActivity(intent)

        }
        //old information
        val textView1 = findViewById<TextView>(R.id.txtNewCat1)
        textView1.setOnClickListener {
            val intent = Intent(this, ClearTaskList::class.java)
            startActivity(intent)

        }

    }
}
