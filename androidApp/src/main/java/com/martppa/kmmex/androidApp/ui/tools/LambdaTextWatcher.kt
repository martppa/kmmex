package com.martppa.kmmex.androidApp.ui.tools

import android.text.Editable
import android.text.TextWatcher

class LambdaTextWatcher(
        val handler: (text: String) -> Unit
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        handler(s.toString())
    }
}