package com.gaugustini.myexamples.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.databinding.FragmentBroadcastReceiverBinding

class BroadcastReceiverFragment : Fragment() {

    private lateinit var receiver: AirplaneModeChangedReceiver
    private var _binding: FragmentBroadcastReceiverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBroadcastReceiverBinding.inflate(inflater, container, false)

        receiver = AirplaneModeChangedReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireContext().registerReceiver(receiver, it)
        }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        requireContext().unregisterReceiver(receiver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
