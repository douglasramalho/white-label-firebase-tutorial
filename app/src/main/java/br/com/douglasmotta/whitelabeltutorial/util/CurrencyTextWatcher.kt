package br.com.douglasmotta.whitelabeltutorial.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.DecimalFormat

class CurrencyTextWatcher(
    private val editText: EditText
) : TextWatcher {

    private var currentValue: String = ""

    private var updating = false

    override fun afterTextChanged(s: Editable?) {
        if (updating) return

        val stringValue = s.toString()
        if (currentValue != stringValue) {

            updating = true

            val doubleValue = stringValue.fromCurrency()
            val formatted = getFormattedValue(doubleValue)

            updateValue(formatted)
        }
    }

    private fun getFormattedValue(value: Double): String = if (value == 0.0) {
        ""
    } else value.toCurrency()

    private fun updateValue(formatted: String) {
        editText.setText(formatted)
        editText.setSelection(formatted.length)

        updating = false
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // no used
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // not used
    }
}

private val onlyNumberRegex by lazy { "[^0-9 ]".toRegex() }
private const val DECIMAL_FACTOR = 100
private const val CURRENCY_PATTERN = "R$ #,###,##0.00"

fun String.fromCurrency(): Double = this
    .replace(onlyNumberRegex, "")
    .toDouble()
    .div(DECIMAL_FACTOR)

fun Double.toCurrency(): String = DecimalFormat(CURRENCY_PATTERN)
    .format(this)