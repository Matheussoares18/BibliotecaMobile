package com.example.biblioteca

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    fun Logar(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}