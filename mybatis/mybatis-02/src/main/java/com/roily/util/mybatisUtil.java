package com.roily.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/8
 */
public class mybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession OpenSqlSession() {
        return sqlSessionFactory.openSession();
    }


}
