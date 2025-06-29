package com.sena.consumoapiksp.di

import android.util.Log
import com.sena.consumoapiksp.model.AdminLocal
import com.sena.consumoapiksp.model.dao.AdminDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class AppDatabaseCallback @Inject constructor(
    private val adminDaoProvider: Provider<AdminDao>
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        Log.d("DB_CALLBACK", "onCreate ejecutado")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dao = adminDaoProvider.get()
                dao.insertar(
                    AdminLocal(
                        correo = "menendez@gmail.com",
                        contrasena = "admin123"
                    )
                )
                Log.d("DB_CALLBACK", "Admin insertado")
            } catch (e: Exception) {
                Log.e("DB_CALLBACK", "Error insertando admin", e)
            }
        }
    }
}
