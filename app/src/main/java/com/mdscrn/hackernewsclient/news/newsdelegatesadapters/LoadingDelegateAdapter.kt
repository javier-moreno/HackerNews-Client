package com.mdscrn.hackernewsclient.news.newsdelegatesadapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.R
import com.mdscrn.hackernewsclient.commons.inflate

/**
 * Created by javiermoreno on 3/8/17.
 */
class LoadingDelegateAdapter : NewsViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: NewsViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}