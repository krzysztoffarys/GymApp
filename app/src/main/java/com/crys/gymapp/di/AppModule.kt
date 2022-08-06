package com.crys.gymapp.di

import android.app.Application
import androidx.room.Room
import com.crys.gymapp.feature_weight.data.data_source.WeightDatabase
import com.crys.gymapp.feature_weight.data.repository.WeightRepositoryImpl
import com.crys.gymapp.feature_weight.domain.repository.WeightRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeightDatabase(app: Application): WeightDatabase {
        return Room.databaseBuilder(
            app,
            WeightDatabase::class.java,
            WeightDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideWeightRepository(database: WeightDatabase): WeightRepository {
        return WeightRepositoryImpl(database.weightDao)
    }
}