package com.mdscrn.hackernewsclient

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.commons.inflate

/**
 * Created by javiermoreno on 3/8/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}