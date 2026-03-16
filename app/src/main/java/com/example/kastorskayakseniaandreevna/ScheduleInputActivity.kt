package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ScheduleInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_schedule_input)

        val tvSelectedSubject = findViewById<TextView>(R.id.tvSelectedSubject)
        val etDay = findViewById<EditText>(R.id.etDay)
        val etTime = findViewById<EditText>(R.id.etTime)
        val etComment = findViewById<EditText>(R.id.etComment)
        val btnOk = findViewById<Button>(R.id.btnOk)

        // Получаем выбранный предмет
        val selectedSubject = intent.getStringExtra("SELECTED_SUBJECT") ?: ""
        tvSelectedSubject.text = selectedSubject

        btnOk.setOnClickListener {
            val day = etDay.text.toString()
            val time = etTime.text.toString()
            val comment = etComment.text.toString()

            if (day.isNotEmpty() && time.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("DAY", day)
                resultIntent.putExtra("TIME", time)
                resultIntent.putExtra("COMMENT", comment)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Заполните день и время", Toast.LENGTH_SHORT).show()
            }
        }
    }
}