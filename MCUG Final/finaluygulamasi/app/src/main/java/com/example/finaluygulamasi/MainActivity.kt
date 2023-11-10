package com.example.finaluygulamasi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gecis = false

        var seekBarMain = findViewById<SeekBar>(R.id.seekBarMain)
        var progressBarMain = findViewById<ProgressBar>(R.id.progressBarMain)

        seekBarMain.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p1 == 100) {
                    gecis = true
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
                seekBarMain.thumb.setTint(resources.getColor(R.color.yesil))
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                seekBarMain.thumb.setTint(resources.getColor(R.color.teal_700))
                if(seekBarMain.progress != 100 && !gecis){
                    seekBarMain.progress = 0
                }else if(gecis){
                    gecis = false
                    progressBarMain.visibility = View.VISIBLE
                    object: CountDownTimer(1000,1){
                        override fun onTick(p0: Long) {
                            seekBarMain.progress -= 3
                        }
                        override fun onFinish() {
                        }
                    }.start()
                    Handler().postDelayed({
                        var gecis = Intent(this@MainActivity, GirisSayfasi::class.java)
                        startActivity(gecis)
                        finish()
                    }, 1500)
                }
            }

        })



    }
}