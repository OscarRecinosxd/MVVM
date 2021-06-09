package com.oscarrecinos.viewmodel_.ui.repositorio

import android.app.Application

class LibroApplication: Application() {

    private val database by lazy {
        BaseDeDatosLibro.getDatabase(this)
    }

    val LibrosRepositorio by lazy{
        val libroDao = database.libroDao()
        RepositorioLibros(libroDao)
    }



}