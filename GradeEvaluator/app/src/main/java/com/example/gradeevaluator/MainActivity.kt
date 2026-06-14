package com.example.gradeevaluator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etScore = findViewById<EditText>(R.id.etScore)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val evaluator = GradeEvaluator()

        btnCalculate.setOnClickListener {
            val inputText = etScore.text.toString()
            if (inputText.isEmpty()) {
                etScore.error = "Masukkan nilai terlebih dahulu"
                return@setOnClickListener
            }
            
            val score = inputText.toIntOrNull()
            if (score == null) {
                etScore.error = "Masukkan angka yang valid"
                return@setOnClickListener
            }

            val grade = evaluator.evaluateGrade(score)
            tvResult.text = "Grade: $grade"
        }
    }
}