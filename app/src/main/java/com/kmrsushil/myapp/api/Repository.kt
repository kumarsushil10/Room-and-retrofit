package com.kmrsushil.myapp.api

import com.kmrsushil.myapp.model.MyDao
import com.kmrsushil.myapp.model.MyDataModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class Repository @Inject constructor(private val myDao: MyDao,private val apiService: ApiService) {
    suspend fun getData() = apiService.getData()

    val getAllData: Flow<List<MyDataModelItem>> = myDao.getAllData()

    suspend fun insert(dataList: List<MyDataModelItem>) = withContext(Dispatchers.IO){
        myDao.insertItems(dataList)
    }
}