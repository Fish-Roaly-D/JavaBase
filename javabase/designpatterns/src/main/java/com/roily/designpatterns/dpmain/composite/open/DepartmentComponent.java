package com.roily.designpatterns.dpmain.composite.open;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0.0
 * @Description 部门类
 * @ClassName DepartmentComponent.java
 * @author: RoilyFish
 * @date: 2022/6/7 1:27
 */
@Data
@AllArgsConstructor
public class DepartmentComponent implements CompanyComponent {

    /**
     * 组件名称
     */
    private String name;
    /**
     * 树枝节点下的叶子
     */
    public List<CompanyComponent> components;


    @Override
    public Boolean addComponent(CompanyComponent companyComponent) {
        return components.add(companyComponent);
    }

    @Override
    public Boolean removeComponent(CompanyComponent companyComponent) {
        return components.remove(companyComponent);
    }

    @Override
    public void show(int depth) {
        //节点越深，等级越低
        for (int i = 0; i < depth; i++) {
            System.out.printf("-");
        }
        System.out.println(this.getName());
        //递归遍历
        components.forEach(companyComponent -> {
            companyComponent.show(depth + 1);
        });

    }
}
