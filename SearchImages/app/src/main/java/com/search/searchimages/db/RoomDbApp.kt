package com.search.searchimages.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.search.searchimages.Converters
import com.search.searchimages.model.ImageData

@Database(entities = [ImageData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomDbApp : RoomDatabase() {

//    abstract fun myDao(): MyDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDbApp? = null

        fun getDatabase(context: Context): RoomDbApp =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RoomDbApp::class.java, "my_database"
            ).build()
    }
}