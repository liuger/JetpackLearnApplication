package com.liu.jetpackapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
@Dao
interface BaseDao<T> {
    @Insert
    fun insert(vararg obj:T)
    @Insert
    fun insert( obj:List<T>)
    @Update
    fun update( obj:T)
    @Delete
    fun delete( obj:T)

}