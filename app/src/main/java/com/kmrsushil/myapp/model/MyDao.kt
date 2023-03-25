package com.kmrsushil.myapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems(myDataModelItemList: List<MyDataModelItem>)

    @Query("SELECT * FROM myData ORDER BY id ASC")
    fun getAllData(): Flow<List<MyDataModelItem>>

}