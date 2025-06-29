package com.sena.consumoapiksp.di

import com.sena.consumoapiksp.remote.AdminApi
import com.sena.consumoapiksp.remote.EstudianteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl(): String = "http://10.0.2.2:7096/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAdminApi(retrofit: Retrofit): AdminApi {
        return retrofit.create(AdminApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEstudianteApi(retrofit: Retrofit): EstudianteApi {
        return retrofit.create(EstudianteApi::class.java)
    }
}

