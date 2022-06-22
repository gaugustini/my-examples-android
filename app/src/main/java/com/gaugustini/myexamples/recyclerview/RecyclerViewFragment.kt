package com.gaugustini.myexamples.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.databinding.FragmentRecyclerViewBinding
import com.gaugustini.myexamples.util.Example

class RecyclerViewFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

        setAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAdapter() {
        val adapter = ExampleAdapter(onClick = {})
        binding.listExample.adapter = adapter

        val list = buildList {
            for (i in 1..10) {
                add(Example("Example $i"))
            }
        }
        adapter.submitList(list)
    }

}
