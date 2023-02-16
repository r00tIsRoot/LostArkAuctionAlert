package com.isroot.lostarkauctionalert.data.DAO

import androidx.room.*
import com.isroot.lostarkauctionalert.data.Entities.ApiKey

@Dao
interface ApiKeyDao {
    @Insert
    fun insert(apiKey: ApiKey)

    @Update
    fun update(apiKey: ApiKey)

    @Delete
    fun delete(apiKey: ApiKey)


    @Query("SELECT * FROM ApiKey") // 테이블의 모든 값을 가져와라
    fun getAll(): List<ApiKey>

    @Query("SELECT apiKey FROM ApiKey WHERE apiName = :name")
    fun getApiKeyByName(name: String): String

    @Query("DELETE FROM ApiKey WHERE apiName = :name") // 'name'에 해당하는 유저를 삭제해라
    fun deleteApiKeyByName(name: String)
}