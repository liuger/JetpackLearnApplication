package com.liu.jetpackapplication.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.liu.jetpackapplication.dao.UserBookDao
import com.liu.jetpackapplication.dao.UserDao
import com.liu.jetpackapplication.model.Book
import com.liu.jetpackapplication.model.Loan
import com.liu.jetpackapplication.model.User
import java.util.concurrent.Executors

@Database(entities = [User::class,Loan::class, Book::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UserDao

    abstract fun userBookDao():UserBookDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = buildDatabase(context)
                    }
                }

            }
            return instance!!
        }

        val DEFAULT_STUDENT = listOf(User(0, "xiao",1,"boy"))
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "db_demo.db"
            ).addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    //插入默认数据
                    Executors.newSingleThreadExecutor().execute {
                        getInstance(context).userDao().insert(DEFAULT_STUDENT)
                    }
                }
            }).allowMainThreadQueries().build()

    }
}