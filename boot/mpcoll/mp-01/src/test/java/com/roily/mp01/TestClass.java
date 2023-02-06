package com.roily.mp01;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.roily.mp01.entity.User;
import com.roily.mp01.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2022/10/26/14:19
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    UserService userService;

    @Test
    public void testLogicField() {

        final User user = new User();
        user.setName("yuyc");
        userService.save(user);

        final List<User> list = userService.list();
        System.out.println(list);
    }

    @Test
    public void testXml() {
        final User user = userService.selOneXml();

        System.out.println(user);
    }
    @Test
    public void updateTime() {


        final LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>().eq(User::getId, 14).set(User::getName, "nnnnn");

        final boolean update = userService.update(updateWrapper);

    }

    @Test
    public void testVersion() throws InterruptedException {

        final User user = userService.getById(18);

        final Callable update1 = () -> {
            user.setName("update");
            return userService.updateById(user);
        };

        final Callable update2 = () -> {
            user.setName("update");
            return userService.updateById(user);
        };
        final Callable update3 = () -> {
            user.setName("update");
            return userService.updateById(user);
        };
        final Callable update4 = () -> {
            user.setName("update");
            return userService.updateById(user);
        };
        final Callable update5 = () -> {
            user.setName("update");
            return userService.updateById(user);
        };

        final ExecutorService service = Executors.newFixedThreadPool(10);

        final Collection<Callable<Boolean>> threads = Arrays.asList(update1, update2, update3, update4, update5);

        final List<Future<Boolean>> futures = service.invokeAll(threads);

        futures.forEach(ele -> {
            try {
                System.out.println(ele.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        service.shutdown();

    }

}
