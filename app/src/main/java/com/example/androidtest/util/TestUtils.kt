package com.example.androidtest.util

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.text.TextUtils

/**
 * @Author yang.bai.
 * Date: 2022/11/23
 * 随便测试类
 */
class TestUtils {
    companion object {
        fun reverse(str: String): String {
            return if (TextUtils.isEmpty(str)) {
                str
            } else StringBuilder(str).reverse().toString()
        }

        fun isInstall(pm: PackageManager?, name: String?): PackageInfo? {
            val pi: PackageInfo?
            pi = try {
                pm!!.getPackageInfo(name!!, 0)
            } catch (e: Exception) {
                null
            }
            return pi
        }

        fun nullExceptTest(str: String?) {
            str!!.length
        }
    }
}