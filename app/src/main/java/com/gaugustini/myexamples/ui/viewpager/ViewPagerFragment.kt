package com.gaugustini.myexamples.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaugustini.myexamples.databinding.FragmentViewPagerBinding
import com.gaugustini.myexamples.model.Example

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        setAdapter()

        return binding.root
    }

    private fun setAdapter() {
        val adapter = ViewPagerAdapter()
        binding.viewPager.adapter = adapter

        val list = buildList {
            for (i in 1..10) {
                add(Example("Example $i"))
            }
        }
        adapter.submitList(list)
    }

}
