package com.example.clonetelegram.ui.fragments

import com.example.clonetelegram.R
import com.example.clonetelegram.database.*
import com.example.clonetelegram.utilits.*
import kotlinx.android.synthetic.main.fragment_change_user_name.*
import java.util.*


class ChangeUserNameFragment : BaseChangeFragment(R.layout.fragment_change_user_name) {

    lateinit var mNewUsername: String

    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)

    }


    override fun change() {
        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        if (mNewUsername.isEmpty()) {
            showToast("Поле пустое")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                  if (it.hasChild(mNewUsername)) {
                      showToast("Такой пользователь уже существует")
                  }
                    else {
                      changeUserName()
                  }
                })
        }
    }

    private fun changeUserName() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(CURRENT_UID)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    updateCurrentUsername(mNewUsername)
                }
            }
    }
}