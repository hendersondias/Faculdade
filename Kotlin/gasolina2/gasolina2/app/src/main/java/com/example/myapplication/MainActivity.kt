package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.onClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcula.setOnClickListener(this)
    }

    override fun onClick(view: View){
        if (view.id == R.id.button_calcula){
            btCalcula()
        }
    }

    private fun btCalcula(){
        try {
            val distancia = binding.editDistancia.text.toString().toInt()
            val preco = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomia.text.toString().toFloat()

            val gasto = distancia / autonomia * preco

            binding.viewGasto.text = String.format( "R$ %.2f", gasto )
        }
        catch (e:Exception){
            Toast.makeText(this,"Favor informar todos os valores!", Toast.LENGHT_SHORT).show()
        }
    }
}