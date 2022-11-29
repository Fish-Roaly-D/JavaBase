package com.roily;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.roily.entity.Score;
import com.roily.entity.User;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Date: ${YEAR}/${MONTH}/${DAY}/${TIME}
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        MongoDatabase test = MongoUtil.mongoDatabase("127.0.0.1", 27017, "test");

        final MongoCollection<Document> userCol = test.getCollection("users");

        User user = new User()
                .setName("rolyfish")
                .setAge(22)
                .setScoreList(Arrays.asList(
                        new Score("math", 99, 1),
                        new Score("english", 99, 1),
                        new Score("chinese", 99, 1)));

        final List<Document> users = Arrays.asList(Document.parse(JSON.toJSONString(user)), Document.parse(JSON.toJSONString(user)), Document.parse(JSON.toJSONString(user)));

        userCol.insertMany(users);

        final FindIterable<Document> documents = userCol.find();

        final MongoCursor<Document> iterator = documents.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next().toJson());
        }

        iterator.close();
    }

    @Test
    public void mongoClient(){
        //MongoClients.create();默认连接本地 27017的单个mongo实例
        try(MongoClient mongoClient = MongoClients.create(/*"mongodb://localhost:27017"*/)){
            final MongoDatabase test = mongoClient.getDatabase("test");
            final MongoCollection<Document> users = test.getCollection("users");
            for (Document document : users.find()) {
                System.out.println(document.toJson());
            }
        }
    }

    @Test
    public void mongoClientX(){
        try ( MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Collections.singletonList(new ServerAddress("localhost",27017))))
                        .build())){
            final MongoDatabase test = mongoClient.getDatabase("test");
            final MongoCollection<Document> users = test.getCollection("users");
            for (Document document : users.find()) {
                System.out.println(document.toJson());
            }
        }
    }


    @Test
    public void mongoClientT(){
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017,localhost:27017");
        try (com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient(connectionString)){
            final MongoDatabase test = mongoClient.getDatabase("test");
            final MongoCollection<Document> users = test.getCollection("users");
            for (Document document : users.find()) {
                System.out.println(document.toJson());
            }
        }
    }
}