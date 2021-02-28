package com.martppa.kmmex.androidApp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.martppa.kmmex.androidApp.R
import com.martppa.kmmex.androidApp.ui.lifecycle.observeEvent
import com.martppa.kmmex.androidApp.ui.viewmodel.BaseViewModel
import com.martppa.kmmex.core.domain.exception.ErrorCode
import com.martppa.kmmex.core.domain.extension.getMessage

abstract class ViewModelFragment : BaseFragment() {

    protected abstract val viewModel: BaseViewModel

    @get:LayoutRes
    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onCreateViewCalled()
        return inflater.inflate(layout, container, false)
    }

    @CallSuper
    protected open fun onCreateViewCalled() {
        observeErrors()
    }

    protected open fun observeErrors() {
        observeEvent(viewModel.onErrorEvent) { handleError(it) }
    }

    protected open fun handleError(error: Throwable?) {
        val errorMessage = error?.getMessage()
                ?: context?.getString(R.string.error_unexpected_error, ErrorCode.UNKNOWN)
                ?: ErrorCode.UNKNOWN
        showError(errorMessage)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}