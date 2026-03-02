package com.example.kastorskayakseniaandreevna

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvData = findViewById<TextView>(R.id.tv_data)

        // Получаем данные, переданные из StudentInfoActivity
        val fio = intent.getStringExtra("fio")
        val group = intent.getStringExtra("group")
        val age = intent.getStringExtra("age")
        val grade = intent.getStringExtra("grade")

        val displayText = "ФИО: $fio\n" +
                "Группа: $group\n" +
                "Возраст: $age\n" +
                "Желаемая оценка: $grade"
        tvData.text = displayText
    }

}