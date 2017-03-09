package com.mdscrn.hackernewsclient

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by javiermoreno on 3/9/17.
 */


class RestAPI {

    private val hackerNewsAPI : HackerNewsAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://hacker-news.firebaseio.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        hackerNewsAPI = retrofit.create(HackerNewsAPI::class.java)
    }

    fun getTopStories() : Call<List<Int>> = hackerNewsAPI.getTopStories()

    fun getStory(id: Int) : Call<HackerNewsStorieResponse> = hackerNewsAPI.getStory(id)
}