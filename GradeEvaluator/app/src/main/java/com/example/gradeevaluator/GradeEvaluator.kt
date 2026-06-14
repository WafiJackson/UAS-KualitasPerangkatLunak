package com.example.gradeevaluator

class GradeEvaluator {
    fun evaluateGrade(score: Int): String {
        return when {
            score < 0 || score > 100 -> "Nilai tidak valid (0-100)"
            score >= 85 -> "A"
            score >= 70 -> "B"
            score >= 60 -> "C"
            score >= 50 -> "D"
            else -> "E"
        }
    }
}