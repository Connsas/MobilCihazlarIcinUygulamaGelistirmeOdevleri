package com.example.finaluygulamasi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import java.util.zip.Inflater


class MenuEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_ekrani)

        var butonPopupMenu = findViewById<Button>(R.id.buttonPopupMenu)

        butonPopupMenu.setOnClickListener(){
            val popup = PopupMenu(this,butonPopupMenu)
            popup.menuInflater.inflate(R.menu.popupmenu,popup.menu)
            popup.setOnMenuItemClickListener { i->
                when(i.itemId){
                    R.id.menuItemRGB -> {
                        fragmentCagir(FragRGB())
                        true
                    }
                    R.id.menutItemSnackBar -> {
                        fragmentCagir(FragSnackBar())
                        true
                    }
                    R.id.menuItemLogOut -> {
                        val tasarim = LayoutInflater.from(this).inflate(R.layout.cikis_alert,null)
                        val ad = AlertDialog.Builder(this)
                        ad.setView(tasarim)
                        ad.create().show()
                        var preferences = getSharedPreferences(dosyaYolu, Context.MODE_PRIVATE)
                        var editor = preferences.edit()
                        val kullaniciIsim = tasarim.findViewById<EditText>(R.id.editTextUserNameLogout)
                        val kullaniciSifre = tasarim.findViewById<EditText>(R.id.editTextPasswordLogout)
                        val progressBarLogOut = tasarim.findViewById<ProgressBar>(R.id.progressBarLogout)
                        val isim = preferences.getString(anahtarIsim,"Değer yok")
                        val sifre = preferences.getString(anahtarSifre,"Değer yok")
                        alertDialog(kullaniciIsim,kullaniciSifre,progressBarLogOut,isim,sifre,editor)
                        true

                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    fun fragmentCagir(cagrilanFragment: Fragment){
        var gecis = supportFragmentManager.beginTransaction()
        gecis.replace(R.id.fragmentContainerView8,cagrilanFragment)
        gecis.commit()
    }

    fun alertDialog (kullaniciIsim : EditText, kullaniciSifre : EditText, progressBarLogOut : ProgressBar, isim : String?, sifre : String?,editor : SharedPreferences.Editor){
        kullaniciSifre.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                if (kullaniciIsim.text != null && kullaniciIsim.text.toString() == isim){
                    if(kullaniciSifre.text.toString() == sifre){
                        editor.remove(anahtarIsim)
                        editor.remove(anahtarSifre)
                        editor.remove(switchState)
                        editor.apply()
                        progressBarLogOut.visibility = View.VISIBLE
                        Handler().postDelayed({
                            var gecis = Intent(this@MenuEkrani, GirisSayfasi::class.java)
                            startActivity(gecis)
                            finish()
                        }, 1500)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        kullaniciIsim.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                if (kullaniciSifre.text != null && kullaniciSifre.text.toString() == sifre){
                    if(kullaniciIsim.text.toString() == isim){
                        editor.remove(anahtarIsim)
                        editor.remove(anahtarSifre)
                        editor.remove(switchState)
                        editor.apply()
                        progressBarLogOut.visibility = View.VISIBLE
                        Handler().postDelayed({
                            var gecis = Intent(this@MenuEkrani, GirisSayfasi::class.java)
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

