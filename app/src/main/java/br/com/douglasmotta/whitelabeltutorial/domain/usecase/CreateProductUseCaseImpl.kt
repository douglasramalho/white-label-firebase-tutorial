package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.repository.ProductRepository

class CreateProductUseCaseImpl(
    private val productRepository: ProductRepository
) : CreateProductUserCase {

    override suspend fun invoke(product: Product) {
        return productRepository.createProduct(product)
    }
}