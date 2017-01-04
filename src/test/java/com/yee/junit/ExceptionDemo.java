/*
FileName: ExceptionDemo

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:17
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @Description:
 * @author: YEE
 * @date: 2016-12-05 11:17
 */
public class ExceptionDemo {
    @Rule
    public ExpectedException exp = ExpectedException.none();

    @Test(expected = RuntimeException.class)
    public void test1() {
        throw new RuntimeException();
    }


    @Test
    public void expectException() {
        exp.expect(IndexOutOfBoundsException.class);
        throw new IndexOutOfBoundsException("Exception method.");
    }

    @Test
    public void expectMessage() {
        exp.expectMessage("Hello World");
        throw new RuntimeException("Hello World will throw exception.");
    }

    @Test
    public void expectCourse() {
        exp.expectMessage(String.valueOf(new BaseMatcher<IllegalArgumentException>() {

            public boolean matches(Object item) {
                return item instanceof IllegalArgumentException;
            }

            public void describeTo(Description description) {
                description.appendText("Expected Cause Error.");
            }

        }));

        Throwable cause = new IllegalArgumentException("Cause Test.");
        throw new RuntimeException(cause);
    }
}
