package com.yeinerdpajaro.bodymassindexapp.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yeinerdpajaro.bodymassindexapp.R

class MainViewModel : ViewModel(){

    private var contex: Context? = null

    fun setContext(contex: Context){
        this.contex = contex
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

            calcularIMC.value = contex?.getString(R.string.bajo_peso)

        }else if(total >= 18.5 && total <24.9) {

            calcularIMC.value = contex?.getString(R.string.peso_normal)

        }else if(total >= 24.9 && total <29.9){

            calcularIMC.value = contex?.getString(R.string.sobre_peso)

        }else if(total >= 29.9 && total <34.9){

            calcularIMC.value = contex?.getString(R.string.obesidad_tipo_uno)
        }else if(total >= 34.9 && total <39.9){

            calcularIMC.value = contex?.getString(R.string.obesidad_tipo_dos)
        }else if(total >= 39.9){

            calcularIMC.value = contex?.getString(R.string.obesidad_tipo_tres)
        }

    }

    fun realizarValidateNulls(peso: String, altura: String): Boolean {
        return !(peso.isEmpty() || altura.isEmpty())
    }

}