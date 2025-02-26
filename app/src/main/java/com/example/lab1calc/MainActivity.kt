package com.example.lab1calc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var resultField: EditText
    private var firstNumber = 0.0
    private var operation = ""
    private var isStart = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultField = findViewById(R.id.result_field)
        resultField.setText("0")
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val button0 = findViewById<Button>(R.id.button_0)
        val buttonPlusMinus = findViewById<Button>(R.id.button_plusminus)
        val buttonDot = findViewById<Button>(R.id.button_dot)
        val buttonPlus = findViewById<Button>(R.id.button_plus)
        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonMult = findViewById<Button>(R.id.button_mult)
        val buttonDiv = findViewById<Button>(R.id.button_div)
        val buttonEquals = findViewById<Button>(R.id.button_equals)
        val buttonC = findViewById<Button>(R.id.button_c)
        val buttonCE = findViewById<Button>(R.id.button_ce)

        button1.setOnClickListener {addNum("1")}
        button2.setOnClickListener {addNum("2")}
        button3.setOnClickListener {addNum("3")}
        button4.setOnClickListener {addNum("4")}
        button5.setOnClickListener {addNum("5")}
        button6.setOnClickListener {addNum("6")}
        button7.setOnClickListener {addNum("7")}
        button8.setOnClickListener {addNum("8")}
        button9.setOnClickListener {addNum("9")}
        button0.setOnClickListener {addNum("0")}
        buttonDot.setOnClickListener {addNum(".")}

        buttonPlus.setOnClickListener {
            Equality()
            isStart=false
            firstNumber = resultField.text.toString().toDouble()
            operation = "+"
            resultField.setText("0")
        }
        buttonMinus.setOnClickListener {
            Equality()
            isStart=false
            firstNumber = resultField.text.toString().toDouble()
            operation = "-"
            resultField.setText("0")
        }
        buttonMult.setOnClickListener {
            Equality()
            isStart=false
            firstNumber = resultField.text.toString().toDouble()
            operation = "*"
            resultField.setText("0")
        }
        buttonDiv.setOnClickListener {
            Equality()
            isStart=false
            firstNumber = resultField.text.toString().toDouble()
            operation = "/"
            resultField.setText("0")
        }

        buttonEquals.setOnClickListener {Equality()}
        buttonPlusMinus.setOnClickListener {
            if (resultField.text.toString().toIntOrNull() != null){
                resultField.setText(( -1 * resultField.text.toString().toInt()).toString())
            }
            else{
                resultField.setText(( -1 * resultField.text.toString().toDouble()).toString())
            }
        }
        buttonC.setOnClickListener{
            resultField.setText("0")
        }
        buttonCE.setOnClickListener{
            firstNumber = 0.0
            operation = ""
            resultField.setText("0")
        }



    }
    private fun Equality(){

        val secondNumber = resultField.text.toString().toDouble()
        val result = when (operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> {
                if(secondNumber == 0.0)
                {
                    0.0
                }
                else
                    firstNumber / secondNumber
            }
            else -> secondNumber
        }
        operation = ""
        firstNumber = 0.0
        isStart = true
        if (result == 0.0)
            resultField.setText("0")
        else
            resultField.setText(result.toString())
    }

    private fun addNum(number: String) {
        if  (number == "." )
        {
            if (resultField.text.contains('.'))
            {return}
            else {
                if (isStart)
                    isStart = false
                resultField.setText(resultField.text.toString() + number)
                return
            }
        }
        if (resultField.text.toString() == "0" || isStart)
        {
            isStart = false
            resultField.setText(number)
            return
        } else
        {
            resultField.setText(resultField.text.toString() + number)
            return
        }
    }



}