package com.voss.ithomeironcontest.dialog

import android.os.Bundle
import android.view.View
import com.voss.ithomeironcontest.databinding.FragmentFullScreenDialogBinding

class FullScreenDialogFragment :
    BaseDialogFragment<FragmentFullScreenDialogBinding>(FragmentFullScreenDialogBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fullscreenCancelBtn.setOnClickListener {
            dismiss()
        }
    }
}