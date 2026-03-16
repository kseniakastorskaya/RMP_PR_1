package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SubjectInputActivity : AppCompatActivity() {

    // Создаем контракт для получения результата от другой Activity
    private val getScheduleResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Обрабатываем результат здесь
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val day = data?.getStringExtra("DAY") ?: ""
            val time = data?.getStringExtra("TIME") ?: ""
            val comment = data?.getStringExtra("COMMENT") ?: ""

            Toast.makeText(
                this,
                "Время занятия успешно передано!\n$day $time - $comment",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subject_input)

        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val spinnerSubject = findViewById<Spinner>(R.id.spinnerSubject)
        val btnGoToSchedule = findViewById<Button>(R.id.btnGoToSchedule)
        val btnBack = findViewById<Button>(R.id.btnBackFromSubject)

        // Получаем данные из Intent
        val lastName = intent.getStringExtra("LAST_NAME") ?: ""
        val firstName = intent.getStringExtra("FIRST_NAME") ?: ""

        // Отображаем ФИО
        tvFullName.text = "Студент: $lastName $firstName"

        // Настраиваем Spinner с предметами
        val subjects = arrayOf("Математика", "Физика", "Информатика", "Английский язык", "История")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSubject.adapter = adapter

        btnGoToSchedule.setOnClickListener {
            val selectedSubject = spinnerSubject.selectedItem.toString()
            val intent = Intent(this, ScheduleInputActivity::class.java)
            intent.putExtra("SELECTED_SUBJECT", selectedSubject)
            // Используем новый API вместо startActivityForResult
            getScheduleResult.launch(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}