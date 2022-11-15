package com.roily.base.collectionframework.base.stack.stackuseful;


import com.roily.base.collectionframework.base.stack.arraystack.ArrayStack;

/**
 * @version 1.0.0
 * @Description 符号匹配
 * @ClassName SymbolMatch.java
 * @author: RoilyFish
 * @date: 2022/5/21 19:35
 */
public class SymbolMatch {

    ArrayStack<Character> stack = new ArrayStack<>();

    /**
     * 符号匹配这里以()为例，比如 (1*2)
     *
     * 例子:((5-3)*4-1)
     */
    public boolean check(String expression){

        char[] chars = expression.toCharArray();

        for (Character aChar : chars) {

            if (aChar.equals('('))
                stack.push(aChar);

            if (aChar.equals(')'))
                stack.pop();
        }
        return stack.isEmpty();
    }

    public void clearStack(){
        stack.clear();
    }
    //测试
    public static void main(String[] args) {

        String expression01 = "((5-3)*4-1)";
        String expression02 = "((5-3)*4-1";
        String expression03 = "5-3*4-1";

        SymbolMatch symbolMatch = new SymbolMatch();

        System.out.println(expression01+"是否匹配成功=>"+symbolMatch.check(expression01));
        symbolMatch.clearStack();
        System.out.println(expression02+"是否匹配成功=>"+symbolMatch.check(expression02));
        symbolMatch.clearStack();
        System.out.println(expression03+"是否匹配成功=>"+symbolMatch.check(expression03));
        symbolMatch.clearStack();
    }

}
