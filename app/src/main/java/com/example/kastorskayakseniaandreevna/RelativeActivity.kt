package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RelativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Получаем данные из Intent
        val name = intent.getStringExtra("USER_NAME") ?: ""
        val email = intent.getStringExtra("USER_EMAIL") ?: ""

        tvName.text = name
        tvEmail.text = email

        btnBack.setOnClickListener {
            finish() // Возврат на предыдущую Activity
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }
    }
}