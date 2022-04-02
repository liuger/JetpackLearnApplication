package com.liu.jetpackapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Loan(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "book_id")
    val bookId: Int,
    @ColumnInfo(name = "user_id")
    val userId: Int
)
