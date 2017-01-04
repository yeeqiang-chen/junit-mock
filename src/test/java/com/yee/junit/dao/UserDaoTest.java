/*
FileName: UserDaoTest

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:22
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit.dao;

import com.yee.junit.entity.User;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Description:
 * @author: YEE
 * @date: 2016-12-05 11:22
 */
public class UserDaoTest {
    private IUserDao userDao;
    private User user1;
    private User user2;

    @BeforeClass
    public static void t() {
        System.out.println(321);
    }

    @Before
    public void setUp() {
        userDao = EasyMock.createMock(IUserDao.class);
        user1 = new User();
        user1.setSid(1L);
        user1.setAge(11);
        user1.setName("test1");
        user1.setSex(1);

        user2 = new User();
        user2.setSid(2L);
        user2.setAge(22);
        user2.setName("test2");
        user2.setSex(2);
    }

    /**
     * EasyMock标准示例
     *
     * Easymock.replay(...)和Easymock.verify(...)。这两个语句将上述代码分成三个部分，分别对应record-replay-verify 3个阶段
     *  record-replay-verify ：先指定测试的期望，然后执行测试，再验证期望是否被满足。
     * @throws Exception
     */
    @Test
    public void testFindUserBySid() throws Exception {
        //replay关键字之前：创建mock对象，并期望这个mock对象的方法被调用，同时给出我们希望这个方法返回的结果。
        //==============record start================
        EasyMock.expect(userDao.findBySid(1L)).andReturn(user1);//录制一次，只能调用一次！
        //==============record end=================

        // ==============replay start==============
        /*
        在replay阶段，我们关注的主要测试对象将被创建，之前在record阶段创建的相关依赖被关联到主要测试对象，
        然后执行被测试的方法，以模拟真实运行环境下主要测试对象的行为。
         */
        EasyMock.replay(userDao);   //replay
//        User bySid = userDao.findBySid(2L);
        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);
        // ==============replay end================

        // ==============verify start================
        //在verify阶段，验证测试的结果和交互行为。
        assertNotNull(user1);
        long sid = user1.getSid();
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
        // ==============verify end================
    }

    /**
     * 另一种行为录制方式
     * @throws Exception
     */
    @Test
    public void testFindUserBySid2() throws Exception {
//        EasyMock.expect(usySid(EasyMock.isA(Long.class))).andReturn(user1);//动态参数
        //2.1.录制
        userDao.findBySid(1L);
        EasyMock.expectLastCall().andReturn(user1);

        //2.2.测试
        EasyMock.replay(userDao);   //replay

        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);

        //3.验证
        assertNotNull(user1);
        long sid = user1.getSid();
        //assertEquals(1L, user1.getSid()); 会报错
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
    }

    /**
     * 不指定具体参数
     * @throws Exception
     */
    @Test
    public void testFindUserBySid3() throws Exception {
        EasyMock.expect(userDao.findBySid(EasyMock.isA(Long.class))).andReturn(user1);//动态参数

        //2.2.测试
        EasyMock.replay(userDao);   //replay

        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);

        //3.验证
        assertNotNull(user1);
        long sid = user1.getSid();
        //assertEquals(1L, user1.getSid()); 会报错
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
    }

    /**
     * 指定调用次数 —— 返回同一个结果
     * 调用次数少于录制次数时，会报错
     * @throws Exception
     */
    @Test
    public void testFindUserBySid4() throws Exception {
        EasyMock.expect(userDao.findBySid(EasyMock.isA(Long.class))).andReturn(user1).times(2);//动态参数
//        EasyMock.expect(userDao.findBySid(EasyMock.anyLong())).andReturn(user1).times(2)
//        EasyMock.notNull() EasyMock.same() EasyMock.startsWith() ...

        //2.2.测试
        EasyMock.replay(userDao);   //replay

        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);
        User bySid2 = userDao.findBySid(2L);
        System.out.println(bySid2);

        //3.验证
        assertNotNull(user1);
        long sid = user1.getSid();
        //assertEquals(1L, user1.getSid()); 会报错
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
    }

    /**
     * 指定调用次数 —— 返回不同结果，
     * 调用次数少于录制次数时，会报错
     * @throws Exception
     */
    @Test
    public void testFindUserBySid5() throws Exception {
        //返回结果只与录制次数相关
//        EasyMock.expect(userDao.findBySid(EasyMock.isA(Long.class))).andReturn(user2);//动态参数
//        EasyMock.expect(userDao.findBySid(EasyMock.isA(Long.class))).andReturn(user1);//动态参数

        //返回结果与输入参数相关
        EasyMock.expect(userDao.findBySid(2L)).andReturn(user2);//指定参数
        EasyMock.expect(userDao.findBySid(1L)).andReturn(user1);//指定参数

        //2.2.测试
        EasyMock.replay(userDao);   //replay

        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);

//        User bySid2 = userDao.findBySid(1L);
        User bySid2 = userDao.findBySid(2L);
        System.out.println(bySid2);

        //3.验证
        assertNotNull(user1);
        long sid = user1.getSid();
        //assertEquals(1L, user1.getSid()); 会报错
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
    }


    /**
     * 返回异常 —— 【问题：为什么测试不通过 ？】
     *
     * @throws Exception
     */
    @Test(expected = RuntimeException.class)
    public void testFindUserBySid6() throws Exception {
        EasyMock.expect(userDao.findBySid(1L)).andThrow(new RuntimeException());//指定参数

        //2.2.测试
        EasyMock.replay(userDao);   //replay

        User bySid = userDao.findBySid(1L);
        System.out.println(bySid);

        //3.验证
        assertNotNull(user1);
        long sid = user1.getSid();
        //assertEquals(1L, user1.getSid()); 会报错
        assertEquals(1L, sid);
        //4.回放录制
        EasyMock.verify(userDao);
    }

    public void testFindUserByName() throws Exception {
        //TODO
    }
}
