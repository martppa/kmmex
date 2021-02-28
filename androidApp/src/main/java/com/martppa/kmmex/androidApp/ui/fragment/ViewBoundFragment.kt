package com.martppa.kmmex.androidApp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class ViewBoundFragment<T: ViewBinding>: ViewModelFragment() {

    override val layout: Int get() = -1

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getBinding(inflater, container)
        onCreateViewCalled()
        return binding.root
    }

    protected abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): T
}