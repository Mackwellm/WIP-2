package com.example.wip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var logInBtn: Button
    private lateinit var regBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //once click on login button takes to  login page
        logInBtn = findViewById(R.id.BTN_MAIN_LOGIN)
        logInBtn.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
        //once click on register button takes to  register page
        regBtn = findViewById<Button>(R.id.btn_mainRegister)
        regBtn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}