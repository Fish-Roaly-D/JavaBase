package com.roily.test02;

import java.sql.*;
/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class BaseDao {

    public static ResultSet query(Connection conn, PreparedStatement prep, ResultSet resultSet, Object[] params, String sql) {

        if (params == null || params.length == 0) {
            try {
                prep = conn.prepareStatement(sql);
                resultSet = prep.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
        try {
            prep = conn.prepareStatement(sql);
            int index = 0;
            for (Object param : params) {
                prep.setObject(++index, param);
            }

            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static Integer update(Connection conn, PreparedStatement prep, Object[] params, String sql) {
        Integer rows = 0;
        if (params == null || params.length == 0) {
            try {
                rows = prep.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rows;
        }

        try {
            prep = conn.prepareStatement(sql);
            int index = 0;
            for (Object param : params) {
                prep.setObject(++index, param);
            }
            rows = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static Boolean insert(Connection conn, PreparedStatement prep, Object[] params, String sql) {
        Boolean flag = null;
        if (params == null || params.length == 0) {
            try {
                flag = prep.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;
        }

        try {
            prep = conn.prepareStatement(sql);
            int index = 0;
            for (Object param : params) {
                prep.setObject(++index, param);
            }
            flag = prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


}
