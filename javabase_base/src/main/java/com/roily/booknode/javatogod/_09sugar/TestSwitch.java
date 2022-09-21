package com.roily.booknode.javatogod._09sugar;

/**
 * @Date: 2022/09/05/10:26
 * @Description:
 */
public class TestSwitch {


    public void testSwitch() {

        int i1 = 1;
        switch (i1) {
            case 1:
                System.out.println();
                break;
        }

        byte b1 = 1;
        switch (b1) {
            case 1:
                System.out.println();
                break;
        }

        char c1 = 'a';
        switch (c1) {
            case 'a':
                break;
        }

        short s1 = 1;
        switch (s1) {
            case 1:
                System.out.println();
                break;
        }
    }


    public void switchSupportString() {
        String str = "abc";
        switch (str) {
            case "123":
                break;
            case "abc":
                break;
            default:
                break;
        }
    }
    public void switchSupportEnum(Season season) {
        switch (season) {
            case SPRING:
                System.out.println(season.name());
                break;
            case SUMMER:
                System.out.println(season);
                break;
            default:
                break;
        }
    }


}

enum Season{
    SPRING,SUMMER;
}

