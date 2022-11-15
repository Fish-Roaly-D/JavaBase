package com.roily.base.collectionframework.base.stack.stackuseful;

import com.roily.base.collectionframework.base.stack.arraystack.ArrayStack;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 计算后缀表达式
 * @ClassName CalculateSuffix.java
 * @author: RoilyFish
 * @date: 2022/5/23 1:15
 */
public class CalculateSuffix {

    ArrayStack<Integer> stack = new ArrayStack<>();

    public Integer calculate(String suffix) {

        char[] chars = suffix.toCharArray();

        Integer first;
        Integer second;
        Integer finalValue = null;
        for (Character aChar : chars) {

            //如果是数字，转化为数字，压栈
            if (aChar.compareTo('9') <= 0 && aChar.compareTo('0') >= 0) {
                stack.push(Integer.valueOf(aChar.toString()));
                continue;
            } else {
                first = stack.pop();
                second = stack.pop();

                switch (aChar) {
                    case '+':
                        finalValue = second + first;
                        break;
                    case '-':
                        finalValue = second - first;
                        break;
                    case '*':
                        finalValue = second * first;
                        break;
                    case '/':
                        finalValue = second / first;
                        break;
                    default:
                        break;
                }
                stack.push(finalValue);
            }
        }

        return stack.pop();
    }

    @Test
    public void test() {

        SymbolMatch symbolMatch = new SymbolMatch();
        ExpressionInfixToSuffix expressionInfixToSuffix = new ExpressionInfixToSuffix();
        CalculateSuffix calculateSuffix = new CalculateSuffix();
        String express = "6-3*(5+2)-9+(5-4)";
        //符号检验
        if (symbolMatch.check(express)) {
            String suffix;
            System.out.println(express + "转化为后缀表达式=>" + (suffix = expressionInfixToSuffix.infixToSuffix(express)));

            System.out.println("结果为=>" + calculateSuffix.calculate(suffix));
        } else
            System.out.println("符号监测错误");
    }

}
