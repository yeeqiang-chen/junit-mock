/*
FileName: AssertDemo

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:09
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit;

import com.yee.junit.entity.User;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @Description: 断言
 * @author: chenyiqiang(004205)
 * @date: 2016-12-05 11:09
 */
public class AssertDemo {
    @Test
    public void assertTestOne() {

        User u1 = new User();
        User u2 = new User();

        u1.setSex(1);
        u1.setName("u1");
        u1.setAge(1);
        u1.setSid(1L);

        u2.setSex(1);
        u2.setName("u1");
        u2.setAge(1);
        u2.setSid(1L);


        /**********************************************
         *                 true
         *********************************************/

        //assertTrue ([String message],Boolean condition)
        Assert.assertTrue("结果与预期不符", 2 == 2);
        Assert.assertFalse("结果与预期不符", 2==22);

        /**********************************************
         *                 equals
         *********************************************/
        //值是否相同 A.equals(B)
        //assertEquals([String message],expected,actual)
        Assert.assertEquals("结果与预期不符", u1, u2);
        Assert.assertEquals("结果与预期不符", null, null);

        Assert.assertEquals("结果与预期不符", new String("2"), new String("2"));
        //对比
        System.out.println(new String("2") == new String("2"));

        Assert.assertEquals("结果与预期不符", 2, 2);

        //assertEquals([String message],expected,actual,tolerance) tolerance 允许误差 (<)
        Assert.assertEquals("结果与预期不符", 2, 2.2, 0.21);

        /**********************************************
         *                 null
         *********************************************/
        //assertNull([String message],Object object)
//        Assert.assertNull("对象不为空", 1);
        Assert.assertNull("对象不为空", null);
        Assert.assertNotNull("对象为空", 1);

        /**********************************************
         *                 same
         *********************************************/
        //"引用"的是否指向同一个对象 A==B
        //assert[Not]Same ([String message], expected,actual)
//        Assert.assertSame("引用不同", u1, u2);
        Assert.assertNotSame("引用不同", new String("2"), new String("2"));
        Assert.assertSame("引用不同", null, null);
        Assert.assertEquals("引用不同", null, null);

        /**********************************************
         *                 fail
         *********************************************/
        //该断言会使测试立即失败，常用在测试不能达到的分支上, 如异常。
        int b = 0;
        try {
            b = 1 / b;
            Assert.fail("The Exception I want is not occured"); //用法示例：判断想要的异常是否发生，发生时，不会运行该句
        } catch (Exception e) {
            Assert.assertEquals(e.getClass().getSimpleName(), "ArithmeticException");
        }
    }
}
