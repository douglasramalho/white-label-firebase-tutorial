package br.com.douglasmotta.whitelabeltutorial.domain.model

import java.math.BigDecimal

data class Product(
    val id: Int,
    val description: String,
    val price: BigDecimal
)
