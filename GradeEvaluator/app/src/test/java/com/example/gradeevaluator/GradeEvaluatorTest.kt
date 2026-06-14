package com.example.gradeevaluator

import org.junit.Assert
import org.junit.Test

/*
 * Penjelasan Unit Test Case (Fokus pada Statement & Path Coverage):
 *
 * 1. testGradeA:
 * Menguji kondisi *boundary* atas ketika nilai >= 85. Test ini memastikan
 * bahwa logika pengkondisian mengeksekusi path pertama dengan benar dan
 * mengembalikan string "A".
 *
 * 2. testGradeE:
 * Menguji kondisi *boundary* bawah (< 50). Test ini memastikan bahwa input
 * yang tidak memenuhi syarat minimum kelulusan pada kondisi 'if' manapun
 * akan ditangkap oleh blok 'else', mengamankan coverage pada path tersebut
 * dan mengembalikan string "E".
 */
class GradeEvaluatorTest {

    private val evaluator = GradeEvaluator()

    @Test
    fun testGradeA() {
        val result = evaluator.evaluateGrade(85)
        Assert.assertEquals("A", result)
    }

    @Test
    fun testGradeE() {
        val result = evaluator.evaluateGrade(45)
        Assert.assertEquals("E", result)
    }
}