package com.andrew10x.lab1kotlin2.db

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import com.andrew10x.lab1kotlin2.MainApp
import com.andrew10x.lab1kotlin2.R
import com.andrew10x.lab1kotlin2.entities.TicketItem
import kotlinx.coroutines.launch

class MainViewModel(dataBase: MainDataBase): ViewModel() {
    var resId: Long? = null
    val dao = dataBase.getDao()

    fun getAllTickets(): LiveData<List<TicketItem>> {
        return dao.getAllTickets().asLiveData()
    }
    fun insertTicket(ticket: TicketItem) = viewModelScope.launch {
        resId = null
        resId = dao.insertTicket(ticket)
        if(resId !== null)
        Log.d("MyLog", "Дані успішно додано")

    }
    fun deleteTicket(id: Int) = viewModelScope.launch {
        dao.deleteTicket(id)
    }

    class MainViewModelFactory(val dataBase: MainDataBase): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress( "UNCHECKED_CAST")
                return MainViewModel(dataBase) as T
            }
            throw IllegalArgumentException("Unknown viewmodel class")
        }

    }
}