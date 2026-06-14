package com.example.gradeevaluator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testUIComponentsVisibility() {
        // Memastikan UI untuk input dan tombol berhasil dimuat di layar
        onView(withId(R.id.etScore))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnCalculate))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testGradeCalculationFlow() {
        // Menyimulasikan input angka 75, menutup keyboard, lalu menekan tombol hitung
        onView(withId(R.id.etScore))
            .perform(typeText("75"), closeSoftKeyboard())

        onView(withId(R.id.btnCalculate))
            .perform(click())

        // Memverifikasi apakah hasil yang muncul di TextView adalah "B"
        onView(withId(R.id.tvResult))
            .check(matches(withText("B")))
    }
}