package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product

interface CreateProductUserCase {

    suspend operator fun invoke(description: String, price: Double, imageUri: Uri)
}