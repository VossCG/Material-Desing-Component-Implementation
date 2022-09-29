package com.voss.ithomeironcontest.divider

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentDividerBinding

class DividerFragment:BaseFragment<FragmentDividerBinding>(FragmentDividerBinding::inflate) {

    private val mAdapter :DividerAdapter by lazy { DividerAdapter(20) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set divider
        val materialDivider = MaterialDividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        materialDivider.dividerColor = resources.getColor(R.color.white,null)
        materialDivider.dividerInsetStart = 20
        materialDivider.dividerInsetEnd = 20

        binding.dividerWithRecycler.apply {
            setHasFixedSize(true)
            layoutManager  = LinearLayoutManager(requireContext())
            addItemDecoration(materialDivider)
            adapter = mAdapter
        }
    }
}