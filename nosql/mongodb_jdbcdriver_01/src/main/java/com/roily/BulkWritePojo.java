package com.roily;

import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.DeleteManyModel;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import com.roily.entity.User2;
import com.roily.enumutil.MongoUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Date: 2022/11/30/17:22
 * @Description:
 */
public class BulkWritePojo {

    @Test
    public void insertPojo() {
        final MongoCollection<User2> users = MongoUtil.mongoCollection(User2.class, "users", "mongodb://localhost:27017", "test");

        System.out.println("=====初始数据=======");
        for (User2 user2 : users.find()) {
            System.out.println(user2);
        }

        final WriteModel<User2> deleteOneModel = new DeleteOneModel<>(Filters.eq("name", "insertOne"));

        final WriteModel<User2> deleteManyModel = new DeleteManyModel<>(Filters.eq("name", "insertMany"));

        final WriteModel<User2> insertOneModel = new InsertOneModel<>(new User2("bulkWrite.insertOneModel", 23));

        final BulkWriteResult bulkWriteResult = users.bulkWrite(Arrays.asList(deleteOneModel, deleteManyModel, insertOneModel));

        System.out.println(bulkWriteResult);

        System.out.println("=====修改后=======");
        for (User2 user2 : users.find()) {
            System.out.println(user2);
        }

    }


}
