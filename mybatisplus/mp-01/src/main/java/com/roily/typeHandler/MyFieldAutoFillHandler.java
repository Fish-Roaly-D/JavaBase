package com.roily.typeHandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName MyFieldAutoFillHandler.java
 * @author: RoilyFish
 * @date: 2022/4/3 16:56
 */
@Component
public class MyFieldAutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        setFieldValByName("updateTime", new Date(System.currentTimeMillis()), metaObject);
        setFieldValByName("createTime", new Date(System.currentTimeMillis()), metaObject);
        setFieldValByName("deleted", 0, metaObject);

        //this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        //// 或者
        //this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
        //// 或者
        //this.fillStrategy(metaObject, "createTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(System.currentTimeMillis()), metaObject);
    }
}
