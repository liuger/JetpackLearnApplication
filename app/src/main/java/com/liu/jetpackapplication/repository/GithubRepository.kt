package com.liu.jetpackapplication.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.liu.jetpackapplication.model.Repo
import com.liu.jetpackapplication.paging.GithubPagingSource
import com.liu.jetpackapplication.service.GithubService
import kotlinx.coroutines.flow.Flow

object GithubRepository {
    private const val PAGE_SIZE = 30
    private val githubService = GithubService.create()
    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(config = PagingConfig(PAGE_SIZE), pagingSourceFactory = {
            GithubPagingSource(
                githubService
            )
        }).flow
    }
}