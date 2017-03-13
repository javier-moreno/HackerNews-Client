package com.mdscrn.hackernewsclient.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by javiermoreno on 3/8/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Long.getFriendlyTime(): String {
    val dateTime = Date(this * 1000)
    val sb = StringBuffer()
    val current = Calendar.getInstance().time
    var diffInSeconds = ((current.time - dateTime.time) / 1000).toInt()

    val sec = if (diffInSeconds >= 60) (diffInSeconds % 60).toInt() else diffInSeconds.toInt()
    diffInSeconds = diffInSeconds / 60
    val min = if (diffInSeconds >= 60) (diffInSeconds % 60).toInt() else diffInSeconds.toInt()
    diffInSeconds = diffInSeconds / 60
    val hrs = if (diffInSeconds >= 24) (diffInSeconds % 24).toInt() else diffInSeconds.toInt()
    diffInSeconds = diffInSeconds / 24
    val days = if (diffInSeconds >= 30) (diffInSeconds % 30).toInt() else diffInSeconds.toInt()
    diffInSeconds = diffInSeconds / 30
    var months = if (diffInSeconds >= 12) (diffInSeconds % 12).toInt() else diffInSeconds.toInt()
    diffInSeconds = diffInSeconds / 12
    val years = diffInSeconds.toInt()

    if (years > 0) {
        if (years == 1) {
            sb.append("1 y")
        } else {
            sb.append("$years y")
        }
        if (years <= 6 && months > 0) {
            if (months == 1) {
                sb.append(" 1 m")
            } else {
                sb.append(" $months m")
            }
        }
    } else if (months > 0) {
        if (months == 1) {
            sb.append("1 m")
        } else {
            sb.append("$months m")
        }
        if (months <= 6 && days > 0) {
            if (days == 1) {
                sb.append(" 1 d")
            } else {
                sb.append(" $days d")
            }
        }
    } else if (days > 0) {
        if (days == 1) {
            sb.append("1 d")
        } else {
            sb.append("$days d")
        }
        if (days <= 3 && hrs > 0) {
            if (hrs == 1) {
                sb.append(" 1 h")
            } else {
                sb.append(" $hrs h")
            }
        }
    } else if (hrs > 0) {
        if (hrs == 1) {
            sb.append("1 h")
        } else {
            sb.append("$hrs h")
        }
        if (min > 1) {
            sb.append(" $min m")
        }
    } else if (min > 0) {
        if (min == 1) {
            sb.append("1 m")
        } else {
            sb.append("$min m")
        }
        if (sec > 1) {
            sb.append(" $sec s")
        }
    } else {
        if (sec <= 1) {
            sb.append("1 s")
        } else {
            sb.append("$sec s")
        }
    }

    sb.append("")

    return sb.toString()
}