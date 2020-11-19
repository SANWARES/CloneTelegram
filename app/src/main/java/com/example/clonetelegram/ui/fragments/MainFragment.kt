package com.example.clonetelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.clonetelegram.R
import com.example.clonetelegram.utilits.APP_ACTIVITY


class MainFragment : Fragment(R.layout.fragment_chats) {



    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Telegram"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }

}