package com.mdscrn.hackernewsclient


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.commons.inflate


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }
}
