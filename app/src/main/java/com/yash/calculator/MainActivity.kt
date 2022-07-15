package com.yash.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var clear : Button
    private lateinit var button01 : Button
    private lateinit var button02 : Button
    private lateinit var button03 : Button
    private lateinit var button04 : Button
    private lateinit var button05 : Button
    private lateinit var button06 : Button
    private lateinit var button07 : Button
    private lateinit var button08 : Button
    private lateinit var button09 : Button
    private lateinit var button00 : Button
    private lateinit var add : Button
    private lateinit var backspace : Button
    private lateinit var substract : Button
    private lateinit var expo : Button
    private lateinit var multi : Button
    private lateinit var divide : Button

    private lateinit var btnEqual : Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear = findViewById(R.id.Clear)
        button00 = findViewById(R.id.button18)
        button01 = findViewById(R.id.button13)
        button02 = findViewById(R.id.button14)
        button03 = findViewById(R.id.button15)
        button04 = findViewById(R.id.button4)
        button05 = findViewById(R.id.button10)
        button06 = findViewById(R.id.button11)
        button07 = findViewById(R.id.button5)
        button08 = findViewById(R.id.button6)
        button09 = findViewById(R.id.button7)
        add = findViewById(R.id.BtnAdd)
        substract = findViewById(R.id.BtnMinus)
        multi = findViewById(R.id.BtnMul)
        expo = findViewById(R.id.BtnExpo)
        backspace = findViewById(R.id.BtnBackspace)
        divide = findViewById(R.id.button4)
        btnEqual = findViewById(R.id.BtnEquals)


        clear.setOnClickListener{
            input.text = ""
            output.text = ""

        }
        button00.setOnClickListener {
            input.text = addToInputText(0)
        }
        button01.setOnClickListener {
            input.text = addToInputText(1)
        }
        button02.setOnClickListener {
            input.text = addToInputText(2)
        }
        button03.setOnClickListener {
            input.text = addToInputText(3)
        }
        button04.setOnClickListener {
            input.text = addToInputText(4)
        }
        button05.setOnClickListener {
            input.text = addToInputText(5)
        }
        button06.setOnClickListener {
            input.text = addToInputText(6)
        }
        button07.setOnClickListener {
            input.text = addToInputText(7)
        }
        button08.setOnClickListener {
            input.text = addToInputText(8)
        }
        button09.setOnClickListener {
            input.text = addToInputText(9)
        }
        add.setOnClickListener {
            input.text = addToInputText('+')
        }
        substract.setOnClickListener {
            input.text = addToInputText('-')
        }
        expo.setOnClickListener {
            input.text = addToInputText('^')
        }
        multi.setOnClickListener {
            input.text = addToInputText('×')
        }
        divide.setOnClickListener {
            input.text = addToInputText('÷')
        }
        backspace.setOnClickListener  {
            val text = input.text.toString()
            if(text.isNotEmpty()) {
                input.text = text.drop(1)
            }

            output.text = ""
        }
        btnEqual.setOnClickListener {
            showResult()
        }
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.##########").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))


        }
    }

    private fun  addToInputText(buttonValue: Any): String{
       return "${input.text}$buttonValue"
    }
    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }

}