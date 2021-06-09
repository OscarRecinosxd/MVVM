package com.oscarrecinos.viewmodel_.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.oscarrecinos.viewmodel_.R
import com.oscarrecinos.viewmodel_.databinding.FragmentFormBookBinding
import com.oscarrecinos.viewmodel_.databinding.FragmentFormBookBindingImpl
import com.oscarrecinos.viewmodel_.ui.repositorio.LibroApplication
import com.oscarrecinos.viewmodel_.ui.repositorio.LibroViewModelFactory


class FragmentFormBook : Fragment() {
    private var _binding : FragmentFormBookBinding ?= null
    private val binding get() = _binding!!
    private lateinit var  boton : Button
    private var binding2 :FragmentFormBookBindingImpl?=null


    val dictApp by lazy {
        activity?.applicationContext as LibroApplication
    }
    private val libroViewModelFactory : LibroViewModelFactory by lazy {
        LibroViewModelFactory(dictApp.LibrosRepositorio)
    }
    private val agregarlibroviewmodel : LibroViewModel by activityViewModels{
        libroViewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = this.activity?.let { DataBindingUtil.setContentView(it, R.layout.fragment_form_book) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormBookBinding.inflate(inflater,container,false)
            .apply {
                viewmodel = agregarlibroviewmodel
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aniadirPregunta : Button = view.findViewById(R.id.AgregarLibro)

        aniadirPregunta.setOnClickListener {
            if(!agregarlibroviewmodel.Editorial.value.isNullOrEmpty() && !agregarlibroviewmodel.Autor.value.isNullOrEmpty()
                    &&!agregarlibroviewmodel.Nombre.value.isNullOrEmpty() && !agregarlibroviewmodel.Anio.value.isNullOrEmpty()
                    &&!agregarlibroviewmodel.ISBN.value.isNullOrEmpty())
            {
                agregarlibroviewmodel.onSubmit()
                view.findNavController().navigate(R.id.ListBookFragment)
            }
        }



    }

}