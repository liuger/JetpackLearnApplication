package com.liu.jetpackapplication.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.liu.jetpackapplication.model.Repo
import com.liu.jetpackapplication.service.GithubService

private const val GITHUB_STARTING_PAGE_INDEX = 1

class GithubPagingSource(private val githubService: GithubService) : PagingSource<Int, Repo>() {
    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        val currentPage = params.key ?: GITHUB_STARTING_PAGE_INDEX
        val pageSize = params.loadSize
        val repoResponse = githubService.searchRepos(currentPage, pageSize)
        val items = repoResponse.items
        val prevKey = if (currentPage > 1) currentPage - 1 else null
        val nextKey = if (items.isNotEmpty()) currentPage + 1 else null
        return LoadResult.Page(items, prevKey, nextKey)
    }
}