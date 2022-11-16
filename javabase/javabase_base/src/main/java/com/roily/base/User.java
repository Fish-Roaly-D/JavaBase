package com.roily.base;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONCreator;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022/11/16/14:37
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {

    String name;
    String age;


    public static void main(String[] args) {
        final User user1 = new User("user1", "age1");
        final User user2 = new User("user1", "age1");
        final User user3 = new User("user1", "age1");
        final List<User> users = Arrays.asList(user1, user2, user3);
        final String string = JSON.toJSONString(users);
        System.out.println(string);

        final JsonObject jsonObject = new JsonObject();





    }
}
