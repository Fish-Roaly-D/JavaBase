package com.roily.withpojos;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.roily.entity.Address;
import com.roily.entity.Person;
import com.roily.enumutil.MongoUtil;
import org.bson.types.ObjectId;
import org.junit.Test;

/**
 * @Date: 2022/12/01/10:56
 * @Description:
 */
public class InsertWithPojos {

    final Block<Object> personBlock = person12 -> System.out.println(person12);

    @Test
    public void testInsertOne() {

        final MongoCollection<Person> personCollection = MongoUtil.mongoCollection(Person.class, "person", "test");

        final Person person = new Person();
        person.setId(new ObjectId());
        person.setAge(22);
        person.setName("person1");
        person.setAddress(new Address("长桥街道", "上海", "10010"));
        personCollection.insertOne(person);
        for (Person person1 : personCollection.find()) {
            personBlock.apply(person1);
        }
    }


}
