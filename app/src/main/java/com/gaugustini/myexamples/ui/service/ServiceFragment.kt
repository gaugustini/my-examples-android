package com.gaugustini.myexamples.ui.service

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.databinding.FragmentServiceBinding

class ServiceFragment : Fragment() {

    private lateinit var binding: FragmentServiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonStart.setOnClickListener {
            Intent(requireContext(), MyService::class.java).also {
                requireContext().startService(it)
                binding.textService.text = "Service Running..."
            }
        }
        binding.buttonStop.setOnClickListener {
            Intent(requireContext(), MyService::class.java).also {
                requireContext().stopService(it)
                binding.textService.text = "Service Stopped"
            }
        }
        binding.buttonSend.setOnClickListener {
            Intent(requireContext(), MyService::class.java).also {
                val dataString = binding.textData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                requireContext().startService(it)
                binding.textService.text = "Service Running..."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

}
