package com.roily;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.roily.entity.Department;
import com.roily.entity.ResultEntity;
import com.roily.entity.User2;
import com.roily.entity.User3;
import com.roily.mapper.DepartmentMapper;
import com.roily.mapper.ResultMapper;
import com.roily.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Test
    void contextLoads() {

        System.out.println(sqlSessionTemplate.getConnection());

    }

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    void testConn() {

        List<Department> departments = departmentMapper.selectList(null);

        departments.forEach(System.out::println);

    }

    @Autowired
    ResultMapper resultMapper;

    @Test
    void testEntity() {

        ResultEntity reByID = resultMapper.getREByID(1001);
        System.out.println(reByID);

    }

    @Test
    void testEntity2() {

        Map<String, Object> reByIDMap = resultMapper.getREByIDMap(1001);
        System.out.println(reByIDMap);
        ResultEntity build = ResultEntity.builder()
                .empId((Integer) reByIDMap.get("empId"))
                .department((String) reByIDMap.get("department"))
                .empName((String) reByIDMap.get("empName"))
                .build();
        System.out.println(build);

        //
        //
        //System.out.println(reByID);

    }

    @Autowired
    UserMapper userMapper;

    @Test
    void test01() {

        List<User2> users = userMapper.selectList(null);

        System.out.println(users);

    }

    @Test
    void test03() {


        Map<String, Object> map = new HashMap<>();
        map.put("name", "");
        List<User2> users = userMapper.selectByMap(map);
        System.out.println(users);

    }

    @Test
    void test02() {
        QueryWrapper<User2> wrapper = new QueryWrapper<>(
                User2.builder()
                        .name("于")
                        .build());

        List<User2> user2s = userMapper.selectList(wrapper);

        user2s.forEach(System.out::println);


    }

    @Test
    public void test3() {

        int i = userMapper.deleteById(1);


    }

    @Test
    public void insert() {

        User2 user = User2.builder()
                .version(0)
                .name("于延闯")
                .email("10568192255@QQ.com")
                .build();

        int insert = userMapper.insert(user);

    }

    @Test
    public void update() {

        User2 user2 = userMapper.selectById(18L);
        user2.setName("于延闯XXXXXXXXXX");

        userMapper.updateById(user2);

        //User2 user = User2.builder()
        //        .id(18L)
        //        .name("于延闯XXXXXXXXXX")
        //        .build();
        //
        //int i = userMapper.updateById(user);


    }

    @Test
    public void update2() {


        User2 user = User2.builder()
                .id(18L)
                .name("")
                .build();

        int i = userMapper.updateById(user);


    }


    @Test
    public void xxx() throws InterruptedException {
        Long id = 16L;

        new Thread(() -> {

            User2 user1 = userMapper.selectById(id);
            System.out.println(Thread.currentThread().getName() + "获取对象：=》" + user1);
            user1.setName("乐观锁111");
            userMapper.updateById(user1);
            System.out.println(Thread.currentThread().getName() + "更新了对象：=》" + user1);

        }).start();

        new Thread(() -> {

            User2 user1 = userMapper.selectById(id);
            System.out.println(Thread.currentThread().getName() + "获取对象：=》" + user1);
            user1.setName("乐观锁222");
            userMapper.updateById(user1);
            System.out.println(Thread.currentThread().getName() + "更新了对象：=》" + user1);

        }).start();

        Thread.sleep(1000);

    }

    @Test
    public void xxxx() throws InterruptedException {
        Long id = 16L;
        new Thread(() -> {
            int row = 0;
            do {
                User2 user1 = userMapper.selectById(id);
                System.out.println(Thread.currentThread().getName() + "获取对象：=》" + user1);
                user1.setName("乐观锁111");
                row = userMapper.updateById(user1);
                System.out.println(Thread.currentThread().getName() + "更新了对象：=》" + user1);
            } while (row == 0);
        }).start();

        new Thread(() -> {
            int row = 0;
            do {
                User2 user1 = userMapper.selectById(id);
                System.out.println(Thread.currentThread().getName() + "获取对象：=》" + user1);
                user1.setName("乐观锁222");
                row = userMapper.updateById(user1);
                System.out.println(Thread.currentThread().getName() + "更新了对象：=》" + user1);
            } while (row == 0);
        }).start();

        Thread.sleep(1000);

    }

    @Test
    public void test5() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();
        wrapper.like("name", "于");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test6() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();
        wrapper.like("name", "于");
        List<Object> list = userMapper.selectObjs(wrapper);
        System.out.println(list.get(0));
    }


    /****************************Compare********************************************/


}

@SpringBootTest
class CompareTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>(User2.builder()
                .name("").build());

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test02() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "");
        wrapper.allEq(StringUtils.isEmpty((CharSequence) map.get("name")), map, true);

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test03() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        //wrapper.like("name","于");
        wrapper.notLike("name", "于");

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test04() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        //wrapper.in("id",1,2,3,4);

        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        wrapper.in(!ids.isEmpty(), "id", ids);

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test05() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        wrapper.select(" id , deleted , name , count(*) as xx ");
        wrapper.groupBy("name", "id");
        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test06() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "");
        wrapper.func((t) -> {
            if (!StringUtils.isEmpty((String) map.get("name"))) {
                t.eq("name", map.get("name"));
            }
            t.eq("email", "zxxxx");
        });

        wrapper.apply(" 1 = {0} ", 1);
        //wrapper.last("limit 1 ");

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test07() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        wrapper.exists(" (select id from user) ");

        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test08() {

        QueryWrapper<User2> wrapper = new QueryWrapper<>();

        //wrapper.select(" id ,email ", "name");
        //wrapper.select(User2.class, tableFieldInfo -> true);


        List<User2> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);

    }


}