package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NameInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_name_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val btnNext = findViewById<Button>(R.id.btnNextToSubject)

        btnNext.setOnClickListener {
            val lastName = etLastName.text.toString()
            val firstName = etFirstName.text.toString()

            if (lastName.isNotEmpty() && firstName.isNotEmpty()) {
                val intent = Intent(this, SubjectInputActivity::class.java)
                intent.putExtra("LAST_NAME", lastName)
                intent.putExtra("FIRST_NAME", firstName)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}