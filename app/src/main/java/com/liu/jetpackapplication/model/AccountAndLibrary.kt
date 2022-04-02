package com.liu.jetpackapplication.model

import androidx.room.Embedded
import androidx.room.Relation

data class AccountAndLibrary(
    @Embedded
    val account: Account,
    @Relation(parentColumn = "account_id", entityColumn = "owner_id")
    val library: Library)
