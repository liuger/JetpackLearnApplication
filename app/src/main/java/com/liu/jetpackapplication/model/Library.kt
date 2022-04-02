package com.liu.jetpackapplication.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Library(
    @PrimaryKey
    @ColumnInfo(name = "library_id")
    val libraryId: Long,
    @ColumnInfo(name = "owner_id")
    val ownerId: Long
)
