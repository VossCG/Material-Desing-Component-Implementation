package com.voss.ithomeironcontest.cardview

import android.os.Bundle
import android.view.View
import com.google.android.material.card.MaterialCardView
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentDraggleCardviewBinding

class DraggableCardFragment :
    BaseFragment<FragmentDraggleCardviewBinding>(FragmentDraggleCardviewBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.draggableCoordinatorLayout.setViewDragListener(object :
            DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, id: Int) {
                if (view is MaterialCardView) {
                    view.isDragged = true
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                if (view is MaterialCardView) {
                    view.isDragged = false
                }
            }
        })
    }
}