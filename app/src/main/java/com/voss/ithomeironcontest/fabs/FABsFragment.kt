package com.voss.ithomeironcontest.fabs

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentFabsBinding

class FABsFragment:BaseFragment<FragmentFabsBinding>(FragmentFabsBinding::inflate) {
    private val fromBottom :Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.from_bottom_animation) }
    private val toBottom :Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.to_bottom_animation) }
    private val rotateClose :Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_close_animation) }
    private val rotateOpen :Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_open_animation) }

    private var isFabExpanded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.extendedFab.setOnClickListener {
            binding.extendedFab.shrink()
        }
        binding.extendedOnlyTextFab.setOnClickListener {
            // shrink can't work because this fabs only have text label
            binding.extendedOnlyTextFab.shrink()
        }

        binding.expandableFab.setOnClickListener {
            isFabExpanded = !isFabExpanded
            setVisibility(isFabExpanded)
            setAnimation(isFabExpanded)
            setButtonClickable(isFabExpanded)
        }

    }

    private fun setAnimation(isExpanded: Boolean) {
        if (isExpanded){
            binding.searchExpandFab.startAnimation(fromBottom)
            binding.shareExpandFab.startAnimation(fromBottom)
            binding.expandableFab.startAnimation(rotateOpen)
        }else{
            binding.searchExpandFab.startAnimation(toBottom)
            binding.shareExpandFab.startAnimation(toBottom)
            binding.expandableFab.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(isExpanded: Boolean) {
        if (isExpanded){
            binding.searchExpandFab.visibility = VISIBLE
            binding.shareExpandFab.visibility = VISIBLE
        }else{
            binding.searchExpandFab.visibility = INVISIBLE
            binding.shareExpandFab.visibility = INVISIBLE
        }
    }


    private fun setButtonClickable(isExpanded: Boolean) {
        if (isExpanded){
            binding.searchExpandFab.isClickable= true
            binding.shareExpandFab.isClickable = true
        }else{
            binding.searchExpandFab.isClickable = false
            binding.shareExpandFab.isClickable = false
        }
    }

}