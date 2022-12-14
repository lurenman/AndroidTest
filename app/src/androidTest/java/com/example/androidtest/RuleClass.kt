package com.example.androidtest

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * @Author yang.bai.
 * Date: 2022/11/23
 */
public class RuleClass : TestRule {
    companion object {
        private val TAG = "RuleClass"
    }

//    override fun apply(base: Statement, description: Description?): Statement {
//        println("the methodName:${description?.methodName}")
//        println("${TAG} 测试开始")
//        base.evaluate()
//        println("${TAG} 测试结束")
//        return base
//    }

//    internal class TestStatement : Statement() {
//        override fun evaluate() {
//            //TODO("Not yet implemented")
//        }
//    }

    override fun apply(base: Statement, description: Description?): Statement =
        object : Statement() {
            override fun evaluate() {
                println("the methodName:${description?.methodName}")
                println("${TAG} 测试开始")
                base.evaluate()
                println("${TAG} 测试结束")
            }
        }
}