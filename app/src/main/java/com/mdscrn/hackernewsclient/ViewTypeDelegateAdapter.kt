package com.mdscrn.hackernewsclient

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by javiermoreno on 3/8/17.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}