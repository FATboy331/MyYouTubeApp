package com.geektech.myyoutubeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.geektech.myyoutubeapp.BuildConfig
import com.geektech.myyoutubeapp.model.PlayLists
import com.geektech.myyoutubeapp.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val apiService = RetrofitClient.create()

    fun getPlayList(): LiveData<PlayLists> {

        return createCall()
    }

    private fun createCall(): LiveData<PlayLists> {
        val data = MediatorLiveData<PlayLists>()

        apiService.getPlaylist(
            "snippet,contentDetails",
            "UCDF_NIAEkcAUvzxe1DUzaQA",
            BuildConfig.API_KEY
        ).enqueue(
            object : Callback<PlayLists> {
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    print(t.stackTrace)
                }

            }
        )
        return data
    }
}