package com.example.kastorskayakseniaandreevna

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frame)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvDisplayName = findViewById<TextView>(R.id.tvDisplayName)
        val tvDisplayEmail = findViewById<TextView>(R.id.tvDisplayEmail)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Получаем данные из Intent
        val name = intent.getStringExtra("USER_NAME") ?: "Гость"
        val email = intent.getStringExtra("USER_EMAIL") ?: "не указан"

        tvDisplayName.text = "Имя: $name"
        tvDisplayEmail.text = "Email: $email"

        btnBack.setOnClickListener {
            finish()
        }
    }
}