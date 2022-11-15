package com.roily.designpatterns.dpmain.composite.open;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description 员工类
 * @ClassName EmployeeComponent.java
 * @author: RoilyFish
 * @date: 2022/6/7 1:27
 */
@Data
@AllArgsConstructor
public class EmployeeComponent implements CompanyComponent {

    /**
     * 组件名称
     */
    private String name;

    @Override
    public Boolean addComponent(CompanyComponent companyComponent) {
        return false;
    }

    @Override
    public Boolean removeComponent(CompanyComponent companyComponent) {
        return true;
    }

    @Override
    public void show(int depth) {
        //节点越深，等级越低
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(this.getName());
    }
}
