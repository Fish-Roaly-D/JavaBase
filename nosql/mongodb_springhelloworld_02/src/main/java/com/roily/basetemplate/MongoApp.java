package com.roily.basetemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mongodb.client.MongoClients;
import com.roily.entity.Address;
import com.roily.entity.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) throws Exception {

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "test");

        final Person person = new Person();
        person.setId(new ObjectId());
        person.setAge(22);
        person.setName("person4");
        person.setAddress(new Address("长桥街道", "上海", "10010"));

        mongoOps.insert(person,"person");


        System.out.println(mongoOps.findOne(new Query(where("name").is("person1")), Person.class, "person"));

        // mongoOps.dropCollection("person");
    }
}

