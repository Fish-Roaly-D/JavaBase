package com.roly.cloud.service;

import com.roly.cloud.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: rolyfish
 */
public interface UserService {

    public List<User> getAll() throws SQLException;

}
