package com.example.androidtest.mockito

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * @Author yang.bai.
 * Date: 2022/12/9
 * 参考：https://blog.csdn.net/rikkatheworld/article/details/108035323
 * https://www.jianshu.com/p/b6e0cf81641b?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes
 */
@RunWith(MockitoJUnitRunner::class)
class MockitoTest {
    // @Mock
    lateinit var myList: ArrayList<Int>
    lateinit var myList1: ArrayList<Int>

    @Before
    fun setUp() {
        //myList = ArrayList()
        // MockitoAnnotations.initMocks(this)
        myList = mock(ArrayList::class.java) as ArrayList<Int>
        myList1 = mock(ArrayList::class.java) as ArrayList<Int>
    }

    @Test
    fun verifyTest() {
        myList.add(1)
        verify(myList).add(1)
        myList.clear()
        verify(myList).clear()

//        verify(myList, times(0))?.add(1)      // 判断add被调用了0次
//        verify(myList, times(1))?.size        // 判断size被调用了1次
//        verify(myList, atLeast(1))?.size      // 判断size被调用了至少一次
//        verify(myList, atLeastOnce())?.size   // 同上，相同于atLiast(1)
//        verify(myList, atMost(2))?.size       // 判断size被调用少于2次
//        verify(myList, never())?.clear()      // 判断clear没有被调用过
//        verify(myList, only())?.clear()      // 判断是否只调用过clear方法
        //表明之后再也没有myList的事情了， 这个地方可以跑通
        Mockito.verifyNoMoreInteractions(myList)
        myList.add(3)
    }

    /**
     * InOrder来验证调用的顺序
     */
    @Test
    fun inOrder() {
        myList.add(1)
        myList1.add(2)
        //指定验证的顺序，myList1只有在myList验证之后
        val inOrder = Mockito.inOrder(myList, myList1)
        inOrder.verify(myList).add(1)
        inOrder.verify(myList1).add(2)
    }

    @Test
    fun whenTest() {
        `when`(myList.get(ArgumentMatchers.anyInt())).thenReturn(100)
        val getValue = myList.get(3)
        assertEquals(getValue, 100)
        //当调用get（4）的时候抛出异常
//        `when`(myList.get(4)).thenThrow(RuntimeException("throw get 4"))
//        myList.get(4)
        //then 是直接写返回值
        `when`(myList.get(5)).then {
            val argument = it.getArgument<Int>(0)
            println("the whenTest argument:${argument}")
            200
        }
        val getValue1 = myList.get(5)
        assertEquals(getValue1, 200)
    }

    @Test
    fun doTest() {
        for (i in 0..9) {
            myList.add(i)
        }
        //注意这里的when和之前的不一样
        doThrow(RuntimeException("the do doThrow")).`when`(myList).get(1)
        // myList.get(1)
        doReturn(100).`when`(myList).get(2)
        assertEquals(myList.get(2), 100)
        //Only void methods can doNothing()!,带返回值的不能用 doNothing()
//        doNothing().`when`(myList).get(3)
//        val doNothingValue = myList.get(3)
    }
}