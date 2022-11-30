package com.roily;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

/**
 * @Date: 2022/11/30/10:30
 * @Description:
 */
public class FindTest {


    String LOCALHOST = "127.0.0.1";
    String DEFAULT_DB = "test";
    Integer DEFAULT_PORT = 27017;

    final MongoDatabase mongoDatabase = MongoUtil.mongoDatabase(LOCALHOST, DEFAULT_PORT, DEFAULT_DB);


    @Test
    public void testCountCollections() {

        final MongoCollection<Document> users = mongoDatabase.getCollection("users");

        // System.out.println("db.collection.count()" + users.count(new Document()));
        System.out.println("db.collection.countDocuments()" + users.countDocuments(new Document()));
        System.out.println("db.collection.estimatedDocumentCount()" + users.estimatedDocumentCount());

    }

    @Test
    public void testFindFirst() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        final Document first =
                users.find().first();
        System.out.println(first.toJson());
    }

    @Test
    public void testQueryFilter() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        final Bson eq2 = Filters.eq("age", 23);
        final Bson eq3 = Filters.eq("name", "bulkWrite.insertOneModel");
        final Bson and = Filters.and(eq2, eq3);
        for (Document document : users.find(and)) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void testProjections() {
        final MongoCollection<Document> users = mongoDatabase.getCollection("users");
        final Bson eq = Filters.eq("age", 23);
        for (Document document : users.find(eq).projection(Projections.fields(new Document("name", 1))/*Projections.include("name")*/)) {
            System.out.println(document.toJson());
        }
    }


}
