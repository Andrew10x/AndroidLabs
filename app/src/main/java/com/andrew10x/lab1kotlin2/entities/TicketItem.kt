package com.andrew10x.lab1kotlin2.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity (tableName = "tickets")
data class TicketItem(
    @PrimaryKey (autoGenerate = true)
    val id: Int?,

    @ColumnInfo (name = "cityFrom")
    val cityFrom: String,

    @ColumnInfo (name="cityTo")
    val cityTo: String,

    @ColumnInfo (name="time")
    val time: String
): Serializable
