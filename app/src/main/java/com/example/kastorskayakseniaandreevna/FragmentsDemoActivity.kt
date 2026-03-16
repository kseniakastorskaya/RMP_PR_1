package com.example.kastorskayakseniaandreevna

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentsDemoActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_demo)

        fragmentContainer = findViewById(R.id.fragment_container)

        val btnStatic = findViewById<Button>(R.id.btnStaticFragment)
        val btnDynamic = findViewById<Button>(R.id.btnDynamicFragment)
        val btnContainer = findViewById<Button>(R.id.btnContainerFragment)

        btnStatic.setOnClickListener {
            // Статический фрагмент уже загружен в разметке
            // Ничего не делаем, просто показываем Toast
            android.widget.Toast.makeText(this, "Это статический фрагмент", android.widget.Toast.LENGTH_SHORT).show()
        }

        btnDynamic.setOnClickListener {
            // Динамическое добавление фрагмента
            loadFragment(SecondFragment())
        }

        btnContainer.setOnClickListener {
            // Замена фрагмента в FragmentContainerView
            loadFragment(ThirdFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}