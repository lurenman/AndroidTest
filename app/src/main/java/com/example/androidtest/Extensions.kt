package com.example.androidtest

import android.app.Activity
import android.content.res.Resources
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast

fun <T> lazyFast(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

fun View.visible() {
    if (View.VISIBLE != visibility) {
        visibility = View.VISIBLE
    }
}

fun View.gone() {
    if (View.VISIBLE == visibility) {
        visibility = View.GONE
    }
}

fun View.invisible() {
    if (View.VISIBLE == visibility) {
        visibility = View.INVISIBLE
    }
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

inline val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

inline val Int.dp
    get() = this.toFloat().dp.toInt()

inline val Float.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        Resources.getSystem().displayMetrics
    )

inline val Int.sp
    get() = this.toFloat().sp

/**
 * TextView设置前景色
 */
fun TextView.setForegroundSpannableString(foregroundColor: Int, startPos: Int, endPos: Int) {
    val mSpannableString = SpannableString(text)
    val foregroundSpan = ForegroundColorSpan(foregroundColor)
    mSpannableString.setSpan(foregroundSpan, startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    text = mSpannableString
}

/**
 * 获取屏幕宽度
 */
fun Activity.getScreenWidth(): Int {
    val windowManager = windowManager
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

/**
 * 获取屏幕高度
 */
fun Activity.getScreenHeight(): Int {
    val windowManager = windowManager
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}
