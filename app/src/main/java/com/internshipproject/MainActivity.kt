package com.internshipproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: AppCompatButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.logEmail)
        password = findViewById(R.id.logPassword)
        loginBtn = findViewById(R.id.btnLogin)


        loginBtn.setOnClickListener {
            val emailLog = email.editableText.toString()
            val passwordLog = password.editableText.toString()

            if (emailLog.isEmpty()){
                Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show()
            } else if(passwordLog.isEmpty()){
                Toast.makeText(this, "Enter valid password", Toast.LENGTH_SHORT).show()
            } else {
                if (emailLog == emailLog && passwordLog == passwordLog){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}