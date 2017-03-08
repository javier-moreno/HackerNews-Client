package com.mdscrn.hackernewsclient

import rx.Observable

/**
 * Created by javiermoreno on 3/8/17.
 */

class NewsManager {

    fun getNews() : Observable<List<HackerNewsItem>> {
        return Observable.create {
            subscriber ->

            val news = (2..20).map { HackerNewsItem("Author $it", "Title $it") }
            subscriber.onNext(news)
        }
    }
}
