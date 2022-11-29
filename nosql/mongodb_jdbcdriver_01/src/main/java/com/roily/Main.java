package com.roily;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.roily.entity.Score;
import com.roily.entity.User;
import com.roily.enumutil.MongoUtil;
import org.bson.Document;

import java.util.Arrays;
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

}