package com.example.vizeuygulamasi

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var gidenIcerik = ""

        var buton = findViewById<Button>(R.id.buttonSiparis)

        var switchSarimsak = findViewById<Switch>(R.id.switchSarimsak)
        var switchNane = findViewById<Switch>(R.id.switchNane)
        var switchDil = findViewById<Switch>(R.id.switchDil)
        var switchTerbiye = findViewById<Switch>(R.id.switchTerbiye)
        var switchBeyin = findViewById<Switch>(R.id.switchBeyin)
        var switchSirke = findViewById<Switch>(R.id.switchSirke)
        var switchKrema = findViewById<Switch>(R.id.switchKrema)
        var switchYag = findViewById<Switch>(R.id.switchYag)
        var switchKasar = findViewById<Switch>(R.id.switchKasar)
        var switchKitir = findViewById<Switch>(R.id.switchKitir)
        var switchLimon = findViewById<Switch>(R.id.switchLimon)
        var switchTozbiber = findViewById<Switch>(R.id.switchTozbiber)

        var customerRequest = findViewById<EditText>(R.id.customerRequest)

        var gelenDeger = intent.getStringExtra("gidenDeger")
        var corbaIsmi = findViewById<TextView>(R.id.gorunenIsım)

        corbaIsmi.text = String.format("%s Çorbası",gelenDeger)

        var tuzOrani = findViewById<SeekBar>(R.id.tuzOrani)
        var aciOrani = findViewById<SeekBar>(R.id.aciOrani)

        var tuzOraniProgress = tuzOrani.progress
        var aciOraniProgress = aciOrani.progress
        var tuzDurumu = "Tuzsuz"
        var aciDurumu = "Acısız"

        tuzOrani.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tuzOraniProgress = p1

                if(tuzOraniProgress == 2){
                    tuzDurumu = "Bol Tuzlu"
                    var uyari = AlertDialog.Builder(this@MainActivity4)
                    uyari.setTitle("Uyarı!")
                    uyari.setMessage("Bu kadar tuz istediğinize emin misiniz ?")
                    uyari.setIcon(R.drawable.tuz)
                    uyari.setCancelable(false)

                    uyari.setPositiveButton("Evet"){DialogInterface, i->
                        Toast.makeText(applicationContext, (String.format("%s Çorba",tuzDurumu)),Toast.LENGTH_SHORT).show()
                    }
                    uyari.setNegativeButton("Hayir"){DialogInterface, i->
                        tuzOrani.progress = 1
                    }
                    uyari.create().show()
                }else if(tuzOraniProgress == 1){
                    tuzDurumu = "Tuzlu"
                }else{
                    tuzDurumu = "Tuzsuz"
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        aciOrani.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                aciOraniProgress = p1

                if(aciOraniProgress == 2){
                    aciDurumu = "Bol Acılı"
                    val uyari = AlertDialog.Builder(this@MainActivity4)
                    uyari.setTitle("Uyarı!")
                    uyari.setMessage("Bu kadar acı istediğinize emin misiniz ?")
                    uyari.setIcon(R.drawable.aci)
                    uyari.setCancelable(false)

                    uyari.setPositiveButton("Evet"){DialogInterface, i->
                        Toast.makeText(applicationContext, (String.format("%s Çorba",aciDurumu)),Toast.LENGTH_SHORT).show()
                    }
                    uyari.setNegativeButton("Hayir"){DialogInterface, i->
                        aciOrani.progress = 1
                    }
                    uyari.create().show()
                }else if(aciOraniProgress == 1){
                    aciDurumu = "Acılı"
                }else{
                    aciDurumu = "Acısız"
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        if(gelenDeger == "Ezogelin" || gelenDeger == "Düğün" || gelenDeger == "Mercimek"){
            switchNane.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchKitir.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "Mantar" || gelenDeger == "Brokoli"){
            switchKrema.visibility = View.VISIBLE
        }else if(gelenDeger == "Kelle-Paça"){
            switchSarimsak.visibility = View.VISIBLE
            switchBeyin.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
            switchDil.visibility = View.VISIBLE
            switchSirke.visibility = View.VISIBLE
        }else if(gelenDeger == "Yayla"){
            switchKitir.visibility = View.VISIBLE
            switchNane.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "Şehriye"){
            switchNane.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "Domates"){
            switchTerbiye.visibility = View.VISIBLE
            switchKitir.visibility = View.VISIBLE
            switchNane.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
            switchKasar.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "Tarhana"){
            switchYag.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "İşkembe"){
            switchSarimsak.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
            switchSirke.visibility = View.VISIBLE
            switchTozbiber.visibility = View.VISIBLE
        }else if(gelenDeger == "Tavuk"){
            switchKrema.visibility = View.VISIBLE
            switchYag.visibility = View.VISIBLE
            switchLimon.visibility = View.VISIBLE
        }

        buton.setOnClickListener(){
            val uyari = AlertDialog.Builder(this)
            uyari.setTitle("Siparişinizin Durumu")
            uyari.setMessage("Siparşiniz Hazırlanacak. Devam Etmek İstiyor musunuz?")
            uyari.setIcon(R.drawable.logo)
            uyari.setCancelable(false)

            uyari.setPositiveButton("Evet"){DialogInterface, i->
                Handler().post(){

                    if(switchSarimsak.isChecked){
                        gidenIcerik = gidenIcerik + "Sarımsak,"
                    }
                    if(switchTozbiber.isChecked){
                        gidenIcerik = gidenIcerik + "Toz Biber,"
                    }
                    if(switchLimon.isChecked){
                        gidenIcerik = gidenIcerik + "Limon,"
                    }
                    if(switchKitir.isChecked){
                        gidenIcerik = gidenIcerik + "Kıtır,"
                    }
                    if(switchKasar.isChecked){
                        gidenIcerik = gidenIcerik + "Kaşar,"
                    }
                    if(switchYag.isChecked){
                        gidenIcerik = gidenIcerik + "Yağ,"
                    }
                    if(switchKrema.isChecked){
                        gidenIcerik = gidenIcerik + "Krema,"
                    }
                    if(switchSirke.isChecked){
                        gidenIcerik = gidenIcerik + "Sirke,"
                    }
                    if(switchBeyin.isChecked){
                        gidenIcerik = gidenIcerik + "Beyin,"
                    }
                    if(switchTerbiye.isChecked){
                        gidenIcerik = gidenIcerik + "Terbiye,"
                    }
                    if(switchDil.isChecked){
                        gidenIcerik = gidenIcerik + "Dil,"
                    }
                    if(switchNane.isChecked){
                        gidenIcerik = gidenIcerik + "Nane,"
                    }

                    var gecis = Intent(this, MainActivity5::class.java)
                    gecis.putExtra("corbaIsmi",gelenDeger)
                    gecis.putExtra("gidenIcerik", gidenIcerik)
                    gecis.putExtra("gidenTuzAci", String.format("%s ve %s",tuzDurumu,aciDurumu))
                    gecis.putExtra("gidenIstek",customerRequest.text.toString())
                    startActivity(gecis)
                    finish()
                }
            }
            uyari.setNegativeButton("Tekrar Kontrol Etmek İstiyorum"){DialogInterface, i->

            }
            uyari.create().show()
        }

    }
}