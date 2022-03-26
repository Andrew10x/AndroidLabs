package com.andrew10x.lab1kotlin2.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrew10x.lab1kotlin2.entities.TicketItem


@Database (entities = [TicketItem::class], version = 1)
abstract class MainDataBase: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "train_info.db"
                ).build()
                instance
            }
        }
    }
}