package com.voss.ithomeironcontest.topbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentTopBarProminentBinding

class TopBarProminentFragment :
    BaseFragment<FragmentTopBarProminentBinding>(FragmentTopBarProminentBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.statusBarColor = resources.getColor(R.color.transparent, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}