package com.tushar.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etNumber=findViewById<EditText>(R.id.etNumber)
        val btnAdd=findViewById<Button>(R.id.btnAdd)
        val btnSubtract=findViewById<Button>(R.id.btnSubtract)
        val btnMultiply=findViewById<Button>(R.id.btnMultiply)
        val btnDivide=findViewById<Button>(R.id.btnDivide)

        fun getNumber(): Int {
            return etNumber.text.toString().toIntOrNull() ?: 0
        }

        btnAdd.setOnClickListener {
            val number = getNumber() + 3
            etNumber.setText(number.toString())
            etNumber.setSelection(etNumber.text.length)
        }

        btnSubtract.setOnClickListener {
            val number = getNumber() - 3
            etNumber.setText(number.toString())
            etNumber.setSelection(etNumber.text.length)
        }

        btnMultiply.setOnClickListener {
            val number = getNumber() * 3
            etNumber.setText(number.toString())
            etNumber.setSelection(etNumber.text.length)
        }

        btnDivide.setOnClickListener {
            val currentNumber = getNumber()
            val number = currentNumber / 3
            etNumber.setText(number.toString())
            etNumber.setSelection(etNumber.text.length)
        }
    }
    private fun getNumber(): Int {
        val etNumber=findViewById<EditText>(R.id.etNumber)
        return etNumber.text.toString().toIntOrNull() ?: 0
    }
}