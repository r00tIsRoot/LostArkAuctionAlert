package com.isroot.lostarkauctionalert.data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApiKey(
    var apiName: String,
    var apiKey: String,
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
