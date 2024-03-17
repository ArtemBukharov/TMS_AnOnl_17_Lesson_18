package com.example.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val userEmail = findViewById<EditText>(R.id.user_email)
        val userPassword = findViewById<EditText>(R.id.user_password)
        val button = findViewById<Button>(R.id.button_reg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if (login == "" || email == "" || password == "")
                Toast.makeText(this, "Заполните все существующие поля", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val db=BDCreater(this,null)
                db.addUser(user)
                Toast.makeText(this, "Ваш $login добавлен", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }

        }
    }
}