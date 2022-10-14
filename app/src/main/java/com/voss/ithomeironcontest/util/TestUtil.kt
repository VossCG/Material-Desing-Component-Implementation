package com.voss.ithomeironcontest.util

import android.content.Context
import android.widget.Toast

fun showToast(context: Context,message:String):Unit = Toast.makeText(context,message,Toast.LENGTH_SHORT).show()