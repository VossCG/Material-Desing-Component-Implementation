package com.voss.ithomeironcontest

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.voss.ithomeironcontest.databinding.FragmentMainHomeBinding

class HomeMainFragment:BaseFragment<FragmentMainHomeBinding>(FragmentMainHomeBinding::inflate) {
    private val navController:NavController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigateToTest()
    }
    private fun setNavigateToTest(){
        binding.tabsBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_tabsFragment)
        }
        binding.navigationBottomBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_bottomNavigationFragment)
        }
        binding.switchesBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_switchesFragment)
        }
        binding.checkboxesBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_checkboxesFragment)
        }
        binding.radioButtonBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_radioButtonFragment)
        }
        binding.buttonBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_buttonFragment)
        }
        binding.textFieldBtn.setOnClickListener {
            navController.navigate(R.id.action_homeMainFragment_to_textFieldsFragment)
        }
    }
}