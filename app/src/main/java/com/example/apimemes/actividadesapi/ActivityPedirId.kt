package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.example.apimemes.databinding.ActivityPedirIdBinding

class ActivityPedirId : AppCompatActivity()
{
    lateinit var binding: ActivityPedirIdBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPedirIdBinding.inflate(layoutInflater)

        binding.textId.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER)
            {
                enviarId()
                true
            }
            false
        })

        binding.buscarId.setOnClickListener{
            enviarId()
        }

        setContentView(binding.root)
    }

    fun enviarId()
    {
        val id = binding.textId.text

        if(id == null || id.equals(""))
        {
            Toast.makeText(this, "Necesito que escribas una id para poder mostrar el meme", Toast.LENGTH_LONG).show()
        }
        else
        {
            intent = Intent(this, ActivityMostrarMemeId::class.java).apply {
                putExtra("id", id.toString())
            }

            startActivity(intent)
        }
    }
}