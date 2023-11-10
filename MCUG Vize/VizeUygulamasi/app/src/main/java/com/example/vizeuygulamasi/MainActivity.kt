package com.example.vizeuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.graphics.rotationMatrix

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textCorbaci = findViewById<TextView>(R.id.textView2)
        var i = 0

        object: CountDownTimer(750,30){
            override fun onTick(p0: Long) {
                i+=2
                textCorbaci.textSize = i.toFloat()
            }

            override fun onFinish() {
            }

        }.start()

        Handler().postDelayed({
            var gecis = Intent(this,MainActivity2::class.java)
            startActivity(gecis)
            finish()
        },3000)
    }
}