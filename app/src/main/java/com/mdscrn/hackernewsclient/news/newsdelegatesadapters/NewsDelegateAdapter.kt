package com.mdscrn.hackernewsclient.news.newsdelegatesadapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.R
import com.mdscrn.hackernewsclient.commons.inflate
import com.mdscrn.hackernewsclient.api.data.HackerNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by javiermoreno on 3/8/17.
 */

class NewsDelegateAdapter : NewsViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: NewsViewType) {
        holder as TurnsViewHolder
        holder.bind(item as HackerNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {

        fun bind(item: HackerNewsItem) = with(itemView) {
            news_title.text = item.title
            news_author.text = item.author
        }
    }
}