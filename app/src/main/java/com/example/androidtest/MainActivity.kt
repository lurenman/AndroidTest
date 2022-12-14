package com.example.androidtest

import android.content.Intent
import android.text.TextUtils
import com.example.androidtest.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object {
        private val TAG = "MainActivity "
    }

    override fun getActionBarTitle(): String = TAG

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initListenter() {
        super.initListenter()
        tv_tile.setOnClickListener {
            tv_tile.text = "title"
        }
        btn_skip.setOnClickListener {
            if (TextUtils.isEmpty("dd")){

            }
            val intent = Intent(mContext, TestActivity::class.java)
            startActivity(intent)
        }
    }
}