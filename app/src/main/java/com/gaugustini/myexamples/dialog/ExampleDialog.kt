package com.gaugustini.myexamples.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gaugustini.myexamples.R
import com.gaugustini.myexamples.databinding.DialogExampleBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ExampleDialog : DialogFragment() {

    private lateinit var binding: DialogExampleBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogExampleBinding.inflate(layoutInflater)
        return MaterialAlertDialogBuilder(requireContext())
            .setView(binding.root)
            .setPositiveButton(getString(R.string.accept)) { _, _ -> }
            .setNegativeButton(getString(R.string.decline)) { _, _ -> }
            .create()
    }

}
