package com.martppa.kmmex.androidApp.ui.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.martppa.kmmex.androidApp.databinding.LayoutLoadingDialogBinding

class LoadingDialog(
        private val title: String
) : DialogFragment() {

    private lateinit var binding: LayoutLoadingDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = LayoutLoadingDialogBinding.inflate(inflater)
        binding.loadingDialogTitle.text = title
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setLayout(width, height)
        dialog?.setOnKeyListener { _, _, _ -> true }
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setCancelable(false)
    }
}