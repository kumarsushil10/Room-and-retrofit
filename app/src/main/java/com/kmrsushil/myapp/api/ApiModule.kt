package com.kmrsushil.myapp.api

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kmrsushil.myapp.model.MyDao
import com.kmrsushil.myapp.model.MyRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    //https://jsonplaceholder.typicode.com/posts
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context):MyRoomDataBase =
        Room.databaseBuilder(context,MyRoomDataBase::class.java,"myDatabase")
            .build()

    @Provides
    fun providesDao(myRoomDatabase: MyRoomDataBase):MyDao = myRoomDatabase.myDao()
    @Singleton
    @Provides
    fun providesRepository(myDao: MyDao,apiService: ApiService) = Repository(myDao,apiService)
}