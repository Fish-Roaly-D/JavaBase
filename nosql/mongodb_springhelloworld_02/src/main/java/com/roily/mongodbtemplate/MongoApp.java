package com.roily.mongodbtemplate;

import com.mongodb.bulk.BulkWriteResult;
import com.roily.entity.Address;
import com.roily.entity.Person;
import com.roily.util.MongoTemplateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) throws Exception {

        final MongoOperations mongoOps = MongoTemplateUtil.mongoOperations();
        final Person person = new Person();
        person.setId(new ObjectId());
        person.setAge(22);
        person.setName("person4");
        person.setAddress(new Address("长桥街道", "上海", "10010"));

        log.info("insertMMany");
        final Collection<Person> insertReturn = mongoOps.insert(Collections.singletonList(person), "person");
        log.info("回写插入结果" + insertReturn);

        log.info("bulkOps");
        final BulkWriteResult bulkWriteResult = mongoOps.bulkOps(BulkOperations.BulkMode.ORDERED, Person.class, "person").insert(Collections.singletonList(person.setId(new ObjectId()))).execute();
        log.info(bulkWriteResult);

        log.info("find");
        final List<Person> find = mongoOps.find(new Query(), Person.class, "person");
        log.info(find);
    }
}

