package com.santiago.guillen.composedemopokedexapp.di

import android.app.Application
import androidx.room.Room
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.ApiManager
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.Services
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.impl.ApiPokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.LocalPokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.RemotePokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.AppDatabase
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.dao.PokemonDao
import com.santiago.guillen.composedemopokedexapp.data.datasource.room.impl.RoomPokedexData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    /* Retrofit */
    @Provides
    @Singleton
    fun providesServices(): Services = ApiManager().create(Services::class.java)

    @Provides
    @Singleton
    fun providesRemotePokedexData(apiPokedexData: ApiPokedexData): RemotePokedexData = apiPokedexData

    /* Room */
    @Provides
    @Singleton
    fun providesAppDataBase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "pokedex_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesPokemonDao(appDatabase: AppDatabase): PokemonDao = appDatabase.pokemonDao()

    @Provides
    @Singleton
    fun providesLocalPokedexData(roomPokedexData: RoomPokedexData): LocalPokedexData = roomPokedexData


}