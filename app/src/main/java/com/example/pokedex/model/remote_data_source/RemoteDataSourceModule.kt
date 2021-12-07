package com.example.pokedex.model.remote_data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * [RemoteDataSource] の Module
 */
@Module
@InstallIn(ViewModelComponent::class)
class RemoteDataSourceModule {

    /**
     * [RemoteDataSource] の DIに用いられるインスタンスを生成して返す
     */
    @Provides
    fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource {
        return remoteDataSourceImpl
    }
}
