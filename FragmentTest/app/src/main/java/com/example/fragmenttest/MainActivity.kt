package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
    Fragment1.OnFragmentInteractionListener{

    lateinit var fragment2 :FragmentDos

    override fun onFragmentInteraction(text: String) {
        fragment2.getData(text)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment2 = FragmentDos.getFragmentFactory()
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, fragment2)
            .commit()


    }
}
