package com.example.androidtest.base

import android.R
import android.content.Context
import android.os.Bundle

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(true)
            setDisplayUseLogoEnabled(false)
            title = getActionBarTitle()
        }
        setContentView(getLayoutResId())
        initView()
        initVariables()
        initListenter()
        loadData()
    }


    protected abstract fun getActionBarTitle(): String

    protected abstract fun getLayoutResId(): Int

    protected open fun initView() = Unit

    protected open fun initVariables() = Unit

    protected open fun loadData() = Unit

    protected open fun initListenter() = Unit

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> finish()
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}