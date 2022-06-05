package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operacion: Int = 0
    var numero: Double = 0.0
    lateinit var txtPro: TextView
    lateinit var txtRes: TextView
    lateinit var txtOpe: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPro = findViewById(R.id.txt_procedimiento)
        txtRes = findViewById(R.id.txt_resultado)
        txtOpe = findViewById(R.id.txt_operacion)
        val botonBorrar: Button = findViewById(R.id.btn_ac)
        val btnIgual: Button = findViewById(R.id.btn_resultado)
    }

    fun presionarDigito(view: View){
        if(operacion.equals(0)) {
            txtRes.setText("")
        }

        val txtValor: String = txtPro.text.toString()
        when(view.id){
            R.id.btn0 -> txtPro.setText(txtValor + "0")
            R.id.btn1 -> txtPro.setText(txtValor + "1")
            R.id.btn2 -> txtPro.setText(txtValor + "2")
            R.id.btn3 -> txtPro.setText(txtValor + "3")
            R.id.btn4 -> txtPro.setText(txtValor + "4")
            R.id.btn5 -> txtPro.setText(txtValor + "5")
            R.id.btn6 -> txtPro.setText(txtValor + "6")
            R.id.btn7 -> txtPro.setText(txtValor + "7")
            R.id.btn8 -> txtPro.setText(txtValor + "8")
            R.id.btn9 -> txtPro.setText(txtValor + "9")
            R.id.btn_punto -> txtPro.setText(txtValor + ".")
        }
    }

    fun clickOperacion(view: View){
        numero = txtPro.text.toString().toDouble()
        var num_text: String = txtPro.text.toString()
        txtPro.setText("")
        when(view.id){
            //suma
            R.id.btn_suma -> {
                txtRes.setText(num_text)
                txtOpe.setText("+")
                operacion = 1
            }

            //resta
            R.id.btn_resta -> {
                txtRes.setText(num_text)
                txtOpe.setText("-")
                operacion = 2
            }

            //multiplicacion
            R.id.btn_multiplicacion -> {
                txtRes.setText(num_text)
                txtOpe.setText("*")
                operacion = 3
            }

            //division
            R.id.btn_division -> {
                txtRes.setText(num_text)
                txtOpe.setText("/")
                operacion = 4
            }


        }
    }

    fun resultado(view: View){
        if(txtPro.text.equals("") || txtRes.text.equals("")){
            operacion = 0
        }else {
            var num1: Double = txtRes.text.toString().toDouble()
            var num2: Double = txtPro.text.toString().toDouble()
            var resultado: Double = 0.0

            when (operacion) {
                //suma
                1 -> {
                    resultado = num1 + num2
                    txtRes.setText(resultado.toString())
                    txtPro.setText("")
                    txtOpe.setText("")
                    operacion = 0
                }
                //resta
                2 -> {
                    resultado = num1 - num2
                    txtRes.setText(resultado.toString())
                    txtPro.setText("")
                    txtOpe.setText("")
                    operacion = 0
                }
                //multiplicacion
                3 -> {
                    resultado = num1 * num2
                    txtRes.setText(resultado.toString())
                    txtPro.setText("")
                    txtOpe.setText("")
                    operacion = 0
                }
                //division
                3 -> {
                    if(txtPro.text.toString().equals("0")) {
                        resultado = num1 / 1
                        txtRes.setText(resultado.toString())
                        txtPro.setText("")
                        txtOpe.setText("")
                        operacion = 0
                    }else{
                        resultado = num1 / num2
                        txtRes.setText(resultado.toString())
                        txtPro.setText("")
                        txtOpe.setText("")
                        operacion = 0
                    }
                }

            }
        }
    }
}