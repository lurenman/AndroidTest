package com.example.androidtest

import android.app.Application
import android.util.Log

class App : Application() {
    companion object{
        val TAG="App"
    }
    override fun onCreate(): Unit {
        super.onCreate()
        Log.d(TAG, "onCreate: -----")
    }
}