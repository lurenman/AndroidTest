package com.example.androidtest

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import java.util.regex.Pattern

/**
 * @Author yang.bai.
 * Date: 2022/11/23
 * 判断是否是手机号,自定义匹配器
 */
class MobilePhoneMatcher : BaseMatcher<String>() {

    override fun describeTo(description: Description?) {
        description?.appendText("预计此字符串是手机号码！")
    }

    override fun describeMismatch(item: Any?, description: Description?) {
        //super.describeMismatch(item, description)
        description?.appendText(item.toString() + "不是手机号码！")
    }

    override fun matches(item: Any?): Boolean {
        if (item == null) {
            return false;
        }
        return Pattern.compile("(1|861)(3|5|7|8)\\d{9}$*").run {
            val matcher = matcher(item as CharSequence)
            matcher.find()
        }
    }
}