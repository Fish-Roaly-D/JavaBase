package com.roily.designpatterns.dpmain.composite.open;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 测试
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/7 1:43
 */
public class Client {

    private static DepartmentComponent beijing;

    static {
        beijing = new DepartmentComponent("北京总公司", new ArrayList<>());

        DepartmentComponent shanghai = new DepartmentComponent("上海分公司", new ArrayList<>());
        DepartmentComponent wuhan = new DepartmentComponent("武汉分公司", new ArrayList<>());
        DepartmentComponent suzhou = new DepartmentComponent("苏州分公司", new ArrayList<>());
        DepartmentComponent hr = new DepartmentComponent("人事部门", new ArrayList<>());
        DepartmentComponent fd = new DepartmentComponent("财务部门", new ArrayList<>());
        DepartmentComponent td = new DepartmentComponent("技术部门", new ArrayList<>());
        EmployeeComponent hrManager = new EmployeeComponent("人事经理");
        EmployeeComponent employeeA = new EmployeeComponent("员工A");
        EmployeeComponent employeeB = new EmployeeComponent("员工B");
        EmployeeComponent manager = new EmployeeComponent("董事长");

        hr.addComponent(hrManager);
        hr.addComponent(employeeA);
        hr.addComponent(employeeB);
        //上海分公司下有
        shanghai.addComponent(fd);
        shanghai.addComponent(hr);
        shanghai.addComponent(td);

        beijing.addComponent(shanghai);
        beijing.addComponent(suzhou);
        beijing.addComponent(wuhan);
        beijing.addComponent(manager);
    }

    public static void main(String[] args) {

        System.out.println(beijing);
        beijing.show(0);
    }

}
