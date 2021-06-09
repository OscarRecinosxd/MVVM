package com.oscarrecinos.viewmodel_.ui.repositorio

import androidx.lifecycle.LiveData
import com.oscarrecinos.viewmodel_.ui.dao.LibroDao
import com.oscarrecinos.viewmodel_.ui.entidad.Libro

class RepositorioLibros(private val libroDao : LibroDao) {

    val ObtenerLibros : LiveData<List<Libro>> =  libroDao.ObtenerLibros()


    suspend fun AgregarLibro(libro:Libro){
        libroDao.AgregarLibro(libro)
    }


}