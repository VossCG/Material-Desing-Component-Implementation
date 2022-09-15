package com.voss.ithomeironcontest.selectionControl

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentSwitchesBinding

class SwitchesFragment : BaseFragment<FragmentSwitchesBinding>(FragmentSwitchesBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSwitches()
    }

    private fun initSwitches() {
        val listener = CompoundButton.OnCheckedChangeListener { button, ischecked ->
            if (ischecked)
                Toast.makeText(requireContext(), "open", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(requireContext(), "close", Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            settingSwitch.setOnCheckedChangeListener(listener)
            hotSpotSwitch.setOnCheckedChangeListener(listener)
            getMessageSwitch.setOnCheckedChangeListener(listener)
            getNotificationSwitch.setOnCheckedChangeListener(listener)
            airplaneModeSwitch.setOnCheckedChangeListener(listener)
        }
    }
}