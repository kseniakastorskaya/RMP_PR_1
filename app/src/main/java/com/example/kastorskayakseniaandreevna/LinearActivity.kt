package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LinearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            val intent = Intent(this, RelativeActivity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }

        val btnGoToNameInput = findViewById<Button>(R.id.btnGoToNameInput)
        val btnGoToFragments = findViewById<Button>(R.id.btnGoToFragments)

        btnGoToNameInput.setOnClickListener {
            val intent = Intent(this, NameInputActivity::class.java)
            startActivity(intent)
        }

        btnGoToFragments.setOnClickListener {
            val intent = Intent(this, FragmentsDemoActivity::class.java)
            startActivity(intent)
        }
    }
}