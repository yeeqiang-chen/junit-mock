/*
FileName: User

Function Description:

Author: yiqiang-Chen
Date: 2016-12-05 11:03
Version: V1.0
Copyright © YEE.All rights reserved.
*/

package com.yee.junit.entity;

/**
 * @Description:
 * @author: YEE
 * @date: 2016-12-05 11:03
 */
public class User {
    private Long sid;
    private String name;
    private int sex;
    private int age;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (sex != user.sex) return false;
        if (age != user.age) return false;
        if (sid != null ? !sid.equals(user.sid) : user.sid != null) return false;
        return !(name != null ? !name.equals(user.name) : user.name != null);

    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
