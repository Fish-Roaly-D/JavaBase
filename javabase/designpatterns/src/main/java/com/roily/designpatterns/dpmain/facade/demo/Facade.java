package com.roily.designpatterns.dpmain.facade.demo;

/**
 * @className：Facade
 * @author: rolyfish
 * @description: 护士小姐姐
 * @dte: 2022/6/19 23:54
 */
public class Facade {

    private IDepartment digestive;
    private IDepartment assay;
    private IDepartment outSide;
    private IDepartment radiation;
    {
        //初始化

        //消化科
        digestive = new DigestiveDept();
        //化验科
        assay = new AssayDept();
        //外科
        outSide = new OutSideDept();
        //放射科
        radiation = new RadiationDept();
    }

    /**
     * 我想看那个胃病
     */
    public void fixStomachError(){
        System.out.println("护士小姐说，1⃣️先缴费挂号2⃣️消化科看病3⃣️化验科化验4⃣️吃药");
        System.out.println("缴费");
        digestive.doWork();
        assay.doWork();
        System.out.println("吃药、好了");
    }

    /**
     * 摔了一跤，查查问题
     */
    public void fixError(){
        System.out.println("护士小姐说，1⃣️先缴费挂号2⃣️外科看病3⃣️放射科做ct4⃣️吃药");
        System.out.println("缴费");
        outSide.doWork();
        radiation.doWork();
        System.out.println("吃药、好了");
    }

}
