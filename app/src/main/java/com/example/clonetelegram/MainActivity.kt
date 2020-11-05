package com.example.clonetelegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clonetelegram.activities.RegisterActivity
import com.example.clonetelegram.databinding.ActivityMainBinding
import com.example.clonetelegram.ui.objects.AppDrawer
import com.example.clonetelegram.ui.fragments.ChatsFragment
import com.example.clonetelegram.utilits.AUTH
import com.example.clonetelegram.utilits.initFirebase
import com.example.clonetelegram.utilits.replaceActivity
import com.example.clonetelegram.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())

        } else {
            replaceActivity(RegisterActivity())
        }


    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

        initFirebase()

    }
}