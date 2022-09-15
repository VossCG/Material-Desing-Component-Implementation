package com.voss.ithomeironcontest.button

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentButtonBinding

class ButtonFragment : BaseFragment<FragmentButtonBinding>(FragmentButtonBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            alignRightIconButton.setOnClickListener {
                Toast.makeText(requireContext(), "Align Right", Toast.LENGTH_SHORT).show()
            }
            alignLeftIconButton.setOnClickListener {
                Toast.makeText(requireContext(), "Align Left", Toast.LENGTH_SHORT).show()
            }
            alignCenterIconButton.setOnClickListener {
                Toast.makeText(requireContext(), "Align Center", Toast.LENGTH_SHORT).show()
            }
        }
    }
}