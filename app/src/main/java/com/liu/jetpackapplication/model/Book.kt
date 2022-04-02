package com.liu.jetpackapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "user_id")
    val userId: Int
)
