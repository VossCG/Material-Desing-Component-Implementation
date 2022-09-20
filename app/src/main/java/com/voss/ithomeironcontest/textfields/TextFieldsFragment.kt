package com.voss.ithomeironcontest.textfields

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentTextFieldsBinding

class TextFieldsFragment :
    BaseFragment<FragmentTextFieldsBinding>(FragmentTextFieldsBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dropMenuList = listOf("Material", "Design", "Components", "Android")
        val menuAdapter = ArrayAdapter(requireContext(), R.layout.itemview_dropmenu_item, dropMenuList)
        binding.dropDownAutoText.setAdapter(menuAdapter)
        binding.textErrorTextField.addTextChangedListener {
            if (binding.textErrorTextField.text.toString().length > 20)
                binding.textErrorTextFieldLayout.error = "exceed the length limit "
            else
                binding.textErrorTextFieldLayout.error = null
        }
    }
}