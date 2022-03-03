package com.example.apis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apis.databinding.DatosEspecificosBinding

class DatosEspecificos: AppCompatActivity()  {

    private lateinit var binding: DatosEspecificosBinding

    companion object {
        const val TAG_TEXT = "TAG_TEXT"

        fun launch(context:Context, text: String) {
            val intent = Intent(context, DatosEspecificos::class.java)
            intent.putExtra(TAG_TEXT, text)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DatosEspecificosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initialData = intent.getStringExtra(TAG_TEXT)

        binding.bDescargar.setOnClickListener {
            Toast.makeText(this, "$initialData", Toast.LENGTH_SHORT).show()
        }
    }
}