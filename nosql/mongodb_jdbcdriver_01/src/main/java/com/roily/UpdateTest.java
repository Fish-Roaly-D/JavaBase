package com.roily;

import com.mongodb.MongoClientSettings;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateManyModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.UpdateResult;
import com.roily.entity.User2;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Date: 2022/11/29/15:58
 * @Description:
 */
public class UpdateTest {

    String LOCALHOST = "127.0.0.1";
    String DEFAULT_DB = "test";
    Integer DEFAULT_PORT = 27017;

    final MongoDatabase mongoDatabase = MongoUtil.mongoDatabase(LOCALHOST, DEFAULT_PORT, DEFAULT_DB);


    @Test
    public void testUpdateOne() {

        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        System.out.println("=======初始数据=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
        final Bson filter = new Document("name", "闯王");
        final Bson updateField = new Document("$set", new Document("age", 777));

        final Bson updateArray = Updates.set("scores.$[e]", 10);
        final Bson arrayFilter = Filters.eq("e", 1);
        final UpdateOptions updateOptions = new UpdateOptions().arrayFilters(Collections.singletonList(arrayFilter));
        users.updateOne(filter, updateArray, updateOptions);
        users.updateOne(filter, updateField);

        System.out.println("=======更新后=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void testUpdateMany() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        System.out.println("=======初始数据=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
        final Bson filter = new Document();
        final Bson updateArray = Updates.set("scores.$[e]", 10);
        final Bson arrayFilter = Filters.eq("e", 2);
        final UpdateOptions updateOptions = new UpdateOptions().arrayFilters(Collections.singletonList(arrayFilter));
        users.updateOne(filter, updateArray, updateOptions);

        users.updateMany(filter, updateArray, updateOptions);

        System.out.println("=======更新后=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void testBulkWrite() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        users.drop();
        final Document user1 = new Document("name", "yuyc1").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        final Document user2 = new Document("name", "yuyc2").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        final Document user3 = new Document("name", "yuyc3").append("age", 22).append("scores", Arrays.asList(1, 2, 3));
        users.insertMany(Arrays.asList(user1, user2, user3));
        System.out.println("=======初始数据=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
        /**
         * 更新scores数组元素值为2的元素为10
         */
        final Bson filter = new Document();
        final Bson updateArray = Updates.set("scores.$[e]", 10);
        final Bson arrayFilter = Filters.eq("e", 2);
        final UpdateOptions updateOptions = new UpdateOptions().arrayFilters(Collections.singletonList(arrayFilter));
        final WriteModel<Document> updateManyModel1 = new UpdateManyModel<>(filter, updateArray, updateOptions);

        final Bson in = Filters.in("name", "yuyc1", "yuyc2");
        final Bson age = Updates.set("age", 99);
        final WriteModel<Document> updateManyModel2 = new UpdateManyModel<>(in, age);
        final BulkWriteResult bulkWriteResult = users.bulkWrite(Arrays.asList(updateManyModel1, updateManyModel2));
        // db.users.bulkWrite([
        //      {
        //          updateMany:{
        //              filter:{},
        //              update:{$set:{'scores.$[e]':110}},
        //              arrayFilters:[{'e':3}]
        //          }
        //      },
        //         {updateMany:{
        //             filter:{name:{$in:['yuyc1','yuyc2']}},
        //             update:{$set:{age:333}}
        //         }
        //     }
        // ])
        System.out.println(bulkWriteResult);
        System.out.println("=======更新后=======");
        for (Document document : users.find()) {
            System.out.println(document.toJson());
        }
    }


    @Test
    public void replacePojo() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        final MongoCollection<User2> users = mongoClient.getDatabase("test")
                .withCodecRegistry(pojoCodecRegistry)
                .getCollection("users", User2.class);
        final UpdateResult updateResult = users.replaceOne(Filters.eq("name", "insertOne"), new User2("replaceOne", 22));
        System.out.println(updateResult);
    }
}
