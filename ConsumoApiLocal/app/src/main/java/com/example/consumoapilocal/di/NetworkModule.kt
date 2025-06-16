package com.example.consumoapilocal.di

import com.example.consumoapilocal.consumo.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL_BASE = "http://10.0.2.2:3000/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providerGson(): Gson = GsonBuilder().create()


    @Provides
    @Singleton
    fun providerRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}