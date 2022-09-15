package com.voss.ithomeironcontest.selectionControl

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentCheckboxesBinding

class CheckboxesFragment :
    BaseFragment<FragmentCheckboxesBinding>(FragmentCheckboxesBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = CompoundButton.OnCheckedChangeListener { button, isChecked ->
            if (isChecked)
                Toast.makeText(requireContext(), "${button.text} checked ", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(requireContext(), "${button.text} unChecked", Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            checkbox1.setOnCheckedChangeListener(listener)
            checkbox2.setOnCheckedChangeListener(listener)
            checkbox3.setOnCheckedChangeListener(listener)
            checkbox4.setOnCheckedChangeListener(listener)
            checkbox5.setOnCheckedChangeListener(listener)
        }
    }
}