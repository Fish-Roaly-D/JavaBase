import com.roily.entity.Person;
import com.roily.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @Date: 2022/12/08/15:11
 * @Description:
 */
// @SpringJUnitConfig
public class MongoClientTest {

    Log log = LogFactory.getLog(MongoClientTest.class);

    @Test
    public void testMongoClient() {

        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.roily.common.cnfig.MongoClientConfig.class);
        final MongoOperations mongoTemplate = applicationContext.getBean(MongoOperations.class);
        final List<Person> peoples = mongoTemplate.find(new Query(), Person.class);
        for (Person people : peoples) {
            log.info(people);
        }

    }

    @Test
    public void testMongoClientXML() {

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-mongodb.xml");
        final MongoOperations mongoTemplate = applicationContext.getBean(MongoOperations.class);
        final List<Person> peoples = mongoTemplate.find(new Query(), Person.class);
        for (Person people : peoples) {
            log.info(people);
        }

    }

    /**
     * use mongoDatabaseFactory
     */
    @Test
    public void testMongoDataBaseFactoryXML() {

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-mongoDatabaseFactory.xml");
        final MongoOperations mongoOperations = applicationContext.getBean(MongoTemplate.class);
        final List<Person> peoples = mongoOperations.find(new Query(), Person.class);
        for (Person people : peoples) {
            log.info(people);
        }

    }

    /**
     * @ID
     */
    @Test
    public void testATID() {

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-mongoDatabaseFactory.xml");
        final MongoOperations mongoOperations = applicationContext.getBean(MongoTemplate.class);

        final User user1 = new User("id2", "name", 23);
        final User insert = mongoOperations.insert(user1,"user");

        final List<User> users = mongoOperations.find(new Query(), User.class);
        for (User user : users) {
            log.info(user);
        }
    }

    /**
     * mongoClientFactoryBean
     */
    @Test
    public void testMongoClientFactoryBean() {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-mongoClientFactoryBean.xml");
        final MongoOperations mongoOperations = applicationContext.getBean(MongoTemplate.class);
        final List<User> users = mongoOperations.find(new Query(), User.class);
        for (User user : users) {
            log.info(user);
        }
    }

}
