package com.martppa.kmmex.androidApp.ui.fragment

import android.content.Context
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import com.martppa.kmmex.androidApp.ui.view.dialog.LoadingDialog

abstract class BaseFragment : Fragment() {

    private var loadingDialog: LoadingDialog? = null

    open protected @IntegerRes
    var topContainer: Int? = null

    fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showSuccess(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    open fun showLoading(message: String) {
        runIfContext {
            loadingDialog = LoadingDialog(message)
            loadingDialog?.showNow(childFragmentManager, null)
        }
    }

    fun hideLoading() {
        loadingDialog?.dismiss()
    }

    fun runIfContext(handler: (context: Context) -> Unit) {
        context?.let(handler)
    }

    protected open fun goBack() {
        activity?.onBackPressed()
    }
}