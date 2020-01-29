package com.example.fragmenttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment2_layout.*

class FragmentDos : Fragment() {
    private lateinit var tvData : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
//        val view =  inflater.inflate(
//            R.layout.fragment2_layout,
//            container,
//            false
//        )
        return inflater.inflate(
            R.layout.fragment2_layout,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvData =activity!!.findViewById(R.id.displayIncomingText)
    }

    fun getData(text: String) {
        tvData.text = text
    }
    companion object{
        const val  TAG = "FragmentDos"

        fun getFragmentFactory() : FragmentDos{
            val fragmentDos = FragmentDos()
            return fragmentDos
        }
    }


}