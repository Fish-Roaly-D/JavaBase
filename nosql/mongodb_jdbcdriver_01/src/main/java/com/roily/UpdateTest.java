package com.roily;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;
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


}
