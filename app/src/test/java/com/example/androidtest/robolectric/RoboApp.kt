package com.example.androidtest.robolectric

import android.app.Application

/**
 * @Author yang.bai.
 * Date: 2022/11/24
 */
class RoboApp : Application() {
    companion object {
        val TAG = "RoboApp"
    }

    override fun onCreate() {
        super.onCreate()
        println("the RoboApp onCreate")
    }

    fun test() {
        println("the RoboApp test")
    }
}