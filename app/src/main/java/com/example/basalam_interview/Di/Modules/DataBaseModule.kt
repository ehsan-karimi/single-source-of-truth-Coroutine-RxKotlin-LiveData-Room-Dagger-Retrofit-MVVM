package com.example.basalam_interview.Di.Modules

import android.content.Context
import androidx.room.Room
import com.example.basalam_interview.Model.LocalDataSource.ProductsDao
import com.example.basalam_interview.Model.LocalDataSource.RoomConfig.ProductsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context): ProductsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ProductsDatabase::class.java, DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideProductsDao(db: ProductsDatabase): ProductsDao {
        return db.productsDao()
    }


    companion object {
        private const val DB_NAME = "person_db"
    }
}