package com.example.consumoapilocal.repository

import com.example.consumoapilocal.consumo.ApiService
import com.example.consumoapilocal.model.ApiResponse
import com.example.consumoapilocal.model.Usuario
import retrofit2.Response
import javax.inject.Inject

class UsuarioRepository @Inject constructor(private val apiService: ApiService) {
    private val service: ApiService = apiService

    suspend fun getUsuarios(): List<Usuario> {
        return service.getUsuario()
    }

    suspend fun getUsuarioPorId(id: Int): Response<Usuario> {
        return service.getUsuarioById(id);
    }

    // ...
}