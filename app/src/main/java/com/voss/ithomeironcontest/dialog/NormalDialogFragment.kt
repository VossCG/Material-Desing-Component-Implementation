package com.voss.ithomeironcontest.dialog

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.voss.ithomeironcontest.BaseFragment
import com.voss.ithomeironcontest.databinding.FragmentDialogBinding

class NormalDialogFragment : BaseFragment<FragmentDialogBinding>(FragmentDialogBinding::inflate) {
    private val fullScreenDialogFragment by lazy { FullScreenDialogFragment() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.alertDialogBtn.setOnClickListener { showAlertDialog() }
        binding.simpleDialogBtn.setOnClickListener { showSimpleDialog() }
        binding.confirmationDialogBtn.setOnClickListener { showConfirmationDialog() }
        binding.multiChoiceBtn.setOnClickListener { showMultipleChoiceDialog() }
        binding.fullscreenDialogBtn.setOnClickListener {
            fullScreenDialogFragment.show(childFragmentManager, "FullScreen Dialog")
        }
    }

    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("AlterDialog")
            .setMessage("Dialog Body Message")
            .setPositiveButton("OK") { dialog, which ->
                // do something when press PositiveButton
            }
            .setNegativeButton("cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setNeutralButton("Neutral") { dialog, which ->
                // do somthing when press NeutralButton
            }.show()
    }

    private fun showSimpleDialog() {
        val items = arrayOf<String>("Item 1", "Item 2", "Item 3")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Simple Dialog")
            .setItems(items) { dialog, which ->
                // do something when click any items
            }.show()
    }

    private fun showConfirmationDialog() {
        val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItem = 1
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Confirmation")
            .setPositiveButton("OK") { dialog, which -> }
            .setNegativeButton("cancel") { dialog, which ->
                dialog.dismiss()
            }.setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->

            }.show()
    }

    private fun showMultipleChoiceDialog() {
        val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItems = booleanArrayOf(true, false, false, false)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("MultipleChoice")
            .setPositiveButton("OK") { dialog, which -> }
            .setNegativeButton("cancel") { dialog, which ->
                dialog.dismiss()
            }.setMultiChoiceItems(singleItems, checkedItems) { dialog, which, checked ->
                if (checked) Log.d("Multi-choice", "checked item :$which")
            }.show()
    }
}