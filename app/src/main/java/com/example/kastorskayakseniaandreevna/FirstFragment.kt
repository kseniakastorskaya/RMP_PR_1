package com.example.kastorskayakseniaandreevna

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvText = view.findViewById<TextView>(R.id.tvFragmentText)
        val btnClick = view.findViewById<Button>(R.id.btnFragmentClick)

        tvText.text = "Это первый фрагмент (статический)"

        btnClick.setOnClickListener {
            Toast.makeText(requireContext(), "Нажат первый фрагмент", Toast.LENGTH_SHORT).show()
        }
    }
}