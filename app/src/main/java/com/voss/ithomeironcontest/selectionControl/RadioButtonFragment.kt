package com.voss.ithomeironcontest.selectionControl

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentRadioButtonBinding

class RadioButtonFragment :
    BaseFragment<FragmentRadioButtonBinding>(FragmentRadioButtonBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.radioGroup.setOnCheckedChangeListener { group, checkId ->
            when(checkId){
                R.id.radio_button_1 -> Toast.makeText(requireContext(),"radio 1",Toast.LENGTH_SHORT).show()
                R.id.radio_button_2 -> Toast.makeText(requireContext(),"radio 2",Toast.LENGTH_SHORT).show()
                R.id.radio_button_3 -> Toast.makeText(requireContext(),"radio 3",Toast.LENGTH_SHORT).show()
                R.id.radio_button_4 -> Toast.makeText(requireContext(),"radio 4",Toast.LENGTH_SHORT).show()
                R.id.radio_button_5 -> Toast.makeText(requireContext(),"radio 5",Toast.LENGTH_SHORT).show()
            }
        }
    }
}