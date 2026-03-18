package io.github.theodorosB.therapath.di.module.user

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.theodorosB.therapath.data.user.UserDataSource
import io.github.theodorosB.therapath.data.user.UserRepositoryImpl
import io.github.theodorosB.therapath.domain.user.UserRepository
import io.github.theodorosB.therapath.framework.user.UserDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface UserBindsModule {

    @Binds
    fun bindUserRepositoryImpl(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindLoginDatastoreImpl(userDataSourceImpl: UserDataSourceImpl): UserDataSource
}