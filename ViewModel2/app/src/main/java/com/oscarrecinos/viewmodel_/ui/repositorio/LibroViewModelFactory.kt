package com.oscarrecinos.viewmodel_.ui.repositorio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscarrecinos.viewmodel_.ui.LibroViewModel
import java.lang.Exception

class LibroViewModelFactory(private val repositorioLibros: RepositorioLibros) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LibroViewModel::class.java)){
            return LibroViewModel(repositorioLibros) as T
        }

        throw Exception("Unknown view model class")
    }
}