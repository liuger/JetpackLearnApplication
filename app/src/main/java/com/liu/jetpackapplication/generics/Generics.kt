package com.liu.jetpackapplication.generics

class Generics {
    lateinit var university:University<Student>
    fun test(){
        university=University<FemaleStudent>("女子大学")
    }
}