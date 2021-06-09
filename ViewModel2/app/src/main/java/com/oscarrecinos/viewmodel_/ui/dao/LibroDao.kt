package com.oscarrecinos.viewmodel_.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarrecinos.viewmodel_.ui.entidad.Libro


@Dao
interface LibroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun AgregarLibro(libro: Libro)


    @Query("SELECT *FROM book_table ORDER BY ISBN ASC")
    fun ObtenerLibros() : LiveData<List<Libro>>

}