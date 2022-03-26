package com.andrew10x.lab1kotlin2.db

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrew10x.lab1kotlin2.R
import com.andrew10x.lab1kotlin2.databinding.TicketItemBinding
import com.andrew10x.lab1kotlin2.entities.TicketItem

class TicketItemAdapter(private val listener: Listener): ListAdapter<TicketItem, TicketItemAdapter.ItemHolder>(ItemComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = TicketItemBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun setData(ticket: TicketItem, listener: Listener) {
            binding.ticketItem.text = "від: " + ticket.cityFrom + ", до: " + ticket.cityTo +
                    ", час: " + ticket.time
            binding.imDelete.setOnClickListener{
                listener.deleteItem(ticket.id!!)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.ticket_item, parent, false)
                )
            }
        }
    }

    class ItemComparator: DiffUtil.ItemCallback<TicketItem>() {
        override fun areItemsTheSame(oldItem: TicketItem, newItem: TicketItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TicketItem, newItem: TicketItem): Boolean {
            return oldItem == newItem
        }

    }

    interface Listener {
        fun deleteItem(id: Int)
    }
}