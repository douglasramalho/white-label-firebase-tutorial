package br.com.douglasmotta.whitelabeltutorial.data.repository

import br.com.douglasmotta.whitelabeltutorial.BuildConfig
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.repository.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.util.COLLECTION_PRODUCTS
import br.com.douglasmotta.whitelabeltutorial.util.COLLECTION_ROOT
import br.com.douglasmotta.whitelabeltutorial.util.DESCRIPTION_KEY
import br.com.douglasmotta.whitelabeltutorial.util.PRICE_KEY
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.suspendCoroutine

class ProductRepositoryImpl : ProductRepository {

    private val documentReference = FirebaseFirestore.getInstance()
        .document("${COLLECTION_ROOT}/${BuildConfig.FIREBASE_FLAVOR_COOLECTION}")

    override suspend fun getProducts(): List<Product> {
        return suspendCoroutine { continuation ->
            val productsReference = documentReference.collection(COLLECTION_PRODUCTS)

            productsReference.get().addOnSuccessListener { documents ->
                val products = mutableListOf<Product>()
                for (document in documents) {
                    document.toObject(Product::class.java).run {
                        products.add(this)
                    }
                }

                continuation.resumeWith(Result.success(products))
            }

            productsReference.get().addOnFailureListener {
                continuation.resumeWith(Result.failure(it))
            }
        }
    }

    override suspend fun createProduct(product: Product) {
        return suspendCoroutine { continuation ->
            val productToSave = hashMapOf(
                DESCRIPTION_KEY to product.description,
                PRICE_KEY to product.price
            )

            documentReference
                .collection(COLLECTION_PRODUCTS)
                .add(productToSave)
                .addOnSuccessListener {
                    continuation.resumeWith(Result.success(Unit))
                }
                .addOnFailureListener {
                    continuation.resumeWith(Result.failure(it))
                }
        }
    }
}