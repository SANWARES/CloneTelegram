package com.example.clonetelegram.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.clonetelegram.MainActivity
import com.example.clonetelegram.R
import com.example.clonetelegram.utilits.*
import kotlinx.android.synthetic.main.fragment_change_user_name.*
import kotlinx.android.synthetic.main.fragment_settings.*
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
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(UID)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    updateCurrentUsername()
                }
            }
    }

    private fun updateCurrentUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME).setValue(mNewUsername)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUsername()
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    fragmentManager?.popBackStack()
                    USER.username = mNewUsername
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

}