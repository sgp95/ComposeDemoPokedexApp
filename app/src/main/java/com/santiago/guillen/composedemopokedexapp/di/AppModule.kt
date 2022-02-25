package com.santiago.guillen.composedemopokedexapp.di

import com.santiago.guillen.composedemopokedexapp.data.datasource.api.ApiManager
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.Services
import com.santiago.guillen.composedemopokedexapp.data.datasource.api.impl.ApiPokedexData
import com.santiago.guillen.composedemopokedexapp.data.datasource.interfaces.RemotePokedexData
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
}