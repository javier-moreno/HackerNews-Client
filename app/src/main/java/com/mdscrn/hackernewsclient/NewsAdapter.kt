package com.mdscrn.hackernewsclient

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by javiermoreno on 3/8/17.
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var items: ArrayList<ViewType>

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())

        items = ArrayList<ViewType>()
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

    fun getNews(): List<HackerNewsItem> = items.filter { it.getViewType() == AdapterConstants.NEWS }.map { it as HackerNewsItem }
}
