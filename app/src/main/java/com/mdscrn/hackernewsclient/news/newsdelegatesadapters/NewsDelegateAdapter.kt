package com.mdscrn.hackernewsclient.news.newsdelegatesadapters

import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.R
import com.mdscrn.hackernewsclient.api.data.HackerNewsItem
import com.mdscrn.hackernewsclient.commons.getFriendlyTime
import com.mdscrn.hackernewsclient.commons.inflate
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
        holder.setEvents(item)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {

        fun bind(item: HackerNewsItem) = with(itemView) {
            news_title.text = item.title
            val author = item.author
            val time = item.time.getFriendlyTime()
            news_author.text = "$author - $time"
            news_score.text = item.score.toString()
            news_comments.text = item.comments.toString()
            news_container.setBackgroundColor( if (item.type.startsWith("job", ignoreCase = true)) ContextCompat.getColor(context, R.color.colorPrimary) else if (item.title.startsWith("show", ignoreCase = true)) ContextCompat.getColor(context, R.color.showBackground) else if (item.title.startsWith("ask", ignoreCase = true)) ContextCompat.getColor(context, R.color.askBackground) else ContextCompat.getColor(context, R.color.newsBackground) )
         }

        fun setEvents(item: HackerNewsItem) = with(itemView) {
            if (item.url != null) {
                news_title.setOnClickListener {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                    context.startActivity(browserIntent)
                }
            }
        }
    }
}
