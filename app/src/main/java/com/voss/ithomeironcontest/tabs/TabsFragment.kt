package com.voss.ithomeironcontest.tabs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentTabsBinding

class TabsFragment : BaseFragment<FragmentTabsBinding>(FragmentTabsBinding::inflate) {
    private val navController: NavController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fixedTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        setTabWithViewPager2()
    }

    private fun setTabWithViewPager2() {
        val tabSize = 3
        val mViewPagerAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return tabSize
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> FirstTabFragment()
                    1 -> SecondTabFragment()
                    2 -> ThirdTabFragment()
                    else -> FirstTabFragment()
                }
            }

        }
        binding.tabViewPager2.apply {
            adapter = mViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        TabLayoutMediator(
            binding.fixedTab,
            binding.tabViewPager2,
            object : TabLayoutMediator.TabConfigurationStrategy {
                @SuppressLint("UseCompatLoadingForDrawables")
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    when (position) {
                        0 -> {
                            tab.text = "ConfigureTab 1"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_home_24, null)
                            val badge = tab.orCreateBadge
                        }
                        1 -> {
                            tab.text = "ConfigureTab 2"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_dashboard_24, null)
                            val badge = tab.orCreateBadge

                        }
                        2 -> {
                            tab.text = "ConfigureTab 3"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_search_24, null)
                            val badge = tab.orCreateBadge
                        }
                    }
                }
            })
            .attach()
    }
}