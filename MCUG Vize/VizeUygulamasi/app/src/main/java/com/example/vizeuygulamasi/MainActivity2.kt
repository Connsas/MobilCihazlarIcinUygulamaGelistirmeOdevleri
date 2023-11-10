package com.example.vizeuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var harf1 = findViewById<TextView>(R.id.harf1)
        var harf2 = findViewById<TextView>(R.id.harf2)
        var harf3 = findViewById<TextView>(R.id.harf3)
        var harf4 = findViewById<TextView>(R.id.harf4)
        var harf5 = findViewById<TextView>(R.id.harf5)
        var harf6 = findViewById<TextView>(R.id.harf6)

        var tik1 = findViewById<ImageView>(R.id.tik1)
        var tik2 = findViewById<ImageView>(R.id.tik2)
        var tik3 = findViewById<ImageView>(R.id.tik3)
        var tik4 = findViewById<ImageView>(R.id.tik4)
        var tik5 = findViewById<ImageView>(R.id.tik5)
        var tik6 = findViewById<ImageView>(R.id.tik6)

        var progressBar = findViewById<ProgressBar>(R.id.progressBar)

        harf1.setOnClickListener{
            tik1.visibility = View.VISIBLE
        }

        harf2.setOnClickListener{
            if (tik1.isVisible) {
                tik2.visibility = View.VISIBLE
            }
        }

        harf3.setOnClickListener{
            if (tik2.isVisible) {
                tik3.visibility = View.VISIBLE
            }
        }

        harf4.setOnClickListener{
            if (tik3.isVisible) {
                tik4.visibility = View.VISIBLE
            }
        }

        harf5.setOnClickListener{
            if (tik4.isVisible) {
                tik5.visibility = View.VISIBLE
            }
        }

        harf6.setOnClickListener{
            if (tik5.isVisible) {
                tik6.visibility = View.VISIBLE
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                    var gecis = Intent(this, MainActivity3::class.java)
                    startActivity(gecis)
                    finish()
                },2000)
            }

        }

    }
}