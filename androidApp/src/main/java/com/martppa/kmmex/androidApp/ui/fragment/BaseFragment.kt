package com.martppa.kmmex.androidApp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (this::class.annotations.find { it is NestedFragment } == null) {
            setTopMargin(view)
        }
    }

    private fun setTopMargin(view: View) {
        if (topContainer == null) {
            updateToPadding(view)
        } else {
            updateToPadding(view.findViewById(topContainer!!))
        }
    }

    private fun updateToPadding(view: View) {
        runIfContext {
            view.setPadding(
                view.paddingLeft,
                view.paddingTop + it.getStatusBarHeight(),
                view.paddingRight,
                view.paddingBottom
            )
        }
    }
}