package com.example.clonetelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clonetelegram.R
import com.example.clonetelegram.databinding.ActivityRegisterBinding
import com.example.clonetelegram.ui.fragments.EnterPhoneNumberFragment
import com.example.clonetelegram.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment())
    }
}