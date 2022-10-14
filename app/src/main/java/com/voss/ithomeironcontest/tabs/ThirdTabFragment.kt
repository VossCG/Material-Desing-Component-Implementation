package com.voss.ithomeironcontest.tabs

import android.os.Bundle
import android.util.Log
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentThirdTabBinding

class ThirdTabFragment:BaseFragment<FragmentThirdTabBinding>(FragmentThirdTabBinding::inflate) {
    private val simpleName = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(simpleName, "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(simpleName, "OnStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(simpleName, "OnDestroy")
    }
}