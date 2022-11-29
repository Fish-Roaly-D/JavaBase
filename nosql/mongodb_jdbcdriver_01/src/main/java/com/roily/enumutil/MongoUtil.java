package com.roily.enumutil;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @Date: 2022/11/29/10:31
 * @Description:
 */
public class MongoUtil {

    public static MongoClient mongoClient(String host, Integer port) {
        return new MongoClient(host, port);
    }

    public static MongoDatabase mongoDatabase(String host, Integer port, String db) {

        return mongoClient(host,port).getDatabase(db);
    }


}
