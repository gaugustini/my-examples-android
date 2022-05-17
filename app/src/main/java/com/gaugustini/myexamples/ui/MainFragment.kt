package com.gaugustini.myexamples.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gaugustini.myexamples.R
import com.gaugustini.myexamples.databinding.FragmentMainBinding
import com.gaugustini.myexamples.ui.activity.ExampleActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * A Fragment as the default destination in the navigation.
 */
@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
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
    }

}
