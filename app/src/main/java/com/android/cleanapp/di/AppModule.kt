package com.android.cleanapp.di

import com.android.cleanapp.data.remote.CryptoAPI
import com.android.cleanapp.data.repository.CryptoRepositoryImpl
import com.android.cleanapp.domain.repository.CryptoRepository
import com.android.cleanapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CryptoModule {

    @Singleton
    @Provides
    fun provideApi() : CryptoAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(CryptoAPI : CryptoAPI) : CryptoRepository{
        return CryptoRepositoryImpl(CryptoAPI)
    }
}