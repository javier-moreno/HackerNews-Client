package com.mdscrn.hackernewsclient.news.newsdelegatesadapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by javiermoreno on 3/8/17.
 */
interface NewsViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: NewsViewType)
}