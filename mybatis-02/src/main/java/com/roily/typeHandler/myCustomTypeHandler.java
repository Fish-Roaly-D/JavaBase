package com.roily.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/9
 */
//@MappedJdbcTypes(JdbcType.VARCHAR)
public class myCustomTypeHandler extends BaseTypeHandler<String> {

    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("==========================");
        ps.setString(i,parameter+"XXX");
    }
    //public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
    //
    //    System.err.println("xxx");
    //    parameter = parameter+"xxx";
    //    ps.setString(i,parameter+"XXX");
    //
    //}

    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {

        String string = rs.getString(columnName);

        return string+"拿取数据1";
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        String string = rs.getString(columnIndex);
        return string+"拿取数据2";
    }

    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        String string = cs.getString(columnIndex);
        return string+"拿取数据2";
    }
}
