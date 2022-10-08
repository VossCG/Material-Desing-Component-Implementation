package com.voss.ithomeironcontest.bottomsheets

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentExpandingBottomSheetBinding
import com.voss.ithomeironcontest.dialog.BaseDialogFragment

class ExpandingBottomSheetFragment :
    BaseFragment<FragmentExpandingBottomSheetBinding>(
        FragmentExpandingBottomSheetBinding::inflate
    ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 1000
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
        }
    }

    private val navController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fullscreenBottomsheetTb.setNavigationOnClickListener {
            navController.navigateUp()
        }
    }
}