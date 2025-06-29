package com.sena.consumoapiksp.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EstudianteApi {
    @GET("proyectoFinal/Estudiante")
    suspend fun getAllEstudiantes(): List<Estudiante>

    @POST("proyectoFinal/RegistrarEstudiante")
    suspend fun createEstudiantes(@Body estudiante: Estudiante): Response<Estudiante>

    @DELETE("proyectoFinal/EliminarEstudiante/{id}")
    suspend fun deleteEstudiantes(@Path("id") id: Int)

    @PUT("proyectoFinal/ActualizarEstudiante/{id}")
    suspend fun updateEstudiantes(@Path("id") id: Int, @Body estudiante: Estudiante)

}