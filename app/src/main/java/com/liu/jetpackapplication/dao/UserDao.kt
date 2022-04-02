package com.liu.jetpackapplication.dao

import androidx.room.Dao
import androidx.room.Query
import com.liu.jetpackapplication.model.NameTuple
import com.liu.jetpackapplication.model.User

@Dao
interface UserDao : BaseDao<User> {
    @Query("select * from user")
    fun getAll(): List<User>

    @Query("select * from user where id in (:uIds)")
    fun loadAllByIds(uIds: IntArray): List<User>

    @Query("select * from user where name like :name limit 1")
    fun findByName(name: String): User

//    @Query("select first_name,last_name from user")
//    fun loadFullName(): List<NameTuple>

}