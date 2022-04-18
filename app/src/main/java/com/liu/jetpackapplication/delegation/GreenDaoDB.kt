package com.liu.jetpackapplication.delegation

class GreenDaoDB : DB {
    override fun save() {
        println("save to GreenDao")
    }
}

class UniversalDB(db: DB) : DB by db

open class A() {
    protected open fun test() {};
}

class B : A() {
     override fun test() {

    }
}