package com.roily.designpatterns.dpmain.composite.open;

/**
 * @version 1.0.0
 * @Description 抽象
 * @ClassName CompanyComponent.java
 * @author: RoilyFish
 * @date: 2022/6/7 1:22
 */
public interface CompanyComponent {
    //添加组件
    Boolean addComponent(CompanyComponent companyComponent);

    //移除组件
    Boolean removeComponent(CompanyComponent companyComponent);

    //遍历展示
    void show(int depth);
}
