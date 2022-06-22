package com.gaugustini.myexamples.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gaugustini.myexamples.databinding.ListItemViewPagerBinding
import com.gaugustini.myexamples.util.DiffCallback
import com.gaugustini.myexamples.util.Example

class ViewPagerAdapter :
    ListAdapter<Example, ViewPagerAdapter.ViewPagerViewHolder>(DiffCallback<Example>()) {

    class ViewPagerViewHolder(
        private val binding: ListItemViewPagerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Example) {
            binding.apply {
                example = item
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(
            ListItemViewPagerBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val example = getItem(position)
        holder.bind(example)
    }

}
