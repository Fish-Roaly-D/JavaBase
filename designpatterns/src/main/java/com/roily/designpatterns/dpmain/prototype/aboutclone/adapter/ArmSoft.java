package com.roily.designpatterns.dpmain.prototype.aboutclone.adapter;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ArmSoft.java
 * @author: RoilyFish
 * @date: 2022/6/6 18:26
 */
public class ArmSoft implements ISoftware{

    @Override
    public String system() {
        return "arm";
    }

    @Override
    public String run(MacPC macPC) {
        if (macPC.getChip().equals("M1") && this.system().equals("arm")){
            System.out.println("运行"+ArmSoft.class.getName());
        }else {
            System.out.println("运行不了");
        }
        return null;
    }

}
