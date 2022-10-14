package com.voss.ithomeironcontest.tabs

import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentScrollableTabsBinding

class ScrollableTabsFragment :
    BaseFragment<FragmentScrollableTabsBinding>(FragmentScrollableTabsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager2()
        setTabWithViewPager2()
    }

    private fun setTabWithViewPager2() {
        TabLayoutMediator(
            binding.scrollableTabs,
            binding.scrollTabViewPager2,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    when (position) {
                        0 -> {
                            tab.text = "Home"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_home_24, null)
                        }
                        1 -> {
                            tab.text = "Dashboard"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_dashboard_24, null)
                        }
                        2 -> {
                            tab.text = "Search"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_search_24, null)
                        }
                        3 -> {
                            tab.text = "Account"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_account_circle_24, null)
                        }
                        4 -> {
                            tab.text = "Favorite"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_24,null)
                        }
                    }
                }
            }).attach()
    }

    private fun setViewPager2() {
        val tabSize = binding.scrollableTabs.tabCount
        val mViewPagerAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return tabSize
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0, 3 -> FirstTabFragment()
                    1, 4 -> SecondTabFragment()
                    2 -> ThirdTabFragment()
                    else -> FirstTabFragment()
                }
            }
        }
        binding.scrollTabViewPager2.apply {
            adapter = mViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }
}
