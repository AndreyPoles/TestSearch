package com.search.searchimages.api

import com.search.searchimages.model.Images
import retrofit2.http.GET
import retrofit2.http.Query

const val tag = "cat"

//https://api.giphy.com/v1/gifs/
// search?api_key=CUNns9NzEbzqrt7Ctx0BlCtlJ6ULvZPs&q=deadpool&limit=25&offset=0&rating=g&lang=en

interface ImagesAPI {

    @GET("v1/gifs/search")
    suspend fun getPost(
        @Query("api_key") apiKey: String,
        @Query("q") q: String = tag,
        @Query("limit") limit: String ,
        @Query("offset") offset: String ,
        @Query("rating") rating: String ,
        @Query("lang") lang: String
    ): Images

}