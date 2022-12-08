package com.roily.common.cnfig;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Date: 2022/12/08/15:08
 * @Description:
 */
@Configuration
public class MongoClientConfig {

    public @Bean MongoClient mongoClient() {
        final ConnectionString conStr = new ConnectionString("mongodb://127.0.0.1:27017");
        return MongoClients.create(conStr);
    }

    public @Bean MongoOperations mongoOperations(@Autowired MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "test");
    }

}
