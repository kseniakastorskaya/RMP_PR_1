package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Получаем данные из Intent и устанавливаем в поля
        val name = intent.getStringExtra("USER_NAME") ?: ""
        val email = intent.getStringExtra("USER_EMAIL") ?: ""

        etName.setText(name)
        etEmail.setText(email)

        btnBack.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            val newName = etName.text.toString()
            val newEmail = etEmail.text.toString()

            val intent = Intent(this, FrameActivity::class.java)
            intent.putExtra("USER_NAME", newName)
            intent.putExtra("USER_EMAIL", newEmail)
            startActivity(intent)
        }
    }
}