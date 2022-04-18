package com.liu.jetpackapplication.delegation

class SqlDB() : DB {
    override fun save() {
        println("save to sql")
    }
}