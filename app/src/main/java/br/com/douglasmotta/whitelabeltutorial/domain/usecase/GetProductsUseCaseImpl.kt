package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.repository.ProductRepository

class GetProductsUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductsUseCase {

    override suspend fun invoke(): List<Product> = productRepository.getProducts()
}