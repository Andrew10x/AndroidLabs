package com.andrew10x.lab1kotlin2.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andrew10x.lab1kotlin2.entities.TicketItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("select * from tickets")
    fun getAllTickets(): Flow<List<TicketItem>>

    @Insert
    suspend fun insertTicket(ticket: TicketItem):Long

    @Query ("delete from tickets where id is :id")
    suspend fun deleteTicket(id: Int)
}