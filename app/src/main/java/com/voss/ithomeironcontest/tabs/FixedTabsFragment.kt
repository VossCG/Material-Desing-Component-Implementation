package com.voss.ithomeironcontest.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentFixedTabsBinding
import com.voss.ithomeironcontest.util.showToast

class FixedTabsFragment :
    BaseFragment<FragmentFixedTabsBinding>(FragmentFixedTabsBinding::inflate) {
    private val navController: NavController by lazy { findNavController() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager2()
        setTabWithViewPager2()


        binding.toScrollableTabBtn.setOnClickListener {
            navController.navigate(R.id.action_tabsFragment_to_scrollableTabsFragment)
        }
        binding.fixedTab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // called when a tab get selected
                showToast(requireContext(), "selected" + tab?.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // called when a tab exits the selected state
                showToast(requireContext(), "unSelected" + tab?.text.toString())
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // called when a tab that is already
                showToast(requireContext(), "reSelected" + tab?.text.toString())
            }

        })
    }

    private fun setTabWithViewPager2() {
        TabLayoutMediator(
            binding.fixedTab,
            binding.tabViewPager2,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    when (position) {
                        0 -> {

                            tab.text = "Home"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_home_24, null)
                            val badge1 = tab.orCreateBadge
                            badge1.number = 11
                        }
                        1 -> {
                            tab.text = "Dashboard"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_dashboard_24, null)
                            val badge2 = tab.orCreateBadge
                            badge2.number = 22

                        }
                        2 -> {
                            tab.text = "search"
                            tab.icon = resources.getDrawable(R.drawable.ic_baseline_search_24, null)
                            val badge3 = tab.orCreateBadge
                            badge3.number = 33
                        }
                    }
                }
            }).attach()
    }

    private fun setViewPager2() {
        val tabSize = binding.fixedTab.tabCount
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
        binding.tabViewPager2.apply {
            adapter = mViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }
}