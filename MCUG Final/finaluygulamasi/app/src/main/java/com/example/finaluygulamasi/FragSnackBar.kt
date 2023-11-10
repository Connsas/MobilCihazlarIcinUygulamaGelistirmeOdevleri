package com.example.finaluygulamasi

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragSnackBar.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragSnackBar : Fragment() {
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
        var fragSnackBar = inflater.inflate(R.layout.fragment_frag_snack_bar, container, false)

        //var fragSnackBar = layoutInflater.inflate(R.layout.fragment_frag_snack_bar,null)
        var editTextMessage = fragSnackBar.findViewById<EditText>(R.id.editTextMessage)
        var editTextAction = fragSnackBar.findViewById<EditText>(R.id.editTextAction)
        var spinnerSnack = fragSnackBar.findViewById<Spinner>(R.id.spinnerSnack)
        var spinnerSure = resources.getStringArray(R.array.Sure)

        if(spinnerSnack != null){
            var adapter = ArrayAdapter(fragSnackBar.context,android.R.layout.simple_spinner_item,spinnerSure)
            spinnerSnack.adapter = adapter
        }

        spinnerSnack.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 1){
                    Snackbar.make(fragSnackBar, editTextMessage.text,2000).setAction(editTextAction.text){
                        Toast.makeText(fragSnackBar.context, editTextAction.text,Toast.LENGTH_SHORT).show()}.show()
                }else if(p2 == 2){
                    Snackbar.make(fragSnackBar, editTextMessage.text.toString(),2500).setAction(editTextAction.text.toString()){
                        Toast.makeText(fragSnackBar.context, editTextAction.text.toString(),Toast.LENGTH_SHORT).show()}.show()
                }else if(p2 == 3){
                    Snackbar.make(fragSnackBar, editTextMessage.text.toString(),3000).setAction(editTextAction.text.toString()){
                        Toast.makeText(fragSnackBar.context, editTextAction.text.toString(),Toast.LENGTH_SHORT).show()}.show()
                }else if(p2 == 4){
                    Snackbar.make(fragSnackBar, editTextMessage.text.toString(),3500).setAction(editTextAction.text.toString()){
                        Toast.makeText(fragSnackBar.context, editTextAction.text.toString(),Toast.LENGTH_SHORT).show()}.show()
                }else if(p2 == 5){
                    Snackbar.make(fragSnackBar, editTextMessage.text.toString(),4000).setAction(editTextAction.text.toString()){
                        Toast.makeText(fragSnackBar.context, editTextAction.text.toString(),Toast.LENGTH_SHORT).show()}.show()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        return fragSnackBar

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragSnackBar.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragSnackBar().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}