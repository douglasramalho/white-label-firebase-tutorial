package br.com.douglasmotta.whitelabeltutorial.ui.addproduct

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.douglasmotta.whitelabeltutorial.R

class AddProductViewModel : ViewModel() {

    private val _uiStateEvent = MutableLiveData<UiSate>()
    val uiStateEvent: LiveData<UiSate> = _uiStateEvent

    private val _imageUriErrorResId = MutableLiveData<Int>()
    val imageUriErrorResId: LiveData<Int> = _imageUriErrorResId

    private val _descriptionFieldErrorResId = MutableLiveData<Int?>()
    val descriptionFieldErrorResId: LiveData<Int?> = _descriptionFieldErrorResId

    private val _priceFieldErrorResId = MutableLiveData<Int?>()
    val priceFieldErrorResId: LiveData<Int?> = _priceFieldErrorResId

    private var isFormValid = true

    fun createProduct(description: String, price: String, imageUri: Uri?) {
        isFormValid = true

        _imageUriErrorResId.value = getDrawableResIdIfNull(imageUri)
        _descriptionFieldErrorResId.value = getErrorStringResIdIfEmpty(description)
        _priceFieldErrorResId.value = getErrorStringResIdIfEmpty(price)

        if (isFormValid) {
            // Call api
        }
    }

    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.add_product_field_error
        } else null
    }

    private fun getDrawableResIdIfNull(value: Uri?): Int {
        return if (value == null) {
            isFormValid = false
            R.drawable.background_product_image_error
        } else R.drawable.background_product_image
    }

    sealed class UiSate {
        object Valid : UiSate()
        object InvalidImageUri : UiSate()
        object InvalidDescription : UiSate()
        object InvalidPrice : UiSate()
    }
}