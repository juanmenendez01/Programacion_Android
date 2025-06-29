package com.sena.consumoapiksp.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AdminApi {
    @POST("proyectoFinal/Administrador")
    suspend fun login(@Body admin: Admin): Response<Admin>
}