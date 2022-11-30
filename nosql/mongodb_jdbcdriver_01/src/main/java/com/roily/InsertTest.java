package com.roily;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import com.roily.entity.User2;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;

import java.util.Arrays;


/**
 * @Date: 2022/11/29/14:27
 * @Description: insertDocumentTest
 */
public class InsertTest {

    String LOCALHOST = "127.0.0.1";
    String DEFAULT_DB = "test";
    Integer DEFAULT_PORT = 27017;

    final MongoDatabase mongoDatabase = MongoUtil.mongoDatabase(LOCALHOST, DEFAULT_PORT, DEFAULT_DB);

    @Test
    public void testInsertOne() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        if (users.countDocuments() > 0)
            users.drop();
        final Document user = new Document("name", "yuyc").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        users.insertOne(user);
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void testInsertMany() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        if (users.countDocuments() > 0)
            users.drop();
        final Document user1 = new Document("name", "yuyc1").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        final Document user2 = new Document("name", "yuyc2").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        final Document user3 = new Document("name", "yuyc3").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        users.insertMany(Arrays.asList(user1, user2, user3));
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void testBulk() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        if (users.countDocuments() > 0)
            users.drop();
        final Document user1 = new Document("name", "yuyc1").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        final Document user2 = new Document("name", "yuyc2").append("age", 22).append("scores", Arrays.asList(1, 2, 3));

        final InsertOneModel<Document> userInsertOneModel1 = new InsertOneModel<>(Document.parse(JSON.toJSONString(user1)));
        final InsertOneModel<Document> userInsertOneModel2 = new InsertOneModel<>(Document.parse(JSON.toJSONString(user2)));

        final BasicDBObject filter = new BasicDBObject("name", "yuyc1");
        final BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("age", 99));
        final WriteModel<Document> userUpdate = new UpdateOneModel<>(filter, update);

        final Document filter2 = new Document("name", "yuyc1");
        final Document update2 = new Document("$inc", new Document("age", 10));
        final UpdateOneModel<Document> userUpdate2 = new UpdateOneModel<>(filter2, update2);

        users.bulkWrite(Arrays.asList(userInsertOneModel1, userInsertOneModel2, userUpdate, userUpdate2));
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void insertPojo() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        final MongoCollection<User2> users = mongoClient.getDatabase("test")
                .withCodecRegistry(pojoCodecRegistry)
                .getCollection("users", User2.class);
        users.deleteMany(new Document());
        System.out.println("初始数据");
        for (User2 user2 : users.find()) {
            System.out.println(user2);
        }
        System.out.println("insert a pojo into collection");
        User2 userOne = new User2("insertOne", 22);
        users.insertOne(userOne);
        for (User2 user2 : users.find()) {
            System.out.println(user2);
        }
        System.out.println("insert many pojo into collection");
        User2 userMany = new User2("insertMany", 22);
        users.insertMany(Arrays.asList(userMany, userMany, userMany));
        for (User2 user2 : users.find()) {
            System.out.println(user2);
        }

    }

}
