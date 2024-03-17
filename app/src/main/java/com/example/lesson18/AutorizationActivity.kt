package com.example.lesson18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AutorizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autorization)
        val userLogin = findViewById<EditText>(R.id.edit_login)
        val userPassword = findViewById<EditText>(R.id.edit_password)
        val goToReg = findViewById<TextView>(R.id.go_to_reg)
        goToReg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.buttonAutorization)
        button.setOnClickListener {
            val loginText = userLogin?.text.toString().trim()
            val passwordText = userPassword?.text.toString().trim()
            if (loginText.length <= 6 || passwordText.length <= 6)
                Toast.makeText(
                    this,
                    "Логин и пароль должны иметь больше шести символов",
                    Toast.LENGTH_LONG
                )
                    .show()
            else {
                val db = BDCreater(this, null)
                val valid = db.getUser(loginText, passwordText)
                if (valid) {
                    Toast.makeText(this, "Пользователь $loginText  авторизован", Toast.LENGTH_LONG)
                        .show()

                    val intent = Intent(this, MainActivity3::class.java)

                    intent.putExtra("Login", userLogin?.text?.toString())
                    intent.putExtra("Password", userPassword?.text?.toString())
                    startActivity(intent)
                    userLogin.text.clear()
                    userPassword.text.clear()
                } else
                    Toast.makeText(
                        this,
                        "Пользователь $loginText  не авторизован",
                        Toast.LENGTH_LONG
                    )
                        .show()

            }
        }
    }
}





