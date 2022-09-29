package com.voss.ithomeironcontest.divider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.voss.ithomeironcontest.databinding.ItemviewDividerItemBinding

class DividerAdapter(private val size: Int) : Adapter<DividerAdapter.DividerViewHolder>() {
    inner class DividerViewHolder(private val binding: ItemviewDividerItemBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.dividerItemTv.text = "divider $position"
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DividerViewHolder {
        return DividerViewHolder(
            ItemviewDividerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DividerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return this.size
    }
}
