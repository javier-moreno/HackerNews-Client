package com.mdscrn.hackernewsclient

import android.util.Log
import rx.Observable

/**
 * Created by javiermoreno on 3/8/17.
 */

class NewsManager {

    val TAG: String by lazy { javaClass.simpleName }

    fun getNews() : Observable<List<HackerNewsItem>> {
        return Observable.create {
            subscriber ->

            val restAPI = RestAPI()
            val storiesIds = restAPI.getTopStories().execute().body()
            Log.d(TAG, storiesIds.toString())

            val stories = mutableListOf<HackerNewsStorieResponse>()

            for (storyId in storiesIds) {
                if(stories.count() == 20) {
                    val news = stories.map { HackerNewsItem(it.by, it.title) }
                    subscriber.onNext(news)

                    stories.clear()
                }

                val story = restAPI.getStory(storyId).execute().body()
                stories.add(story)
                Log.d(TAG, story.toString())
            }


            subscriber.onCompleted()
        }
    }
}
