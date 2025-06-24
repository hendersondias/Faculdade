package com.example.p2_hdms2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.p2_hdms2.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0973231.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_0973231){
            btCalcula()
        }
    }

    fun btCalcula(){
        try{
            val distancia = binding.editHdms.text.toString().toFloat()
            val milhas = distancia / 1.609

            binding.viewMilhas.text = String.format("$.2f", milhas)
        }
        catch (e:Exception){
            Toast.makeText(this, "Favor informar o valor!", Toast.LENGTH_SHORT).show()

        }        }


}