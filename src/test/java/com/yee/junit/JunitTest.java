/*
FileName: JunitTest

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:19
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

/**
 * @Description: Junit注解
 * @author: YEE
 * @date: 2016-12-05 11:19
 *
 * 注解
 *
 * @Before：初始化方法 对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
 * @After：释放资源 对于每一个测试方法都要执行一次（注意与AfterClass区别，后者是对于所有方法执行一次）
 * @Test：测试方法，在这里可以测试期望异常和超时时间
 * @Test(expected=ArithmeticException.class)检查被测方法是否抛出ArithmeticException异常
 * @Ignore：忽略的测试方法
 * @BeforeClass：针对所有测试，只执行一次，且必须为static void
 * @AfterClass：针对所有测试，只执行一次，且必须为static void
 * 一个JUnit4的单元测试用例执行顺序为：
 * @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
 * 每一个测试方法的调用顺序为：
 * @Before -> @Test -> @After;
 */
public class JunitTest {
    @BeforeClass
    public static void initJunitTest() {
        System.out.println("beforeClass:" + new Date().getTime());
    }

    @Before
    public void setUp() {
        System.out.println("before     :" + new Date().getTime());
    }

    @After
    public void tearDown() {
        System.out.println("after      :" + new Date().getTime());
    }

    @AfterClass
    public static void closeJunitTest() {
        System.out.println("afterClass :" + new Date().getTime());
    }

    /**
     * 测试方法三要素：
     * 1.public
     * 2.void
     * 3.无参
     */
    @Test
    public void testDemoOne() {
        System.out.println("this is testDemoOne");
    }

    /**
     * testDemoOne和testDemoTwo执行时，都分别要执行@Before和@After标注的方法
     */
    @Test
    public void testDemoTwo() {
        System.out.println("this is testDemoTwo");
    }

    @Test
    @Ignore
    public void Ignore() {
        System.out.println("Ignore");
    }
}
