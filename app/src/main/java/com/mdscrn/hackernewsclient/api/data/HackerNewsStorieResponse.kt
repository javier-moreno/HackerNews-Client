package com.mdscrn.hackernewsclient.api.data

/**
 * Created by javiermoreno on 3/9/17.
 */

data class HackerNewsStorieResponse(val by: String, val title: String, val url: String, var descendants: Int, val type: String, val time: Long, val score: Int)