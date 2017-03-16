package com.mdscrn.hackernewsclient.api.data

import com.mdscrn.hackernewsclient.news.newsdelegatesadapters.NewsAdapterConstants
import com.mdscrn.hackernewsclient.news.newsdelegatesadapters.NewsViewType

/**
 * Created by javiermoreno on 3/8/17.
 */

data class HackerNewsItem(var author: String, var title: String, var score: Int, var comments: Int, var url: String?, var time: Long, var type: String) : NewsViewType {
    override fun getViewType() = NewsAdapterConstants.NEWS
}