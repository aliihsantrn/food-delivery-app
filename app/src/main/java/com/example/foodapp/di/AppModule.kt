package com.example.foodapp.di

import com.example.foodapp.data.dataSource.FoodsDataSource
import com.example.foodapp.data.repo.FoodsRepository
import com.example.foodapp.retrofit.ApiUtils
import com.example.foodapp.retrofit.FoodsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFoodsDao() : FoodsDao {
        return ApiUtils.getFoodsDao()
    }

    @Provides
    @Singleton
    fun provideFoodsDataSource(dao : FoodsDao) : FoodsDataSource {
        return FoodsDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideFoodsRepository(dataSource: FoodsDataSource) : FoodsRepository {
        return FoodsRepository(dataSource)
    }
}