package com.mdscrn.hackernewsclient.news.newsdelegatesadapters

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.api.data.HackerNewsItem

/**
 * Created by javiermoreno on 3/8/17.
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<NewsViewTypeDelegateAdapter>()
    private var items: ArrayList<NewsViewType>

    private val loadingItem = object : NewsViewType {
        override fun getViewType() = NewsAdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(NewsAdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(NewsAdapterConstants.NEWS, NewsDelegateAdapter())

        items = ArrayList<NewsViewType>()
        items.add(loadingItem)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = delegateAdapters.get(viewType).onCreateViewHolder(parent!!)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder!!, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addNews(news: List<HackerNewsItem>) {
        val initPosition = items.size - 1
        items.removeAt(initPosition)

        notifyItemRemoved(initPosition)

        items.addAll(initPosition, news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, news.size + 1)
    }

    fun getNews(): List<HackerNewsItem> = items.filter { it.getViewType() == NewsAdapterConstants.NEWS }.map { it as HackerNewsItem }
}
