package com.roily.service;

import com.roily.dao.UserDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date: 2022/09/27/14:42
 * @Description:
 */
public class UserService {


    // @Autowired
    private UserDao userDao;


    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    @Autowired
    public UserService( final UserDao userDao) {
        System.out.println(2);
        this.userDao = userDao;
    }
    public UserService() {
        System.out.println(1);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }
}
