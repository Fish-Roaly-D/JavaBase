package com.roily.typeHandler;

import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName MyDateHandler.java
 * @author: RoilyFish
 * @date: 2022/4/3 17:00
 */
@Component
public class MyDateHandler extends DateTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {

        if (parameter == null){
            parameter = new Date(System.currentTimeMillis());
        }

        super.setNonNullParameter(ps, i, parameter, jdbcType);
    }
}
