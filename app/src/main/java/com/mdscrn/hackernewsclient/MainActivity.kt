package com.mdscrn.hackernewsclient

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.mdscrn.hackernewsclient.api.data.NewsType
import com.mdscrn.hackernewsclient.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG by lazy { javaClass.canonicalName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        if (savedInstanceState == null) {
            changeFragment(NewsFragment(NewsType.Ask))
        }
    }

    fun initializeViews() {
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.toolBarText))
        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.toolBarText))

        toolbar.title = "Trending"
        toolbar.subtitle = "Developed in Kotlin"

       bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
           when (menuItem.itemId) {
               R.id.navigation_trending -> changeFragment(NewsFragment(NewsType.Top), true)
               R.id.navigation_show -> changeFragment(NewsFragment(NewsType.Show), true)
               R.id.navigation_ask -> changeFragment(NewsFragment(NewsType.Ask), true)
               R.id.navigation_job -> changeFragment(NewsFragment(NewsType.Job), true)
           }
           true
       }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }

        ft.setCustomAnimations(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom, R.anim.abc_popup_enter, R.anim.abc_popup_exit)

        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
