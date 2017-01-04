/*
FileName: IUserDao

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:05
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit.dao;

import com.yee.junit.entity.User;

/**
 * @Description:
 * @author: YEE
 * @date: 2016-12-05 11:05
 */
public interface IUserDao {

    User findUserByName(String name);

    User findBySid(Long sid);
}
