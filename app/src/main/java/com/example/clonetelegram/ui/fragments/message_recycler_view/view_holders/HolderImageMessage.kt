package com.example.clonetelegram.ui.fragments.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item_image.view.*
import kotlinx.android.synthetic.main.message_item_text.view.*

class HolderImageMessage(view: View):RecyclerView.ViewHolder(view) {
    val blocReceivedImageMessage: ConstraintLayout = view.block_received_image_message
    val blocUserImageMessage: ConstraintLayout = view.block_user_image_message
    val chatUserImage: ImageView = view.chat_user_image
    val chatReceivedImage: ImageView = view.chat_received_image
    val chatUserImageMessageTime: TextView = view.chat_user_message_time
    val chatReceivedImageMessageTime: TextView = view.chat_received_image_message_time
}