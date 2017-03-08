package com.mdscrn.hackernewsclient.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by javiermoreno on 3/8/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}