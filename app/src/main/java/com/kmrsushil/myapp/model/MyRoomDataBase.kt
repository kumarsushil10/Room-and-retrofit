package com.kmrsushil.myapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyDataModelItem::class], version = 1, exportSchema = false)
abstract class MyRoomDataBase : RoomDatabase(){

    abstract fun myDao(): MyDao
}