package com.voss.ithomeironcontest.bottomsheets

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentStandardBottomsheetsBinding

class StandardBottomSheetsFragment:BaseFragment<FragmentStandardBottomsheetsBinding>(FragmentStandardBottomsheetsBinding::inflate) {
    private val modalBottomSheet = ModalBottomSheetFragment()
    private val navController by lazy { findNavController() }
    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            Toast.makeText(requireContext(),"State Changed",Toast.LENGTH_SHORT).show()
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            // do something
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val standardBehavior = BottomSheetBehavior.from(binding.standardBottomSheet)

        standardBehavior.addBottomSheetCallback(bottomSheetCallback)

        binding.showBottomSheetBtn.setOnClickListener {
            val behavior = BottomSheetBehavior.from(binding.standardBottomSheet)

            if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        binding.showModalBottomSheetBtn.setOnClickListener {
            modalBottomSheet.show(childFragmentManager,"Modal")
        }
        binding.expandBottomSheetBtn.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.expandBottomSheetBtn to getString(R.string.trans_expand_bottomsheet))
            navController.navigate(R.id.action_standardBottomSheetsFragment_to_expandingBottomSheetFragment,null,null,extras)
        }
    }
}