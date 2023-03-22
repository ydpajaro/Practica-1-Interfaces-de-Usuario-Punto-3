package com.yeinerdpajaro.bodymassindexapp.ui.main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yeinerdpajaro.bodymassindexapp.R

class MainViewModel : ViewModel(){




    val mensaje: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val valorIMC: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val calcularIMC: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun IMC(peso: Double,altura: Double){
        valorIMC.value = peso/(altura*altura)
    }
    fun calculoIMC(peso: Double,altura: Double){

        val total = peso/(altura*altura)

        if(total > 0 && total <18.5) {

            calcularIMC.value = "DESCRIPCIÓN: Peso bajo."

        }else if(total >= 18.5 && total <24.9) {

            calcularIMC.value ="DESCRIPCIÓN: Peso normal."

        }else if(total >= 24.9 && total <29.9){

            calcularIMC.value = "DESCRIPCIÓN: Sobre peso."

        }else if(total >= 29.9 && total <34.9){

            calcularIMC.value = "DESCRIPCIÓN: Obesidad tipo uno."
        }else if(total >= 34.9 && total <39.9){

            calcularIMC.value = "DESCRIPCIÓN: Obesidad tipo dos."
        }else if(total >= 39.9){

            calcularIMC.value = "DESCRIPCIÓN: Obesidad tipo tres."
        }

    }

    fun realizarValidateNulls(peso: String, altura: String): Boolean {
        return !(peso.isEmpty() || altura.isEmpty())
    }
    fun calculo(peso: String, altura: String) {

        if (peso == "" ||altura == "") {
            mensaje.value = "DESCRIPCIÓN: El campo debe contener un valor."
        }else if (peso == "." ||altura == "."){
            mensaje.value = "DESCRIPCIÓN: El campo debe ser un número."
        }    else {

            this.IMC(peso.toDouble(),altura.toDouble())
            this.calculoIMC(peso.toDouble(),altura.toDouble())

        }
    }


}