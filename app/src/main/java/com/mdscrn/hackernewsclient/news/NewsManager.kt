package com.mdscrn.hackernewsclient.news

import android.util.Log
import com.mdscrn.hackernewsclient.api.RestAPI
import com.mdscrn.hackernewsclient.api.data.HackerNewsItem
import com.mdscrn.hackernewsclient.api.data.HackerNewsStorieResponse
import com.mdscrn.hackernewsclient.api.data.NewsType
import rx.Observable

/**
 * Created by javiermoreno on 3/8/17.
 */

class NewsManager(private val newsType: NewsType) {

    val pageSize = 30
    val TAG: String by lazy { javaClass.simpleName }
    var startIndex: Int = 0
    var storiesIds: List<Int>? = null


    fun getNews() : Observable<List<HackerNewsItem>> {
        return Observable.create {
            subscriber ->

            val restAPI = RestAPI()

            if (storiesIds == null) {

                when (newsType) {
                    NewsType.Ask -> storiesIds = restAPI.getAskStories().execute().body()
                    NewsType.Job -> storiesIds = restAPI.getJobStories().execute().body()
                    NewsType.Show -> storiesIds = restAPI.getShowStories().execute().body()
                    NewsType.Top -> storiesIds = restAPI.getTopStories().execute().body()
                }


            }

            val stories = mutableListOf<HackerNewsStorieResponse>()

            for (i in startIndex..startIndex + pageSize) {
                if (i >= storiesIds!!.count()) {
                    break
                }

                val story = restAPI.getStory(storiesIds!![i]).execute().body()
                stories.add(story)
                Log.d(TAG, "$i $story.toString()")
            }

            if(startIndex < storiesIds!!.count())
                startIndex += (pageSize + 1)

            val news = stories.map { HackerNewsItem(it.by, it.title, it.score, it.descendants, it.url, it.time) }

            subscriber.onNext(news)
            subscriber.onCompleted()
        }
    }
}
