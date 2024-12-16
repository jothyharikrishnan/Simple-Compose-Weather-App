package com.example.simpleweatherapp.di

import com.example.simpleweatherapp.data.remote.WeatherAPI
import com.example.simpleweatherapp.data.repository.WeatherRepositoryImpl
import com.example.simpleweatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherAPI(): WeatherAPI {
        return Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherAPI): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}
