package com.example.rafiq.di

import android.content.Context
import androidx.room.Room
import com.example.rafiq.data.hardware.MockBleManagerImpl
import com.example.rafiq.data.local.RafiqDatabase
import com.example.rafiq.domain.hardware.BleManager
import com.example.rafiq.data.local.PlaceDao
import com.example.rafiq.data.repository.PlaceRepositoryImpl
import com.example.rafiq.domain.repository.PlaceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindsModule {
    @Binds
    @Singleton
    abstract fun bindBleManager(
        mockBleManagerImpl: MockBleManagerImpl
    ): BleManager

    @Binds
    @Singleton
    abstract fun bindPlaceRepository(
        placeRepositoryImpl: PlaceRepositoryImpl
    ): PlaceRepository
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRafiqDatabase(@ApplicationContext context: Context): RafiqDatabase {
        return Room.databaseBuilder(
            context,
            RafiqDatabase::class.java,
            "rafiq_db"
        ).build()
    }

    @Provides
    fun providePlaceDao(database: RafiqDatabase): PlaceDao {
        return database.placeDao()
    }
}
