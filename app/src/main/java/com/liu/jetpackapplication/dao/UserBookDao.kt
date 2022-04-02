package com.liu.jetpackapplication.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.MapInfo
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import com.liu.jetpackapplication.model.Book
import com.liu.jetpackapplication.model.User
import com.liu.jetpackapplication.model.UserBook

@Dao
interface UserBookDao {
//    @RewriteQueriesToDropUnusedColumns
//    @SuppressWarnings
//    @Query(
//        "select * from book" +
//                " inner join loan on loan.book_id=book.id " +
//                "inner join user on user.id=loan.user_id" +
//                " where user.name like :username"
//    )
//    fun loadUserAndBookNames(username: String): List<Book>
//
//    @RewriteQueriesToDropUnusedColumns
//    @SuppressWarnings
//    @Query("select user.name as userName,book.name as bookName from user,book where user.id = book.user_id")
//    fun loadUserAndBookNames(): List<UserBook>
//
//    @Query("select * from user join book on user_id=book.user_id")
//    fun loadUserAndBookNames1(): Map<User, List<Book>>
//
//    @RewriteQueriesToDropUnusedColumns
//    @SuppressWarnings
//    @MapInfo(keyColumn = "first_name", valueColumn = "book_name")
//    @Query("select user.name as username ,book.name as bookname from user join book on user.id=book.user_id")
//    fun loadUserAndBookNames2(): Map<String, List<String>>
//
//    fun pagingSource(query:String):PagingSource<Int,User>


}