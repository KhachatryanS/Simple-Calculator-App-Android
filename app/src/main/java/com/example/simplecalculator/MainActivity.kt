package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun operation(op: Char) : String{
        val firstNumber = findViewById<TextView>(R.id.firstNumber).text.toString()
        val secondNumber = findViewById<TextView>(R.id.secondNumber).text.toString()
        return if(firstNumber == "" || secondNumber == ""){
            Toast.makeText(applicationContext,  "Fields Are Empty", Toast.LENGTH_LONG).show()
            ""
        }else{
            try {
                val result:Double? = when(op){
                    '+' -> (firstNumber.toDouble() + secondNumber.toDouble())
                    '-' -> (((firstNumber.toDouble() - secondNumber.toDouble())*10000).toInt())/10000.0
                    '*' -> (firstNumber.toDouble() * secondNumber.toDouble())
                    '/' -> (((firstNumber.toDouble() / secondNumber.toDouble())*10000).toInt())/10000.0
                    else -> null
                }
                "$result"
            }catch (e:NumberFormatException){
                Toast.makeText(applicationContext, "Fields can't be converted", Toast.LENGTH_LONG).show()
                ""
            }catch (e:ArithmeticException){
                Toast.makeText(applicationContext, "Division By 0", Toast.LENGTH_LONG).show()
                ""
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = findViewById<TextView>(R.id.result)

        val plusButton: Button = findViewById(R.id.plus)
        val minusButton: Button = findViewById(R.id.minus)
        val mulButton: Button = findViewById(R.id.mul)
        val divButton: Button = findViewById(R.id.div)

        plusButton.setOnClickListener {
            result.text = operation('+')
        }
        minusButton.setOnClickListener {
            result.text = operation('-')
        }
        mulButton.setOnClickListener {
            result.text = operation('*')
        }
        divButton.setOnClickListener {
            result.text = operation('/')
        }
    }
}