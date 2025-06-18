package com.pinup.barapp.di

import android.content.Context
import com.pinup.barapp.data.remote.local.AppDatabase
import com.pinup.barapp.data.remote.local.CartDao
import com.pinup.barapp.data.repositories.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)

    @Provides
    fun provideCartDao(database: AppDatabase): CartDao = database.cartDao()

    @Provides
    fun provideCartRepository(dao: CartDao): CartRepository = CartRepository(dao)
}
