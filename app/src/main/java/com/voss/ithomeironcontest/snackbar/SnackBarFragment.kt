package com.voss.ithomeironcontest.snackbar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_SLIDE
import com.google.android.material.snackbar.Snackbar
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentSnackbarBinding

class SnackBarFragment : BaseFragment<FragmentSnackbarBinding>(FragmentSnackbarBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.snackBarBtn.setOnClickListener {
            showNormalSnackBar()
        }
        binding.snackBarInBottomTopBtn.setOnClickListener {
            showNormalSnackBarInBottomTop()
        }
        binding.snackBarCustomInCodeBtn.setOnClickListener {
            showCustomSnackBarInCode()
        }
    }

    private fun showNormalSnackBarInBottomTop() {
        Snackbar.make(binding.root, "Normal SnackBar", Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.bottomBtn)
            .setAction("Do action") {
                Toast.makeText(requireContext(), "Do", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showNormalSnackBar() {
        Snackbar.make(binding.root, "Normal SnackBar", Snackbar.LENGTH_SHORT)
            .setAction("Do action") {
                Toast.makeText(requireContext(), "Do", Toast.LENGTH_SHORT).show()
            }.show()
    }

    private fun showCustomSnackBarInCode() {
        Snackbar.make(binding.root, "Custom in code", Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.bottomBtn)
            .setAction("Action") {}
            .setBackgroundTint(getColor(R.color.lightYellow))
            .setTextColor(getColor(R.color.white))
            .setActionTextColor(getColor(R.color.tealBlue))
            .setAnimationMode(ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId, null)
    }
}