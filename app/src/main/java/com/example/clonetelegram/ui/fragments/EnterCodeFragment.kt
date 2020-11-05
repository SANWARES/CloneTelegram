package com.example.clonetelegram.ui.fragments

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.clonetelegram.MainActivity
import com.example.clonetelegram.R
import com.example.clonetelegram.activities.RegisterActivity
import com.example.clonetelegram.utilits.AUTH
import com.example.clonetelegram.utilits.AppTextWatcher
import com.example.clonetelegram.utilits.replaceActivity
import com.example.clonetelegram.utilits.showToast
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(private val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {



    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        Log.e("Ops", phoneNumber)
        Log.e("Ops", "Test")
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())
        }
    }

}

