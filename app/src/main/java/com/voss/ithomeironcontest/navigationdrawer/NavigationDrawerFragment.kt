
package com.voss.ithomeironcontest.navigationdrawer

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentNavigationdrawerBinding

class NavigationDrawerFragment:BaseFragment<FragmentNavigationdrawerBinding>(FragmentNavigationdrawerBinding::inflate) {
    private val navController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.modalDrawerBtn.setOnClickListener {
            navController.navigate(R.id.action_navigationDrawerFragment_to_modalNavigationDrawerFragment)
        }
        binding.bottomDrawerBtn.setOnClickListener {
            navController.navigate(R.id.action_navigationDrawerFragment_to_bottomNavigationDrawerFragment)
        }
    }
}