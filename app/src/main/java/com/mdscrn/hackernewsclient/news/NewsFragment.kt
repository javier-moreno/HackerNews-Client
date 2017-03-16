package com.mdscrn.hackernewsclient.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.InfiniteScrollListener
import com.mdscrn.hackernewsclient.R
import com.mdscrn.hackernewsclient.api.data.NewsType
import com.mdscrn.hackernewsclient.commons.inflate
import com.mdscrn.hackernewsclient.news.newsdelegatesadapters.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment (val newsType: NewsType) : Fragment() {

    private val TAG by lazy { javaClass.canonicalName }
    private val newsManager by lazy { NewsManager(newsType) }

    var subscriptions = CompositeSubscription()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list.addOnScrollListener(InfiniteScrollListener({ requestNews() }, news_list.layoutManager as LinearLayoutManager))

        initAdapter()

        if(savedInstanceState == null)
            requestNews()
    }

    override fun onResume() {
        super.onResume()

        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()

        if(!subscriptions.isUnsubscribed){
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }

    fun initAdapter() {
        if (news_list.adapter == null)
            news_list.adapter = NewsAdapter()
    }

    fun requestNews() {
        val subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    retrievedNews ->

                    (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                },
                {
                    e ->

                    Log.d(TAG, "Error retrieving news: $e")
                })

        subscriptions.add(subscription)
    }
}
