package com.example.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clearOnClick(view: View) {
        textView.text = ""
        textResult.text = ""
    }
    fun bracketsOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "(")
        textView.text = addToTextView(buttonValue = ")")
    }
    fun brackets2OnClick(view: View) {
        textView.text = addToTextView(buttonValue = ")")
    }
    fun divideOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "/")
    }
    fun sevenOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "7")
    }
    fun eightOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "8")
    }
    fun nineOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "9")
    }
    fun multiplyOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "X")
    }
    fun fourOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "4")
    }
    fun fiveOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "5")
    }
    fun sixOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "6")
    }
    fun minusOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "-")
    }
    fun oneOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "1")
    }
    fun twoOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "2")
    }
    fun threeOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "3")
    }
    fun additionOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "+")
    }
    fun decimalOnClick(view: View) {
        textView.text = addToTextView(buttonValue = ".")
    }
    fun zeroOnClick(view: View) {
        textView.text = addToTextView(buttonValue = "0")
    }
    fun equalsOnClick(view: View) {
        showResult()
    }


    private fun addToTextView(buttonValue: String): String {
        return "${textView.text}$buttonValue"
    }

    private fun textViewExpression(): String {
        var expression = textView.text.replace(Regex("/"), "/")
        expression = expression.replace(Regex("X"),"*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = textViewExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                textView.text = "ERROR"
            } else {
                textView.text = DecimalFormat("0.######").format(result).toString()
            }
        }
        catch (e: Exception){
            textView.text = "ERROR"
        }
    }



}