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


        binding.apply {
            draggableCoordinatorLayout.addDraggableChild(cardview1)
            draggableCoordinatorLayout.addDraggableChild(cardview2)
            draggableCoordinatorLayout.addDraggableChild(cardview3)
            draggableCoordinatorLayout.addDraggableChild(cardview4)
            draggableCoordinatorLayout.addDraggableChild(cardview5)

            draggableCoordinatorLayout.setViewDragListener(object :
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
}