package com.gaugustini.myexamples.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gaugustini.myexamples.R
import com.gaugustini.myexamples.databinding.FragmentDialogExamplesBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogExamplesFragment : Fragment() {

    private var _binding: FragmentDialogExamplesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogExamplesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonSimpleDialog.setOnClickListener {
            showSimpleDialog()
        }
        binding.buttonCustomDialog.setOnClickListener {
            findNavController().navigate(R.id.action_dialog_examples_fragment_to_dialog_example)
        }
        binding.buttonBottomSheetDialog.setOnClickListener {
            findNavController().navigate(R.id.action_dialog_examples_fragment_to_dialog_bottom_sheet)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showSimpleDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(getString(R.string.medium_message))
            .setNegativeButton(getString(R.string.decline)) { _, _ -> }
            .setPositiveButton(getString(R.string.accept)) { _, _ -> }
            .show()
    }

}
