package com.example.androidtest.robolectric

import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.androidtest.MainActivity
import com.example.androidtest.R
import com.example.androidtest.TestActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

/**
 * @Author yang.bai.
 * Date: 2022/11/24
 * 参考：https://blog.csdn.net/shensky711/article/details/53561172
 * https://github.com/robolectric/robolectric
 * https://blog.csdn.net/Clever99/article/details/106672707/
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class, shadows = arrayOf(ShadowA::class,ShadowTestSystem::class,
    ShadowLog::class
))
//@Config(constants = BuildConfig::class)
//@RunWith(AndroidJUnit4::class)


class RobolectricUnitTest {
    var rA = A("kkkk")

    @Before
    fun setUp() {
        val app = RuntimeEnvironment.application as RoboApp
        app.test()
    }

    @Test
    fun testA() {
        val str = ""
        if (TextUtils.isEmpty(str)) {
            println("test TextUtils")
        }
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val tv_tile = mainActivity.findViewById<TextView>(R.id.tv_tile)
        val textStr = tv_tile.text
        tv_tile.performClick()
        Assert.assertEquals("Hello World!", textStr)
        val textStr1 = tv_tile.text
        Assert.assertEquals("title", textStr1)
    }

    @Test
    fun testJump() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val btn_skip = mainActivity.findViewById<Button>(R.id.btn_skip)
        btn_skip.performClick()
        // 获取对应的Shadow类
        val shadowOfMainActivity = Shadows.shadowOf(mainActivity)
        // 借助Shadow类获取启动下一Activity的Intent
        val nextStartedActivityIntent = shadowOfMainActivity.nextStartedActivity
        val className = nextStartedActivityIntent.component?.className
        println("the testJump className:${className}")
        // 校验Intent的正确性
        Assert.assertEquals(className, TestActivity::class.java.name)
    }

    /**
     * 调用rA.getShadowName() 实际是调用ShadowA方法，类似于kt中的委托
     */
    @Test
    fun shadowATest() {
        val shadowName = rA.getShadowName()
        println("the shadowName: ${shadowName}")
        val property = System.getProperty("http.proxyHost")
        println("the property: ${property}")
        Log.d("kk","ddd")
    }
}