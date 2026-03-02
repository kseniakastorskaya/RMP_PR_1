package com.example.kastorskayakseniaandreevna

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentInfoActivity : AppCompatActivity() {


    private val TAG = "StudentInfoActivity"


    private lateinit var etFio: EditText
    private lateinit var etGroup: EditText
    private lateinit var etAge: EditText
    private lateinit var etGrade: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d(TAG, "onCreate: Активность создана.")


        etFio = findViewById(R.id.et_fio)
        etGroup = findViewById(R.id.et_group)
        etAge = findViewById(R.id.et_age)
        etGrade = findViewById(R.id.et_grade)

        val btnProgrammatic = findViewById<Button>(R.id.btn_programmatic)

        btnProgrammatic.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)


            intent.putExtra("fio", etFio.text.toString())
            intent.putExtra("group", etGroup.text.toString())
            intent.putExtra("age", etAge.text.toString())
            intent.putExtra("grade", etGrade.text.toString())

            startActivity(intent)
        }

        val btnDeclarative = findViewById<Button>(R.id.btn_declarative)

        btnDeclarative.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)


            intent.putExtra("fio", etFio.text.toString())
            intent.putExtra("group", etGroup.text.toString())
            intent.putExtra("age", etAge.text.toString())
            intent.putExtra("grade", etGrade.text.toString())

            finish()
            startActivity(intent)
        }
    }

    fun openSecondActivityDeclarative(view: View) {
        val intent = Intent(this, SecondActivity::class.java)

        intent.putExtra("fio", etFio.text.toString())
        intent.putExtra("group", etGroup.text.toString())
        intent.putExtra("age", etAge.text.toString())
        intent.putExtra("grade", etGrade.text.toString())

        startActivity(intent)
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Активность стала видимой для пользователя.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Активность получила фокус и готова к взаимодействию.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Активность частично невидима или теряет фокус.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Активность больше не видна пользователю.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Активность уничтожена.")

    }
}
