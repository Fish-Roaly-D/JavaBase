package com.roily.designpatterns.dpmain.adapter;

/**
 * @version 1.0.0
 * @Description
 * @ClassName X86Soft.java
 * @author: RoilyFish
 * @date: 2022/6/6 18:27
 */
public class X86Soft implements ISoftware {

    private Rosetta2 rosetta = new Rosetta2();

    @Override
    public String system() {
        return "X86";
    }

    @Override
    public String run(MacPC macPC) {

        if (macPC.getChip().equals("Intel") && this.system().equals("X86")) {
            System.out.println("运行" + X86Soft.class.getName());
        } else if (macPC.getChip().equals("M1") && this.system().equals("X86")) {
            rosetta.run(macPC);
            return null;
        }
        return null;
    }
}
