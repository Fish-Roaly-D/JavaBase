package com.roly.dubbo_zookeeper_provider.service.impl;

import com.roly.cloud.entity.User;
import com.roly.cloud.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: rolyfish
 */

@DubboService
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAll() throws SQLException {
        final ArrayList<User> list = new ArrayList<>();
        final Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmdp?useSSL=false&serverTimezone=UTC", "root", "123456");
        final PreparedStatement preparedStatement = connection.prepareStatement("select  * from tb_user");
        final ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(User.builder()
                    .id(resultSet.getLong(1))
                    .phone(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .nickName(resultSet.getString(4)).build());
        }
        return list;
    }
}
