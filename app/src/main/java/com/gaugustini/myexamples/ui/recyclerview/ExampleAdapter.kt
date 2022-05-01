package com.gaugustini.myexamples.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gaugustini.myexamples.databinding.ListItemExampleBinding
import com.gaugustini.myexamples.model.Example

class ExampleAdapter(private val onClick: (Example) -> Unit) :
    ListAdapter<Example, ExampleAdapter.ExampleViewHolder>(DiffCallback<Example>()) {

    class ExampleViewHolder(
        private val binding: ListItemExampleBinding,
        val onClick: (Example) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                card.setOnClickListener { onClick(binding.example!!) }
            }
        }

        fun bind(item: Example) {
            binding.apply {
                example = item
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder(
            ListItemExampleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false), onClick
        )
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val example = getItem(position)
        holder.bind(example)
    }

}
