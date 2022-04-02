package com.liu.jetpackapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liu.jetpackapplication.model.User
import com.liu.jetpackapplication.model.UserRepository

class UserListViewModel:ViewModel() {
    var userListViewModel=MutableLiveData<User>()
    var loadingLiveData=MutableLiveData<Boolean>()
    fun getUserInfo(){
        loadingLiveData.value=true
//        userListViewModel.value=UserRepository.getUserFromServer()
    }

}