package com.kmrsushil.myapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kmrsushil.myapp.databinding.ItemLayoutBinding
import com.kmrsushil.myapp.model.MyDataModelItem

class MainAdapter:ListAdapter<MyDataModelItem,RecyclerView.ViewHolder>(MyDataModelItem.diffCallback) {

    private lateinit var binding: ItemLayoutBinding
    var onItemClick: ((MyDataModelItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(getItem(position))
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(getItem(position))
            }
        }
    }

    class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelItem: MyDataModelItem) {
          binding.title.text = modelItem.title
        }
    }
}