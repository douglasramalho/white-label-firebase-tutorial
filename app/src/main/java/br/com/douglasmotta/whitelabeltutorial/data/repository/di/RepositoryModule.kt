package br.com.douglasmotta.whitelabeltutorial.data.repository.di

import br.com.douglasmotta.whitelabeltutorial.data.repository.ProductRepositoryImpl
import br.com.douglasmotta.whitelabeltutorial.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository
}