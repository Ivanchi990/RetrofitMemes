package com.example.apimemes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apimemes.actividadesapi.*
import com.example.apimemes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //https://damemeapi.000webhostapp.com/doc/?#

        binding.getMemeId.setOnClickListener{
            showMemeId()
        }

        binding.getMemes.setOnClickListener{
            showMemes()
        }


        binding.postMeme.setOnClickListener{
            showCreateMeme()
        }

        binding.editMeme.setOnClickListener{
            showEditMeme()
        }

        binding.getTags.setOnClickListener{
            showTags()
        }

        binding.postTag.setOnClickListener {
            showCreateTag()
        }

        binding.foabEliminar.setOnClickListener{
            showEliminarMeme()
        }

        setContentView(binding.root)
    }

    fun showMemeId()
    {
        intent = Intent(this, ActivityPedirId::class.java)

        startActivity(intent)
    }


    fun showMemes()
    {
        intent = Intent(this, ActivityMostrarMemes::class.java)

        startActivity(intent)
    }


    fun showCreateMeme()
    {
        intent = Intent(this, ActivityCrearMeme::class.java)

        startActivity(intent)
    }


    fun showEditMeme()
    {
        intent = Intent(this, ActivityEditarMeme::class.java)

        startActivity(intent)
    }


    fun showTags()
    {
        intent = Intent(this, ActivityMostrarTags::class.java)

        startActivity(intent)
    }


    fun showCreateTag()
    {
        intent = Intent(this, ActivityCrearTag::class.java)

        startActivity(intent)
    }


    fun showEliminarMeme()
    {
        intent = Intent(this, EliminarMemeId::class.java)

        startActivity(intent)
    }
}