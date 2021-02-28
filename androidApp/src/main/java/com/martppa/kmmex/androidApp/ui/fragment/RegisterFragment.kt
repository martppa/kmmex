package com.martppa.kmmex.androidApp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martppa.kmmex.androidApp.databinding.FragmentRegisterBinding
import com.martppa.kmmex.androidApp.ui.lifecycle.observe
import com.martppa.kmmex.androidApp.ui.tools.LambdaTextWatcher
import com.martppa.kmmex.androidApp.ui.viewmodel.BaseViewModel
import com.martppa.kmmex.androidApp.ui.viewmodel.RegisterViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : ViewBoundFragment<FragmentRegisterBinding>() {

    override val viewModel: RegisterViewModel by viewModel()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        defineListeners()
        observeData()
    }

    private fun observeData() {
        observe(viewModel.liveUsername, this::renderUsername)
        observe(viewModel.livePassword, this::renderPassword)
    }

    private fun defineListeners() {
        binding.usernameInput.addTextChangedListener(LambdaTextWatcher { viewModel.username = it })
        binding.passwordInput.addTextChangedListener(LambdaTextWatcher { viewModel.password = it })
        binding.registerButton.setOnClickListener { viewModel.registerClicked() }
    }

    private fun renderUsername(value: String) {
        if (binding.usernameInput.text.toString() != value) {
            binding.usernameInput.setText(value)
        }
    }

    private fun renderPassword(value: String) {
        if (binding.passwordInput.text.toString() != value) {
            binding.passwordInput.setText(value)
        }
    }
}