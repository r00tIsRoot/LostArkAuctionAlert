package com.isroot.lostarkauctionalert.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.isroot.lostarkauctionalert.data.DAO.ApiKeyDao
import com.isroot.lostarkauctionalert.data.Entities.ApiKey

@Database(entities = [ApiKey::class], version = 1)
abstract class L1A3DB: RoomDatabase() {
    abstract fun apiKeyDao(): ApiKeyDao

    companion object {
        private var instance: L1A3DB? = null

        @Synchronized
        fun getInstance(context: Context): L1A3DB? {
            if(instance == null) {
                synchronized(L1A3DB::class.java){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        L1A3DB::class.java,
                        "l1a3_database"
                    ).build()
                }
            }
            return instance
        }
    }
}