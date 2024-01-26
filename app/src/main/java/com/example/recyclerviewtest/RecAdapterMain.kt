package com.example.recyclerviewtest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.databinding.ItemSampleRecviewBinding

class RecAdapterMain() : RecyclerView.Adapter<RecAdapterMain.ItemHolder>() {
    var itemsList = ArrayList<DataItem>()

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemSampleRecviewBinding.bind(itemView)
        fun bind(itemData: DataItem) {
            binding.apply {
                textViewTitleItem.text = itemData.title
                imageViewItem.setImageResource(itemData.imageId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sample_recview, parent, false)

        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(itemData: DataItem) {
        itemsList.add(itemData)
        notifyDataSetChanged()
    }
}