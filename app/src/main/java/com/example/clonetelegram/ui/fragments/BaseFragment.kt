package com.example.clonetelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.clonetelegram.utilits.APP_ACTIVITY


open class BaseFragment(val layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
       APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}