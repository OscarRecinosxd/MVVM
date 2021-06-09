package com.oscarrecinos.viewmodel_.ui.repositorio

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscarrecinos.viewmodel_.ui.dao.LibroDao
import com.oscarrecinos.viewmodel_.ui.entidad.Libro


@Database(entities = [Libro::class],version = 1,exportSchema = false)
abstract class BaseDeDatosLibro : RoomDatabase(){

    abstract fun libroDao(): LibroDao


    companion object {
        @Volatile
        private var INSTANCE: BaseDeDatosLibro? = null

        fun getDatabase(context: Context): BaseDeDatosLibro{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatosLibro::class.java,
                    "libro_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}