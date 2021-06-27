package br.com.douglasmotta.whitelabeltutorial.data.repository

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.repository.ProductRepository
import kotlin.coroutines.suspendCoroutine

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return suspendCoroutine { continuation ->
        }
    }

    override suspend fun createProduct(product: Product) {
        return suspendCoroutine { continuation ->
        }
    }
}