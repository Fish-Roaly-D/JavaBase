package com.roily.mp01;

import com.roily.mp01.entity.User;
import com.roily.mp01.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * @Date: 2022/10/26/14:19
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    UserService userService;

    @Test
    public void testLogicField(){

        final User user = new User();
        user.setName("yuyc");
        userService.save(user);

        final List<User> list = userService.list();
        System.out.println(list);
    }
    @Test
    public void testXml(){
        final User user = userService.selOneXml();
        System.out.println(user);
    }
    @Test
    public void testVersion(){


        final User user = userService.getById(21);

        user.setName("update");

        userService.updateById(user);




    }

}
