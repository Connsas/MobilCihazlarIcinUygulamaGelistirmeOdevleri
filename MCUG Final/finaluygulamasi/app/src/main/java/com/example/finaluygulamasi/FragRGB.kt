package com.example.finaluygulamasi

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.graphics.blue
import androidx.core.graphics.red

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragRGB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragRGB : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_r_g_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var seekBarRed = view.findViewById<SeekBar>(R.id.seekBarRed)
        var seekBarGreen = view.findViewById<SeekBar>(R.id.seekBarGreen)
        var seekBarBlue = view.findViewById<SeekBar>(R.id.seekBarBlue)
        var textViewColorCode = view.findViewById<TextView>(R.id.textViewColorCode)
        var frameRGB = view.findViewById<FrameLayout>(R.id.frameRGB)
        var red = 0
        var green = 188
        var blue = 212


        seekBarRed.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                red = p1
                frameRGB.setBackgroundColor(Color.rgb(red,green,blue))
                textViewColorCode.setText(hexCode(red,green,blue))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        seekBarGreen.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                green = p1
                frameRGB.setBackgroundColor(Color.rgb(red,green,blue))
                textViewColorCode.setText(hexCode(red,green,blue))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        seekBarBlue.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                blue = p1
                frameRGB.setBackgroundColor(Color.rgb(red,green,blue))
                textViewColorCode.setText(hexCode(red,green,blue))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }

    fun hexCode (red : Int, green : Int, blue : Int) : String{
        var redHex = Integer.toHexString(red)
        var greenHex = Integer.toHexString(green)
        var blueHex = Integer.toHexString(blue)

        if(red < 16){
            redHex = Integer.toHexString(0) + redHex
        }
        if(green < 16){
            greenHex = Integer.toHexString(0) + greenHex
        }
        if(blue < 16){
            blueHex = Integer.toHexString(0) + blueHex
        }

        var colorCode = "#" + redHex + greenHex + blueHex

        return colorCode
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragRGB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragRGB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}