package com.liu.jetpackapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey
    @ColumnInfo(name="account_id")
    val accountId: Long,
    val name: String,
    val age: Int
)
