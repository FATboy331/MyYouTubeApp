package com.geektech.myyoutubeapp.remote

import com.geektech.myyoutubeapp.model.PlayLists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query("part") part : String,
        @Query("channelId") channelId : String,
        @Query("key") key : String,
    ): Call<PlayLists>
}