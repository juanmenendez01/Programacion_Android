    package com.sena.consumoapiksp.model

    import androidx.room.Database
    import androidx.room.RoomDatabase
    import com.sena.consumoapiksp.model.dao.AdminDao
    import com.sena.consumoapiksp.model.dao.EstudianteDao
    import com.sena.consumoapiksp.model.dao.NotaDao

    @Database(entities = [EstudianteLocal::class, NotaLocal::class, AdminLocal::class], version = 4)
    abstract class AppDatabase: RoomDatabase() {
        abstract fun estudianteDao(): EstudianteDao
        abstract fun notaDao(): NotaDao
        abstract fun adminDao(): AdminDao
    }