package com.voss.ithomeironcontest.topbar

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentTopBarRegularBinding

class TopBarRegularFragment :
    BaseFragment<FragmentTopBarRegularBinding>(FragmentTopBarRegularBinding::inflate) {

    private val navController: NavController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toProminentTopBarBtn.setOnClickListener {
            navController.navigate(R.id.action_topBarRegularFragment_to_prominentTopBarFragment)
        }
        binding.toContextualTopBarBtn.setOnClickListener {
            navController.navigate(R.id.action_topBarRegularFragment_to_topBarContextualFragment)
        }
    }
}