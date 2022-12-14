package com.example.androidtest

import com.example.androidtest.base.BaseActivity

/**
 * @Author yang.bai.
 * Date: 2022/11/24
 */
class TestActivity :BaseActivity() {
    companion object{
        private val TAG="TestActivity"
    }
    override fun getActionBarTitle(): String= TAG

    override fun getLayoutResId(): Int = R.layout.activity_testa
}