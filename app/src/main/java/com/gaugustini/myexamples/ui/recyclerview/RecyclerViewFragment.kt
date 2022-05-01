package com.gaugustini.myexamples.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.databinding.FragmentRecyclerViewBinding
import com.gaugustini.myexamples.model.Example
import dagger.hilt.android.AndroidEntryPoint

/**
 * A Fragment that demonstrates how to use Recycler View.
 * layout: fragment_recycler_view.xml
 */
@AndroidEntryPoint
class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

        setAdapter()

        return binding.root
    }

    private fun setAdapter() {
        val adapter = ExampleAdapter(onClick = {})
        binding.listExample.adapter = adapter

        val list = buildList {
            for (i in 1..10) {
                add(Example("Example"))
            }
        }
        adapter.submitList(list)
    }

}
