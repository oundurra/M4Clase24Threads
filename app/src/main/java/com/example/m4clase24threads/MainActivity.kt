package com.example.m4clase24threads

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var btnEntrar: Button? = null
    var etUsuario: EditText? = null
    var etPassword:EditText? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar = findViewById<View>(R.id.btnEntrar) as Button
        etUsuario = findViewById<View>(R.id.etUsuario) as EditText
        etPassword = findViewById<View>(R.id.etPassword) as EditText
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        progressBar!!.visibility = View.INVISIBLE

        btnEntrar!!.setOnClickListener() {
                val task1 = Task1()
                task1.execute(etUsuario?.getText().toString())
        }
    }

    internal inner class Task1: AsyncTask<String?, Void?, String?>() {
        override fun onPreExecute() {
            progressBar?.setVisibility(View.VISIBLE)
            btnEntrar?.setEnabled(false)
        }

        override fun doInBackground(vararg strings: String?): String? {
            try {
                Thread.sleep(15000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return strings[0]
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(s: String?) {
            progressBar?.setVisibility(View.VISIBLE)
            btnEntrar?.isEnabled = true
            val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
            intent.putExtra("usuario", etUsuario?.getText().toString())
            startActivity(intent)
        }
    }

}





