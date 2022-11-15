package com.roily.booknode.javatogod._01faceobj.aboutextends;

import lombok.Data;

/**
 * @Date: 2022/10/25/11:09
 * @Description:
 */

public class CloneExample {

    private StringBuilder sb;
    private String str;

    public CloneExample(StringBuilder sb, String str) {
        this.sb = sb;
        this.str = str;
    }

    public CloneExample(CloneExample clone) {
        this.str = clone.str;
        this.sb = new StringBuilder(clone.sb.toString());
    }

    public static void main(String[] args) {

        final CloneExample cloneExample1 = new CloneExample(new StringBuilder(), "");

        final CloneExample cloneExample2 = new CloneExample(cloneExample1);

    }
}
