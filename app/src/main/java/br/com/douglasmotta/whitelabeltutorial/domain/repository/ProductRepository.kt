package br.com.douglasmotta.whitelabeltutorial.domain.repository

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun createProduct(product: Product)
}