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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultField = findViewById(R.id.result_field)
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

        button1.setOnClickListener {addNum("1")}
        button2.setOnClickListener {addNum("2")}
        button3.setOnClickListener {addNum("3")}
        button4.setOnClickListener {addNum("4")}
        button5.setOnClickListener {addNum("5")}
        button6.setOnClickListener {addNum("6")}
        button7.setOnClickListener {addNum("7")}
        button8.setOnClickListener {addNum("8")}
        button9.setOnClickListener {addNum("9")}



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }


    private fun addNum(number: String) {
        if (resultField.text.toString() == "0") {
            resultField.setText(number)
        } else {
            resultField.setText(resultField.text.toString() + number)
        }
    }
}