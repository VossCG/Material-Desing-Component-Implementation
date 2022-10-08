package com.voss.ithomeironcontest.bottomsheets

import android.os.Bundle
import android.view.View
import com.google.android.material.R.style.Theme_Design_BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentModalBottomSheetBinding


class ModalBottomSheetFragment :
    BaseBottomSheetDialogFragment<FragmentModalBottomSheetBinding>(FragmentModalBottomSheetBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, Theme_Design_BottomSheetDialog)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}