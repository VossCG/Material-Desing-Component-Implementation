package com.voss.ithomeironcontest.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentModalNavigationDrawerBinding

class ModalNavigationDrawerFragment :
    BaseFragment<FragmentModalNavigationDrawerBinding>(FragmentModalNavigationDrawerBinding::inflate) {
    private var oldMenuItem :MenuItem?= null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.modalDrawerToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
        binding.modalDrawerNavigationView.setNavigationItemSelectedListener { menuItem->
            oldMenuItem?.isChecked = false
            oldMenuItem = menuItem
            menuItem.isChecked = true
            Toast.makeText(requireContext(),"Click ${menuItem.title}",Toast.LENGTH_SHORT).show()
            binding.drawerLayout.close()
            true
        }
    }
}