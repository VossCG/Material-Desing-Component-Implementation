package com.voss.ithomeironcontest.navigationdrawer

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.math.MathUtils
import com.google.android.material.navigation.NavigationView
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentBottomNavigationDrawerBinding

class BottomNavigationDrawerFragment :
    BaseFragment<FragmentBottomNavigationDrawerBinding>(FragmentBottomNavigationDrawerBinding::inflate) {
    private var oldMenuItem: MenuItem? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomDrawerNavigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        binding.bottomAppBar.setNavigationOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                hiddenDrawer(bottomSheetBehavior)
            else
                expandDrawer(bottomSheetBehavior)
        }

        binding.bottomDrawerNavigationView.setNavigationItemSelectedListener { menuItem ->
            oldMenuItem?.isChecked = false
            menuItem.isChecked = true
            oldMenuItem = menuItem
            Toast.makeText(requireContext(), "Click ${menuItem.title}", Toast.LENGTH_SHORT).show()
            hiddenDrawer(bottomSheetBehavior)
            true
        }
        binding.scrim.setOnClickListener {
            hiddenDrawer(bottomSheetBehavior)
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }

            // 實現 scrim 的效果
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val baseColor = Color.BLACK
                val baseAlpha = ResourcesCompat.getFloat(
                    resources,
                    com.google.android.material.R.dimen.material_emphasis_medium
                )
                val offset = (slideOffset - (-1f)) / (1f - (-1f)) * (1f - 0f) + 0f
                val alpha = MathUtils.lerp(0f, 255f, offset * baseAlpha).toInt()
                val color = Color.argb(alpha, baseColor.red, baseColor.green, baseColor.blue)
                binding.scrim.setBackgroundColor(color)
            }
        })
    }

    private fun hiddenDrawer(bottomSheetBehavior: BottomSheetBehavior<NavigationView>) {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun expandDrawer(bottomSheetBehavior: BottomSheetBehavior<NavigationView>) {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
}