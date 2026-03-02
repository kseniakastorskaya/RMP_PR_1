package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //дизайн с разметкой
        setContentView(R.layout.activity_main)
        // чтоб шапка сверху была
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val click_activity_zoo = findViewById<Button>(R.id.click_activity_zoo)
        click_activity_zoo.setOnClickListener {
            val intent = Intent(this, ZooActivity::class.java)
            startActivity(intent)
        }
    }
}