package com.voss.ithomeironcontest.cardview

import android.os.Bundle
import android.view.View
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentCardviewBinding

class CardViewFragment:BaseFragment<FragmentCardviewBinding>(FragmentCardviewBinding::inflate) {
    private var isOutlinedCardChecked = false
    private var isNormalCardChecked = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.outlinedCard.setOnLongClickListener {
            isOutlinedCardChecked = !isOutlinedCardChecked
            binding.outlinedCard.isChecked = isOutlinedCardChecked
            return@setOnLongClickListener true
        }
        binding.card.setOnLongClickListener {
            isNormalCardChecked = !isNormalCardChecked
            binding.card.isChecked = isNormalCardChecked
            return@setOnLongClickListener true
        }
    }
}