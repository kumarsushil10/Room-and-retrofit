package com.kmrsushil.myapp.ui

import android.util.Log
import androidx.lifecycle.*
import com.kmrsushil.myapp.api.Repository
import com.kmrsushil.myapp.model.MyDataModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val data = MutableLiveData<List<MyDataModelItem>>()

    fun getData() {
        viewModelScope.launch() {
            val response = repository.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    data.postValue(it)
                    Log.i("MainViewModel",it.toString())
                }
            }else{
                Log.e("MainViewModel",response.message())
            }
        }
    }

    val getAllData:LiveData<List<MyDataModelItem>> = repository.getAllData
        .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)

    fun insert(modelItemList: List<MyDataModelItem>) =viewModelScope.launch {
        repository.insert(modelItemList)
    }
}