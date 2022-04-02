package com.liu.jetpackapplication.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(ignoredColumns = ["picture"])
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val age: Int?,
    val sex:String
) : ParentUser() {
    override fun toString(): String {
        return "User=[id=$id,name=$name,age=$age,sex=$sex]"
    }
}