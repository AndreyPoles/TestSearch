package com.search.searchimages.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class ImageData(
    val Name: String,
    val profilePhoto: Bitmap
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}