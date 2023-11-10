package com.example.vizeuygulamasi

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var i = 0

        var gelenTuzAci = intent.getStringExtra("gidenTuzAci")
        var gelenIcerik = intent.getStringExtra("gidenIcerik")
        var gelenIstek = intent.getStringExtra("gidenIstek")
        var corbaIsmi = intent.getStringExtra("corbaIsmi")

        println(String.format("ben geldim %s",gelenIcerik))

        var textTuzAci = findViewById<TextView>(R.id.textTuzAci)
        var textIcerik = findViewById<TextView>(R.id.textIcerik)
        var textEkstra = findViewById<TextView>(R.id.textEkstra)
        var textUst = findViewById<TextView>(R.id.textUst)
        var textAlt = findViewById<TextView>(R.id.textAlt)
        var textYeniSiparis = findViewById<TextView>(R.id.textYeniSiparis)
        var imageButtonCikis = findViewById<ImageButton>(R.id.imageButtonCikis)

        textTuzAci.text = String.format("Bir %s Çorbası Çeeek, %s Olsun", corbaIsmi, gelenTuzAci)

        if(gelenIcerik != ""){
            textUst.visibility = View.VISIBLE
            textAlt.visibility = View.VISIBLE
            textIcerik.visibility = View.VISIBLE
            textIcerik.text = gelenIcerik
        }

        if(gelenIstek != "") {
            textEkstra.visibility = View.VISIBLE
            textEkstra.text = String.format("Ekstra İstek : %s", gelenIstek)
        }

        object: CountDownTimer(10000,500){
            override fun onTick(p0: Long) {
                i++
                if(i%2 == 0){
                    textYeniSiparis.setTextColor(Color.WHITE)
                }else{
                    textYeniSiparis.setTextColor(Color.BLACK)
                }

            }

            override fun onFinish() {
            }

        }.start()

        textYeniSiparis.setOnClickListener(){
            Handler().post(){
                var gecis = Intent(this, MainActivity3::class.java)
                startActivity(gecis)
                finish()
            }
        }
        imageButtonCikis.setOnClickListener(){
            val uyari = AlertDialog.Builder(this)
            uyari.setTitle("Çıkış")
            uyari.setMessage("Çıkmak İstediğinize Emin misiniz?")
            uyari.setIcon(R.drawable.red_x)
            uyari.setCancelable(false)

            uyari.setNegativeButton("Hayır"){DialogInterface, i->

            }
            uyari.setPositiveButton("Evet"){DialogInterface, i->
                finish()
            }

            uyari.create().show()
        }
    }
}