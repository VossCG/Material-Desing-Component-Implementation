package com.voss.ithomeironcontest.progressindicators

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentProgressIndicatorBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressIndicatorsFragment :
    BaseFragment<FragmentProgressIndicatorBinding>(FragmentProgressIndicatorBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        testShowHideAnimation()
        delayDisplay()
    }
    private fun delayDisplay(){
        lifecycleScope.launch {
            delay(2500)
            switchIndeterminateToDeter()
            testCircularFillToZero()
        }
    }

    private fun switchIndeterminateToDeter() {
            testCircularFillToZero()
            binding.indeterminateCircularProgress.isIndeterminate = false
            binding.indeterminateCircularProgress.setProgressCompat(50,true)

            binding.contiguousLinearProgress.isIndeterminate = false
            binding.contiguousLinearProgress.setProgressCompat(50,true)

    }

    private fun testCircularFillToZero(){
        binding.circularProgress.setProgressCompat(0,true)
    }

    private fun testShowHideAnimation(){
        lifecycleScope.launch{
            delay(2000)
            binding.linearProgress.show()
            delay(2000)
            binding.linearProgress.hide()
        }
    }
}