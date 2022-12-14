package com.example.androidtest

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * @Author yang.bai.
 * Date: 2022/11/23
 * 参数化测试
 */
@RunWith(Parameterized::class)
class ParameterizedTest {
    companion object {
        /**
         * 就是传参数的集合，入构造方法，testP会执行3次
         */
        @Parameterized.Parameters
        @JvmStatic
        fun testParameterized(): MutableList<Int> {
            return mutableListOf(1, 2, 3)
        }
    }

    var mValue: Int? = null

    constructor(mValue: Int?) {
        this.mValue = mValue
    }

    @Test
    fun testP() {
        println("the value:${mValue}")
    }
}