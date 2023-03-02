package com.roly.dubbo_zookeeper_consumer.consumer;

import com.roly.cloud.entity.User;
import com.roly.cloud.service.ServiceProvider;
import com.roly.cloud.service.UserService;
import lombok.Data;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: rolyfish
 */
@RestController
public class ServiceConsumer {


    @DubboReference
    ServiceProvider serviceProvider;

    @PostMapping("/consumer")
    public String consumer(){
        return serviceProvider.msg();
    }
    @DubboReference
    UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll() throws SQLException {
        return userService.getAll();
    }

}
