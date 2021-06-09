package com.oscarrecinos.viewmodel_.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oscarrecinos.viewmodel_.R

class FragmentListBook : Fragment() {
    val libroAdapter = LibroAdapter()

    private val LibroViewModel : LibroViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_book, container, false)

        view.findViewById<RecyclerView>(R.id.ListaLibrosRV).apply {
            adapter = libroAdapter
            layoutManager = LinearLayoutManager(this@FragmentListBook.context)
        }

        LibroViewModel.repositorio.observe(viewLifecycleOwner){
            libroAdapter.setData(it)
        }

        return view

    }

}