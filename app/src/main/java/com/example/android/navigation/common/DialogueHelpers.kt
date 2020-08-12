package com.example.android.navigation.common

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.android.navigation.R

fun showGeneralError(from: Context) {
    AlertDialog.Builder(from)
            .setTitle(from.getString(R.string.error_title))
            .setMessage(from.getString(R.string.error_message))
            .setPositiveButton(from.getString(R.string.general_positive_button), { dialog, _ -> dialog.dismiss() })
            .show()
}