package com.example.androidtest.robolectric

import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.annotation.RealObject


/**
 * @Author yang.bai.
 * Date: 2022/11/24
 */
@Implements(A::class)
class ShadowA {
    var name: String? = null

    /**
     * 若原始类有有参构造方法，在Shadow类中定义public void类型的名为__constructor__的方法，且方法参数与原始类的构造方法参数一直
     */
    @RealObject
    private val realA: A? = null

    fun __constructor__(str: String) {
        realA?.name = str
    }

    @Implementation
    fun getShadowName(): String {
        return "Hello, I ma shadow of realA: " + realA?.name
    }
}