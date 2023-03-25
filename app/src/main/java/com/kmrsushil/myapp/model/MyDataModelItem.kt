package com.kmrsushil.myapp.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "myData")
@Parcelize
data class MyDataModelItem(
    val body: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val userId: Int
): Parcelable {
    companion object {
        var diffCallback: DiffUtil.ItemCallback<MyDataModelItem> =
            object : DiffUtil.ItemCallback<MyDataModelItem>() {

                override fun areItemsTheSame(
                    oldItem: MyDataModelItem,
                    newItem: MyDataModelItem
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: MyDataModelItem,
                    newItem: MyDataModelItem
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}