package com.example.desafios10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _dataLiveData = MutableLiveData<String>()

    val dataLiveData:LiveData<String>get() = _dataLiveData

    fun setData(data:String){
        _dataLiveData.value = data
    }

}