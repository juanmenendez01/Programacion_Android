package com.sena.entregable_3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cliente::class, Notas::class], version = 1)//, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun notasDao(): NotasDao

    companion object{
        @Volatile // el elemento puede cambiar mediante configuraciones
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            // se sincroniza la base de datos con ToDoDao
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cliente_notas_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}