package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import lombok.Data;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AbstractAirPlane.java
 * @author: RoilyFish
 * @date: 2022/6/7 23:51
 */
@Data
public abstract class AbstractAirPlane {

    //飞机型号 编号
    private String id;

    //飞机型号 波音747.。。
    private String typeName;

    //生命值
    private Integer lifeValue;

    public AbstractAirPlane(String id, String typeName, Integer lifeValue) {
        this.id = id;
        this.typeName = typeName;
        this.lifeValue = lifeValue;
    }

    //飞机被打了
    void hit() {
        if (lifeValue > 0){
            lifeValue--;
            System.out.println(typeName + id + "号被打了，剩余血量：" + lifeValue);
        }
        else
        //血量小于零说明被回收了
        System.out.println(typeName + id + "号被回收了：");
    }

    //飞机移出屏幕
    void remove() {
        if (lifeValue > 0){
            lifeValue = 0;
            System.out.println(typeName + id + "号移出屏幕：");
        }else {
            System.out.println(typeName + id + "号以及被移出屏幕：");
        }
    }

}
