package com.voss.ithomeironcontest.bottomNavigation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentBottomNavigationBinding

class BottomNavigationFragment :
    BaseFragment<FragmentBottomNavigationBinding>(FragmentBottomNavigationBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_item -> {
                    // navigate to home
                    true
                }
                R.id.search_item -> {
                    // navigate to search
                    true
                }
                R.id.setting_item -> {
                    // navigate to setting
                    true
                }
                else -> false

            }
        }
        settingBadges()
    }

    private fun settingBadges() {
        val homeBadge = binding.bottomNavigation.getOrCreateBadge(R.id.home_item)
        homeBadge.number = 99
        val searchBadge = binding.bottomNavigation.getOrCreateBadge(R.id.search_item)
        searchBadge.number = 88
        val settingBadge = binding.bottomNavigation.getOrCreateBadge(R.id.setting_item)
        settingBadge.number = 77

        val homeBadgeDrawable = binding.bottomNavigation.getBadge(R.id.home_item)
        if (homeBadgeDrawable != null) {
            homeBadgeDrawable.isVisible = false
            homeBadgeDrawable.clearNumber()
        }
    }
}