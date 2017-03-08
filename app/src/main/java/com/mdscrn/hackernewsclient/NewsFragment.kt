package com.mdscrn.hackernewsclient


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdscrn.hackernewsclient.commons.inflate
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list.adapter = NewsAdapter()
    }
}
