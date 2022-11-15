// package com.com.roily.mp01;
//
//
// import com.baomidou.mybatisplus.core.conditions.Wrapper;
// import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
// import com.com.roily.mp01.backstage.entity.UserEntity;
// import com.com.roily.mp01.backstage.mapper.UserMapper;
// import com.com.roily.mp01.backstage.service.UserService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.List;
//
//
// @SpringBootTest
// class Mp01ApplicationTests {
//
//     @Autowired
//     UserEntity userEntity;
//
//     @Test
//     public void test() {
//
//         QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
//
//         wrapper.like("name", "于");
//
//         List<UserEntity> userEntities = userEntity.selectList(wrapper);
//
//         userEntities.forEach(System.out::println);
//
//     }
//
// }
//
// @SpringBootTest
// class mapperTest {
//
//     @Autowired
//     UserMapper userMapper;
//
//
//     @Test
//     public void test01() {
//
//
//         QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
//
//         wrapper.like("name", "于").and((queryWrapper) -> {
//             queryWrapper.gt("id", 1L);
//         });
//
//         List<UserEntity> userEntities = userMapper.selectList(wrapper);
//
//         userEntities.forEach(System.out::println);
//
//
//     }
//
//
// }
//
//
// @SpringBootTest
// class serviceTest {
//
//     @Autowired
//     UserService userService;
//
//
//     @Test
//     public void test01() {
//
//
//         List<UserEntity> list1 = userService.list();
//
//         list1.forEach(System.out::println);
//         QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
//
//         wrapper.like("name", "于").and((queryWrapper) -> {
//             queryWrapper.gt("id", 1L);
//         });
//
//         List<UserEntity> list2 = userService.list(wrapper);
//         list2.forEach(System.out::println);
//
//
//     }
//
//
// }
//
// interface xxxx {
//
//     default void method() {
//         System.out.println("xxx");
//     }
//
// }