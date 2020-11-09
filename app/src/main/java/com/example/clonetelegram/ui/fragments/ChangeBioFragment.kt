package com.example.clonetelegram.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.clonetelegram.MainActivity
import com.example.clonetelegram.R
import com.example.clonetelegram.utilits.*
import kotlinx.android.synthetic.main.fragment_change_bio.*

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {


    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_BIO).setValue(newBio)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    USER.bio = newBio
                    fragmentManager?.popBackStack()
                }
            }
    }
}