package com.example.androidtest.robolectric

import org.robolectric.annotation.Implementation

/**
 * @Author yang.bai.
 * Date: 2022/11/24
 */
class A {
    var name: String="AAAA"

    constructor(str: String) {
        this.name = str
    }

    fun getShadowName(): String {
        return this.name
    }
}