package com.sena.consumoapiksp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sena.consumoapiksp.model.AdminLocal

@Dao
interface AdminDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(admin: AdminLocal)

    @Query("SELECT * FROM admin WHERE correo = :correo AND contrasena = :contrasena LIMIT 1")
    suspend fun loginLocal(correo: String, contrasena: String): AdminLocal?

    @Query("SELECT * FROM admin")
    suspend fun getAll(): List<AdminLocal>
}