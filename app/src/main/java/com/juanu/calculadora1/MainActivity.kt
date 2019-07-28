package com.juanu.calculadora1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt1.setOnClickListener { appendOnExpresstion("1", true) }
        bt2.setOnClickListener { appendOnExpresstion("2", true) }
        bt3.setOnClickListener { appendOnExpresstion("3", true) }
        bt4.setOnClickListener { appendOnExpresstion("4", true) }
        bt5.setOnClickListener { appendOnExpresstion("5", true) }
        bt6.setOnClickListener { appendOnExpresstion("6", true) }
        bt7.setOnClickListener { appendOnExpresstion("7", true) }
        bt8.setOnClickListener { appendOnExpresstion("8", true) }
        bt9.setOnClickListener { appendOnExpresstion("9", true) }
        bt0.setOnClickListener { appendOnExpresstion("0", true) }
        btpunt.setOnClickListener { appendOnExpresstion(".", true) }



        btsum.setOnClickListener { appendOnExpresstion("+", false) }
        btrest.setOnClickListener { appendOnExpresstion("-", false) }
        btmult.setOnClickListener { appendOnExpresstion("*", false) }
        btdiv.setOnClickListener { appendOnExpresstion("/", false) }


        btlimp.setOnClickListener {
            Expresion.text = ""
            Resultado.text = ""
        }



        bteq.setOnClickListener {
            try {

                val expresion = ExpressionBuilder(Expresion.text.toString()).build()
                val resultado = expresion.evaluate()
                val longResult = resultado.toLong()
                if(resultado == longResult.toDouble())
                    Resultado.text = longResult.toString()
                else
                    Resultado.text = resultado.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(Resultado.text.isNotEmpty()){
            Expresion.text = ""
        }

        if (canClear) {
            Resultado.text = ""
            Expresion.append(string)
        } else {
            Expresion.append(Resultado.text)
            Expresion.append(string)
            Resultado.text = ""
        }
    }
}

