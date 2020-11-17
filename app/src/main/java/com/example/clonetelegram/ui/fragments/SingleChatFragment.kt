package com.example.clonetelegram.ui.fragments

import android.view.View
import com.example.clonetelegram.R
import com.example.clonetelegram.models.CommonModel
import com.example.clonetelegram.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.view.*

class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {
    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.VISIBLE
    }
    override fun onPause() {
        super.onPause()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.GONE
    }
}