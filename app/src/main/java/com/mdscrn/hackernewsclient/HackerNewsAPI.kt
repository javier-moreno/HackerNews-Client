package com.mdscrn.hackernewsclient

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by javiermoreno on 3/9/17.
 */

interface HackerNewsAPI {
    @GET("/v0/topstories.json")
    fun getTopStories() : Call<List<Int>>

    @GET("/v0/item/{id}.json")
    fun getStory(@Path("id") id: Int) : Call<HackerNewsStorieResponse>
}