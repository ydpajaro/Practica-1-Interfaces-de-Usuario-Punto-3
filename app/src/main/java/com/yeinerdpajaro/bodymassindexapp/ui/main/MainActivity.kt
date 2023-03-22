package com.yeinerdpajaro.bodymassindexapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yeinerdpajaro.bodymassindexapp.R
import com.yeinerdpajaro.bodymassindexapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.setContext(this)

        val calculoIMCObserver = Observer<String>{ calcularIMC->

            mainBinding.descriptionTextView.text = calcularIMC.toString()
        }
        mainViewModel.calcularIMC.observe(this,calculoIMCObserver)

        val valorIMCObserver = Observer<Double>{valorIMC->
            mainBinding.IMCTextView.text = "${getString(R.string.Total)} ${String.format("%.2f", valorIMC.toDouble())}"

        }
        mainViewModel.valorIMC.observe(this,valorIMCObserver)



        mainBinding.calculateButton.setOnClickListener {

           if(mainBinding.weightInputEditText.text.toString().contains(".")){
                Toast.makeText(getApplicationContext(), "No se permiten puntos ni comas", Toast.LENGTH_SHORT).show()

            }
            else if( mainBinding.heightTextInputEditText.text.toString().contains(".") ){
                Toast.makeText(this, "Por favor, ingrese ambos campos", Toast.LENGTH_SHORT).show()
            }else if(mainViewModel.realizarValidateNulls(mainBinding.weightInputEditText.text.toString(),mainBinding.heightTextInputEditText.text.toString())){

            mainViewModel.IMC(mainBinding.weightInputEditText.text.toString().toDouble(),mainBinding.heightTextInputEditText.text.toString().toDouble())

            mainViewModel.calculoIMC(mainBinding.weightInputEditText.text.toString().toDouble(),mainBinding.heightTextInputEditText.text.toString().toDouble())

            }

            else {
                Toast.makeText(this, "Por favor, ingrese ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        val view = mainBinding.root
        setContentView(view)

}
}