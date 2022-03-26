package com.andrew10x.lab1kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrew10x.lab1kotlin2.databinding.ActivityTicketsBinding
import com.andrew10x.lab1kotlin2.db.MainViewModel
import com.andrew10x.lab1kotlin2.db.TicketItemAdapter
import com.andrew10x.lab1kotlin2.entities.TicketItem

class TicketsActivity : AppCompatActivity(), TicketItemAdapter.Listener {
    private lateinit var binding: ActivityTicketsBinding
    private var adapter: TicketItemAdapter ?= null
    private  val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRcView()
        listItemObserver()
    }

    private fun listItemObserver() {
        mainViewModel.getAllTickets().observe(this) {
            adapter?.submitList(it)
            if(it.isEmpty()) {
                binding.tvEmpty.visibility = View.VISIBLE
            } else {
                binding.tvEmpty.visibility = View.GONE
            }
        }
    }

    private fun initRcView() = with(binding) {
        adapter = TicketItemAdapter(this@TicketsActivity)
        rcView.layoutManager = LinearLayoutManager(this@TicketsActivity)
        rcView.adapter = adapter
    }

    override fun deleteItem(id: Int) {
        mainViewModel.deleteTicket(id)
    }
}