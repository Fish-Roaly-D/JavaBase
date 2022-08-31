package com.roily.booknode.javatogod._07Annotation.a03.demo.dao;

import java.lang.reflect.Field;

/**
 * @Date: 2022/08/31/15:02
 * @Description:
 */
public class UserDao {

    String name;

    @Override
    public String toString() {
        return "UserDao{" +
                "name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        final UserDao userDao = UserDao.class.newInstance();
        System.out.println(userDao);
        final Field name = UserDao.class.getDeclaredField("name");

        name.setAccessible(true);
        name.set(userDao, "213");
        System.out.println(userDao);
    }
}
