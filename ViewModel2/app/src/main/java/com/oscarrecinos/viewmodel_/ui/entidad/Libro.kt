package com.oscarrecinos.viewmodel_.ui.entidad

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book_table")
data class Libro(
    @PrimaryKey
    val ISBN: Int,
    val Nombre: String,
    val Autor: String,
    val Editorial: String,
    val Anio: Int
)