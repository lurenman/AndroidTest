package com.example.androidtest

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.androidtest.util.TestUtils
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.lessThan
import org.hamcrest.collection.IsMapContaining.hasKey
import org.hamcrest.collection.IsMapContaining.hasValue
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 参考：https://blog.csdn.net/qq_17766199/article/details/78243176
 */
//指定该测试类使用某个运行器
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    companion object {
        private val TAG = "ExampleInstrumentedTest"

        /**
         * 在类中所有方法前运行。此注解修饰的方法必须是static void
         */
        @BeforeClass
        @JvmStatic
        fun BeforeClassTest() {
            println("BeforeClassTest执行")
        }

        /**
         * 在类中最后运行。此注解修饰的方法必须是static void
         */
        @AfterClass
        @JvmStatic
        fun AfterClassTest() {
            println("AfterClassTest执行")
        }
    }

    /**
     * 在每个测试方法前执行，可做初始化操作
     */
    @Before
    fun BeforeTest() {
        println("测试开始")
    }


    /**
     * 在每个测试方法后执行，可做释放资源操作
     */
    @After
    fun AfterTest() {
        println("测试结束")
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.androidtest", appContext.packageName)
    }

    @Test
    fun testA() {
        val a = 2
        val b = 2
        assertEquals(4, a + b)
        var str = "abc"
        val reverse = TestUtils.reverse(str)
        assertEquals("cba", reverse)
    }

    /**
     * 可以启动Activity
     */
    @Test
    fun testB() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(appContext, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appContext.startActivity(intent)
        Thread.sleep(5000)
    }

    @Test
    fun assertThatTest() {
        val reverse = TestUtils.reverse("abc")
        assertThat(reverse, equalTo("cba"))

        var str = "test-abc"
        assertThat(str, endsWith("abc"))

        assertThat(str, containsString("abc"))

        assertThat(null, notNullValue())
        //断言参数大于
        assertThat(4, greaterThan(3))
        //断言参数小于
        assertThat(4, lessThan(6))
        //断言符合所有条件，相当于&&
        assertThat(4, allOf(greaterThan(3), lessThan(6)))
        //断言符合某一条件，相当于或
        assertThat(4, anyOf(greaterThan(9), lessThan(6)))

        //map 的相关操作
        val hashMap = HashMap<String, Int>().apply {
            put("key1", 1)
            put("key2", 2)
        }
        assertThat(hashMap, hasKey("key1"))
        assertThat(hashMap, hasValue(2))
        //断言迭代对象含有此元素
        val mutableListOf = mutableListOf(1, 2, 3)
        assertThat(mutableListOf, hasItem(3))
        var arrayList = arrayListOf<String>()
    }

    @Test
    fun mobilePhoneMatcherTest() {
        //assertThat("sbld", MobilePhoneMatcher())
        assertThat("18258847572", MobilePhoneMatcher())
    }
}