package br.com.douglasmotta.whitelabeltutorial.domain.usecase.di

import br.com.douglasmotta.whitelabeltutorial.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCrateProductUseCase(useCase: CreateProductUseCaseImpl): CreateProductUseCase

    @Binds
    fun bindGetProductsUseCase(useCase: GetProductUseCaseImpl): GetProductsUseCase

    @Binds
    fun bindUploadImageUseCase(useCase: UploadProductImageUseCaseImpl): UploadProductImageUseCase
}