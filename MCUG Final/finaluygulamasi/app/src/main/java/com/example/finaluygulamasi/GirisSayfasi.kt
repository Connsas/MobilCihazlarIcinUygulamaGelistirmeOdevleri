package com.example.finaluygulamasi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.Toast

val dosyaYolu = "com.example.finaluygulamasi"
var anahtarIsim = "editTextUserNameGiris"
var anahtarSifre = "editTextPasswordGiris"
var switchState = "progressBarGirisSayfasi"

class GirisSayfasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_sayfasi)

        val isim = "Ismail Oner"
        val sifre = "02200201041"

        var preferences = getSharedPreferences(dosyaYolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        var editTextUserNameGiris = findViewById<EditText>(R.id.editTextUserNameGiris)
        var editTextPasswordGiris = findViewById<EditText>(R.id.editTextPasswordGiris)
        var switchBeniHatirla = findViewById<Switch>(R.id.switchBeniHatirla)
        var progressBarGirisSayfasi = findViewById<ProgressBar>(R.id.progressBarGirisSayfasi)

        if(preferences.getString(anahtarIsim,"Değer yok") == isim){
            editTextUserNameGiris.setText(preferences.getString(anahtarIsim,"Değer yok"))
            editTextPasswordGiris.setText(preferences.getString(anahtarSifre,"Değer yok"))
            switchBeniHatirla.isChecked = preferences.getBoolean(switchState, false)
            progressBarGirisSayfasi.visibility = View.VISIBLE
        }

        Toast.makeText(applicationContext,"Kaydedilmiş\n" + "İsim :${preferences.getString(anahtarIsim,"Değer yok")} \n" + "Şifre : ${preferences.getString(
            anahtarSifre,"Değer yok")} \n" + "Unutma : ${preferences.getBoolean(switchState,false)}",Toast.LENGTH_SHORT).show()

        if(editTextPasswordGiris.text.toString() == sifre && editTextUserNameGiris.text.toString() == isim){
            Handler().postDelayed({
                var gecis = Intent(this@GirisSayfasi, MenuEkrani::class.java)
                startActivity(gecis)
                finish()
            }, 1500)
        }

        editTextPasswordGiris.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (editTextUserNameGiris.text != null && editTextUserNameGiris.text.toString() == isim){
                    if(editTextPasswordGiris.text.toString() == sifre){
                        if(switchBeniHatirla.isChecked){
                            editor.putString(anahtarIsim,editTextUserNameGiris.text.toString())
                            editor.putString(anahtarSifre,editTextPasswordGiris.text.toString())
                            editor.putBoolean(switchState,switchBeniHatirla.isChecked)
                            editor.apply()
                        }
                            progressBarGirisSayfasi.visibility = View.VISIBLE
                            Handler().postDelayed({
                                var gecis = Intent(this@GirisSayfasi, MenuEkrani::class.java)
                                startActivity(gecis)
                                finish()
                            }, 1500)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        editTextUserNameGiris.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (editTextPasswordGiris.text != null && editTextPasswordGiris.text.toString() == sifre){
                    if(editTextUserNameGiris.text.toString() == isim){
                        if(switchBeniHatirla.isChecked){
                            editor.putString(anahtarIsim,editTextUserNameGiris.text.toString())
                            editor.putString(anahtarSifre,editTextPasswordGiris.text.toString())
                            editor.putBoolean(switchState,switchBeniHatirla.isChecked)
                            editor.apply()
                        }
                            progressBarGirisSayfasi.visibility = View.VISIBLE
                            Handler().postDelayed({
                                var gecis = Intent(this@GirisSayfasi, MenuEkrani::class.java)
                                startActivity(gecis)
                                finish()
                            }, 1500)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

    }
}