package com.sena.consumoapiksp.di

import android.content.Context
import androidx.room.Room
import com.sena.consumoapiksp.model.AppDatabase
import com.sena.consumoapiksp.model.dao.AdminDao
import com.sena.consumoapiksp.model.dao.EstudianteDao
import com.sena.consumoapiksp.model.dao.NotaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        callback: AppDatabaseCallback
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "mi_db_local"
        )
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDatabaseCallback(
        adminDaoProvider: Provider<AdminDao>
    ): AppDatabaseCallback {
        return AppDatabaseCallback(adminDaoProvider)
    }

    @Provides fun provideAdminDao(db: AppDatabase): AdminDao = db.adminDao()
    @Provides fun provideEstudianteDao(db: AppDatabase): EstudianteDao = db.estudianteDao()
    @Provides fun provideNotaDao(db: AppDatabase): NotaDao = db.notaDao()
}
