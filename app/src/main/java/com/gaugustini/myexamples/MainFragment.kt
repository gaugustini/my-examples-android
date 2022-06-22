package com.gaugustini.myexamples

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gaugustini.myexamples.activity.ExampleActivity
import com.gaugustini.myexamples.bottomnavigation.BottomNavigationActivity
import com.gaugustini.myexamples.databinding.FragmentMainBinding
import com.gaugustini.myexamples.navigationdrawer.NavigationDrawerActivity

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonRecyclerView.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_recycler_view_fragment)
        }
        binding.buttonDialog.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_dialog_examples_fragment)
        }
        binding.buttonActivity.setOnClickListener {
            Intent(this.context, ExampleActivity::class.java).also {
                val randomNumber = (0..10).random()
                it.putExtra("EXTRA_RANDOM", randomNumber)
                startActivity(it)
            }
        }
        binding.buttonImplicitIntent.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_implicit_intent_fragment)
        }
        binding.buttonBottomNavigation.setOnClickListener {
            Intent(this.context, BottomNavigationActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.buttonNavigationDrawer.setOnClickListener {
            Intent(this.context, NavigationDrawerActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.buttonViewPager.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_view_pager_fragment)
        }
        binding.buttonDataStore.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_data_store_fragment)
        }
        binding.buttonNotification.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_notification_fragment)
        }
        binding.buttonService.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_service_fragment)
        }
        binding.buttonBroadcastReceiver.setOnClickListener {
            findNavController().navigate(R.id.action_main_fragment_to_broadcast_receiver_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
