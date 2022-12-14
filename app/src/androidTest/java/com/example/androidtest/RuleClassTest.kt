package com.example.androidtest

import com.example.androidtest.util.TestUtils
import org.junit.Rule
import org.junit.Test

/**
 * @Author yang.bai.
 * Date: 2022/11/23
 */
class RuleClassTest {
    companion object{
        val TAG="RuleClassTest"
    }
    @Rule
    @JvmField
    public var mRuleClass: RuleClass = RuleClass()

    @Test(expected = NullPointerException::class)
    fun test() {
        println("${TAG} test----")
        //判断期待异常之后，后续方法不会执行
        TestUtils.nullExceptTest(null)
    }
}