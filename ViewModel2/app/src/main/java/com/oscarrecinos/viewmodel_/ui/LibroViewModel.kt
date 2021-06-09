package com.oscarrecinos.viewmodel_.ui

import android.app.usage.UsageEvents
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigation
import com.oscarrecinos.viewmodel_.R
import com.oscarrecinos.viewmodel_.ui.entidad.Libro
import com.oscarrecinos.viewmodel_.ui.repositorio.RepositorioLibros
import kotlinx.coroutines.launch

class LibroViewModel(private val repositorioLibros: RepositorioLibros) : ViewModel() {

    val Nombre = MutableLiveData("")
    val ISBN = MutableLiveData("")
    val Autor = MutableLiveData("")
    val Editorial = MutableLiveData("")
    val Anio = MutableLiveData("")
    var indice : Int = 0

    var repositorio = repositorioLibros.ObtenerLibros


    fun onSubmit(){
        viewModelScope.launch {
            repositorioLibros.AgregarLibro(
                Libro(
                    ISBN.value.toString().toInt(), Nombre.value!!,
                    Autor.value!!, Editorial.value!!, Anio.value.toString().toInt()
                )
            )
            Nombre.value = ""
            ISBN.value = ""
            Autor.value = ""
            Editorial.value = ""
            Anio.value = ""
            indice = 1
            repositorio = repositorioLibros.ObtenerLibros
        }
    }

}