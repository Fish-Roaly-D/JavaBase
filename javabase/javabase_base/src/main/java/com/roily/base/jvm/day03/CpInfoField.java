package com.roily.base.jvm.day03;

/**
 * @classname：CpInfoIntAndFloat
 * @author: rolyfish
 * @description: int 和 float 常量池
 * @date: 2022/8/7 13:45
 */
public class CpInfoField {

    StringBuilder sb = new StringBuilder();

    StringBuffer sb2;

    long l = 1L;

    long[] ls = {1L,2L};

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public StringBuffer getSb2() {
        return sb2;
    }

    public void setSb2(StringBuffer sb2) {
        this.sb2 = sb2;
    }
}