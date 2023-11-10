package com.example.vizeuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var checkBox = findViewById<CheckBox>(R.id.corba)

        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        var dugme = findViewById<Button>(R.id.buttonDevam)

        checkBox.setOnClickListener{
            if(!checkBox.isChecked){
                radioGroup.visibility = View.INVISIBLE
                dugme.visibility = View.INVISIBLE
            }else {
                radioGroup.visibility = View.VISIBLE
                dugme.visibility = View.VISIBLE
            }
        }

        dugme.setOnClickListener{

            val id = radioGroup.checkedRadioButtonId
            if(id != -1) {
                val checkedRadioButtonText = findViewById<RadioButton>(id).text

                var tasarim = layoutInflater.inflate(R.layout.toast, null)
                var toastText = tasarim.findViewById<TextView>(R.id.toastText)
                toastText.text = String.format(
                    "%s Çorbası Güzel Seçim Lüftfen Bekleyiniz",
                    checkedRadioButtonText
                )
                var toast = Toast(applicationContext)
                toast.view = tasarim
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.duration = Toast.LENGTH_SHORT
                toast.show()

                Handler().postDelayed({
                    var gecis = Intent(this, MainActivity4::class.java)
                    gecis.putExtra("gidenDeger", checkedRadioButtonText)
                    startActivity(gecis)
                    finish()
                }, 2200)
            }else{
                val uyari = AlertDialog.Builder(this)
                uyari.setTitle("Uyarı!")
                uyari.setMessage("Lüftfen Seçiminizi Yapınız")
                uyari.setIcon(R.drawable.logo)
                uyari.setCancelable(false)

                uyari.setNegativeButton("Tekrar Dene"){DialogInterface, i->

                }
                uyari.create().show()
            }
        }


    }
}