package com.example.investmentschemecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener() {
            val c: Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    txtDOB.setText(
                        day.toString() + "/" +
                                (month + 1).toString() + "/" +
                                year.toString()
                    )

                    val age = currentYear - year
                    val basicSaving = getSaving(age)

                    txtAge.text = age.toString()
                    txtBasicSaving.text = "RM " + basicSaving.toString()
                    txtAllowableInvestment.text = "RM " + (basicSaving * 0.3)

                }, currentYear, currentMonth, currentDay
            )

            dpd.show()
        }

    }
    fun getSaving(age : Int): Int {

        when (age) {
            in 16..20 -> return 5000
            in 21..25 -> return 14000
            in 26..30 -> return 29000
            in 31..35 -> return 50000
            in 36..40 -> return 78000
            in 41..45 -> return 116000
            in 46..50 -> return 165000
            in 51..65 -> return 228000
        }
        return 0
    }
}


