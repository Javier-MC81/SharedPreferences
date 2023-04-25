package com.jmoreno.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val numRandom = Random.nextInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFromPreferences()

    }

    private fun loadFromPreferences() {
        //val shared = getPreferences(Context.MODE_PRIVATE)
        //val numOld = shared.getInt("MiInteger", 0)

        //Revisar: let, apply, with, run
        getPreferences(Context.MODE_PRIVATE).apply {
            Log.w("tag", "${getInt("MiInteger", 0)}")
        }

    }

    override fun onStop() {
        saveFromPreferences()
        super.onStop()

    }
    private fun saveFromPreferences() {
        // val shared = getPreferences(Context.MODE_PRIVATE)
        // val sharedPreferencesEditable = shared.edit()
        // sharedPreferencesEditable.putInt("MiInteger",numRandom)
        // sharedPreferencesEditable.apply()

        getPreferences(Context.MODE_PRIVATE).edit().apply {
            putInt("MiInteger",numRandom)
            apply()
        }

    }

}