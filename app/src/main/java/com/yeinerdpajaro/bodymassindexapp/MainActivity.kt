package com.yeinerdpajaro.bodymassindexapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.yeinerdpajaro.bodymassindexapp.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)


        mainBinding.calculateButton.setOnClickListener {
            val peso = mainBinding.weightInputEditText.text.toString().toDouble()
            val altura = mainBinding.heightTextInputEditText.text.toString().toDouble()
            val total = peso/(altura*altura)

            mainBinding.IMCTextView.setText("IMC: "+ String.format("%.3f",total))

            if(total > 0 && total <18.5) {

                mainBinding.descriptionTextView.text = "${getString(R.string.bajo_peso)}"

            }else if(total >= 18.5 && total <24.9) {

                mainBinding.descriptionTextView.text = "${getString(R.string.peso_normal)}"

            }else if(total >= 24.9 && total <29.9){

                mainBinding.descriptionTextView.text = "${getString(R.string.sobre_peso)}"

            }else if(total >= 29.9 && total <34.9){

                mainBinding.descriptionTextView.text = "${getString(R.string.obesidad_tipo_uno)}"
            }else if(total >= 34.9 && total <39.9){

                mainBinding.descriptionTextView.text = "${getString(R.string.obesidad_tipo_dos)}"
            }else if(total >= 39.9){

                mainBinding.descriptionTextView.text = "${getString(R.string.obesidad_tipo_tres)}"
            }




        }


        val view = mainBinding.root
        setContentView(view)
    }
}