package com.gaugustini.myexamples.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaugustini.myexamples.databinding.DialogBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ExampleBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DialogBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

}
