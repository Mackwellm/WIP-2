package com.example.wip

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val textView : TextView = findViewById(R.id.txt_NewAct)
        val intent = intent
        val Text = intent.getStringExtra("Category")

        if (Text != null) {
            textView.setText(Text);
        }


        //old category
        val textView2 = findViewById<TextView>(R.id.btn_hmw)
        textView2.setOnClickListener {
            val intent = Intent(this, ListOfTasks::class.java)
            startActivity(intent)

        }
        //new information
        val textView1: TextView = findViewById(R.id.txt_NewAct)
        textView1.setOnClickListener {
            val intent = Intent(this, ClearTaskList::class.java)
            startActivity(intent)

        }



        //LogOUT Button
        val btn_LogOut: Button =findViewById(R.id.btn_Logout)
        btn_LogOut.setOnClickListener {
            val mypref: SharedPreferences = getSharedPreferences("MY", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = mypref.edit()
            editor.clear()
            editor.commit()
            applicationContext.getSharedPreferences("User", 0).edit().clear().commit()
            Log.d(TAG, "Now Log out")
            val intent = Intent(this, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)




        }

    }
}
