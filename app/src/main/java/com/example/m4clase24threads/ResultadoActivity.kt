package com.example.m4clase24threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var txtTextView2 = findViewById<View>(R.id.textView2) as TextView
        txtTextView2.setText(intent.getStringExtra("usuario").toString())
    }
}