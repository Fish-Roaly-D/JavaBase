package com.roily.util;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Date: 2022/12/08/12:27
 * @Description:
 */
public class MongoTemplateUtil {

    private static Log log = LogFactory.getLog(MongoTemplateUtil.class);


    private static String port;
    private static String host;
    private static String db;

    static {
        try {
            final InputStream in = MongoTemplateUtil.class.getClassLoader().getResourceAsStream("mongodb.properties");
            final Properties properties = new Properties();
            properties.load(in);
            host = (String) properties.get("mongo.host");
            port = (String) properties.get("mongo.port");
            db = (String) properties.get("mongo.dbname");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static MongoOperations mongoOperations() {
        final ConnectionString conStr = new ConnectionString("mongodb://" + host + ":" + port);
        return new MongoTemplate(MongoClients.create(conStr), db);
    }

}
