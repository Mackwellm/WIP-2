package com.example.wip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateCat : AppCompatActivity() {

    private lateinit var Cat_Name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_cat)

        Cat_Name = findViewById(R.id.popup_window_Cat)



        val button = findViewById<Button>(R.id.popup_window_button)
        button.setOnClickListener {
            val intent = Intent(this@CreateCat, Categories::class.java)
            intent.putExtra("Category", Cat_Name.text.toString())
            startActivity(intent)
        }
    }
}