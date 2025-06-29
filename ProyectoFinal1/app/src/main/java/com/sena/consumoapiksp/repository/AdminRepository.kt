package com.sena.consumoapiksp.repository

import com.sena.consumoapiksp.model.AdminLocal
import com.sena.consumoapiksp.model.dao.AdminDao

import javax.inject.Inject

class AdminRepository @Inject constructor(
    private val adminDao: AdminDao
) {
    suspend fun login(correo: String, contrasena: String): Pair<Boolean, String> {
        val localAdmin = adminDao.loginLocal(correo, contrasena)
        return if (localAdmin != null) {
            true to "Login exitoso (local)"
        } else {
            false to "Credenciales inválidas (local)"
        }
    }

    suspend fun insertarAdmin(correo: String, contrasena: String) {
        adminDao.insertar(AdminLocal(correo, contrasena))
    }
}

