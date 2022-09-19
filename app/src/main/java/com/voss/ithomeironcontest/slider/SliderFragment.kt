package com.voss.ithomeironcontest.slider

import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentSliderBinding

class SliderFragment : BaseFragment<FragmentSliderBinding>(FragmentSliderBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSlider()
        setRangerSlider()
    }

    private fun setSlider() {
        binding.continuousSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                Toast.makeText(
                    requireContext(),
                    "Continuous Slider StartTracking",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onStopTrackingTouch(slider: Slider) {
                Toast.makeText(
                    requireContext(),
                    "Continuous Slider StopTracking",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        binding.continuousSlider.addOnChangeListener { slider, value, fromUser ->
            binding.continuousSliderValueTv.text = "Slider Value : $value"
        }
        binding.discreteSlider.addOnChangeListener { slider, value, fromUser ->
            binding.discreteSliderValueTv.text = "Slider Value : $value"
        }
    }

    private fun setRangerSlider() {
        binding.continuousRangeSlider.addOnSliderTouchListener(object :
            RangeSlider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: RangeSlider) {
                Toast.makeText(
                    requireContext(),
                    "Continuous Range Slider StartTracking",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                Toast.makeText(
                    requireContext(),
                    "Continuous Slider StopTracking",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
        binding.continuousRangeSlider.addOnChangeListener { slider, value, fromUser ->
            binding.continuousRangeSliderValueTv.text = "Range Slider Value : $value"
        }
        binding.discreteRangeSlider.addOnChangeListener { slider, value, fromUser ->
            binding.discreteRangeSliderValueTv.text = "Slider Value : $value"
        }
        // change label format to USD
        binding.continuousRangeSlider.setLabelFormatter { value: Float ->
            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            format.currency = Currency.getInstance("USD")
            val newFormat = format.format(value.toDouble())
            newFormat
        }
    }
}