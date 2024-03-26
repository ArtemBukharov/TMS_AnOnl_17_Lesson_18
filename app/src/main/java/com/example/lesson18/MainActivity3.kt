package com.example.lesson18

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
@SuppressLint("StaticFieldLeak")
private var textViewData:TextView?=null
class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        textViewData = findViewById(R.id.text_view_data)
        getData()
        val button= findViewById<Button>(R.id.button_activity3)
        button.setOnClickListener {
            val intent = Intent(this, ListOfWatchesActivity::class.java)
            startActivity(intent)
        }
    }
        @SuppressLint("SetTextI18n")
        private fun getData() {

            val login = intent.extras?.getString("Login")
            val password = intent.extras?.getString("Password")
            textViewData?.text = "Login: $login\nPassword: $password"
        }
    }
