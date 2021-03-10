package com.search.searchimages.repository

import com.search.searchimages.api.RetrofitInstance
import com.search.searchimages.model.Images

class Repository {

    val API_KEY = "CUNns9NzEbzqrt7Ctx0BlCtlJ6ULvZPs"

    suspend fun getPost(tag: String): Images {
        return RetrofitInstance.api.getPost(API_KEY, tag, "25", "0", "g", "en")
    }

}