package com.oscarrecinos.viewmodel_.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oscarrecinos.viewmodel_.R
import com.oscarrecinos.viewmodel_.ui.entidad.Libro

class LibroAdapter : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    private var Libro : List<Libro>? = null

    class LibroViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(libro : Libro){
            itemView.apply {
                findViewById<TextView>(R.id.NombreLibroList).text = libro.Nombre
                findViewById<TextView>(R.id.ISBNLibroList).text = libro.ISBN.toString()
                findViewById<TextView>(R.id.AutorLibroList).text = libro.Autor
                findViewById<TextView>(R.id.EditorialLibroList).text = libro.Editorial
                findViewById<TextView>(R.id.AnioLibroList).text = libro.Anio.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val card = LayoutInflater.from(parent.context)
                .inflate(R.layout.libro_carta,parent,false)

        return  LibroViewHolder(card)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        Libro?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = Libro?.size ?: 0


    fun setData(libros : List<Libro>){
        Libro = libros
        notifyDataSetChanged()
    }

}