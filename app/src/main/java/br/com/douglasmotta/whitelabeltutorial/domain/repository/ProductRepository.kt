package br.com.douglasmotta.whitelabeltutorial.domain.repository

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun uploadProductImage(imageUri: Uri): String

    suspend fun createProduct(product: Product): Product
}