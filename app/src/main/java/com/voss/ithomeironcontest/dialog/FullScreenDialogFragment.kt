package com.voss.ithomeironcontest.dialog

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import com.voss.ithomeironcontest.R
import com.voss.ithomeironcontest.databinding.FragmentFullScreenDialogBinding
import java.util.*

class FullScreenDialogFragment :
    BaseDialogFragment<FragmentFullScreenDialogBinding>(FragmentFullScreenDialogBinding::inflate) {
    private val calendar = Calendar.getInstance(Locale.TAIWAN)
    private val datePickerListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            binding.editEventCalendarTv.setText("Date: $year/${month + 1}/$dayOfMonth")
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDropdownMenu()
        binding.fullscreenDialogTb.setNavigationOnClickListener {
            showCancelAlertDialog()
        }
    }

    private fun setDropdownMenu() {
        binding.editEventCalendarTv.inputType = InputType.TYPE_NULL
        binding.editEventCalendarTv.setOnClickListener {
            val currentYear = calendar.get(Calendar.YEAR)
            val currentMonth = calendar.get(Calendar.MONTH)
            val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
            showDatePickerDialog(currentYear, currentMonth, currentDay)
        }
    }

    private fun showDatePickerDialog(year: Int, month: Int, day: Int) {
        DatePickerDialog(requireContext(), datePickerListener, year, month - 1, day).show()
    }

    private fun showCancelAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Message")
            .setMessage("是否要離開編輯")
            .setPositiveButton("Yes") { _, _ ->
                dismiss()
            }.setNegativeButton("no", null)
            .show()
    }

    override fun onDismiss(dialog: DialogInterface) {
        binding.editEventCalendarTv.setText("設定活動時間")
        super.onDismiss(dialog)
    }
}