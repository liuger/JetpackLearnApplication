package com.liu.jetpackapplication.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.liu.jetpackapplication.model.Repo
import com.liu.jetpackapplication.repository.GithubRepository
import kotlinx.coroutines.flow.Flow

class GithubViewModel  constructor():ViewModel() {
    fun getPagingData(): Flow<PagingData<Repo>>{
        return GithubRepository.getPagingData().cachedIn(viewModelScope)
    }
}