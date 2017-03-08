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

        items = ArrayList<ViewType>()
        items.add(loadingItem)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}