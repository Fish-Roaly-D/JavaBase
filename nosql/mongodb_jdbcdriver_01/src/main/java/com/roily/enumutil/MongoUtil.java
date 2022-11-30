package com.roily.enumutil;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * @Date: 2022/11/29/10:31
 * @Description:
 */
public class MongoUtil {

    public static MongoClient mongoClient(String host, Integer port) {
        return new MongoClient(host, port);
    }

    public static MongoDatabase mongoDatabase(String host, Integer port, String db) {

        return mongoClient(host, port).getDatabase(db);
    }

    public static <T> MongoCollection<T> mongoCollection(Class<T> pojoClass, String pojoName, String connectionStr, String database) {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .applyConnectionString(new ConnectionString(connectionStr))
                .build();
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        final MongoCollection<T> collection = mongoClient.getDatabase(database)
                .withCodecRegistry(pojoCodecRegistry)
                .getCollection(pojoName, pojoClass);
        return collection;
    }

}
