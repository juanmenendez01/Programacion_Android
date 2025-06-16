package com.example.consumoapilocal.consumo

import com.example.consumoapilocal.model.ApiResponse
import com.example.consumoapilocal.model.Usuario
import dagger.Module
import dagger.hilt.InstallIn
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("usuario")
    suspend fun getUsuario(): List<Usuario>

    @GET("usuario/find/{id}")
    suspend fun getUsuarioById(@Path("id") id: Int): Response<Usuario>

    @POST("usuario")
    suspend fun crearUsuario(@Body usuario: Usuario): Response<ApiResponse> //-> Cuando se retorne solo un JSON es necesario poner el Response<>

    @PUT("usuario/{id}")
    suspend fun actualizarUsuario(@Path("id") id: Int, @Body usuario: Usuario): Response<ApiResponse>

    @DELETE("usuaruo/{id}")
    suspend fun eliminarUsuario(@Path("id") id: Int): Response<ApiResponse>
}