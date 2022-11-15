package com.roily.base.collectionframework.base.stack.stackuseful;

import com.roily.base.collectionframework.base.stack.arraystack.ArrayStack;
import org.junit.Test;
import org.springframework.util.ObjectUtils;

/**
 * @version 1.0.0
 * @Description 中缀表达式转后缀表达式
 * @ClassName ExpressionInfixToSuffix.java
 * @author: RoilyFish
 * @date: 2022/5/23 0:03
 */
public class ExpressionInfixToSuffix {

    //协助栈A
    ArrayStack<Character> aStack = new ArrayStack<>();

    public String infixToSuffix(String express) {
        //存放后缀表达式的数组B
        Character[] b;

        char[] chars = express.toCharArray();

        b = new Character[express.length()];
        //数组b下标
        int arrayBIndex = 0;
        for (Character aChar : chars) {

            //如果式操作数,直接加入数组
            if (aChar.compareTo('9') <= 0 && aChar.compareTo('0') >= 0){
                b[arrayBIndex++] = aChar;
                //进行下一次循环
                continue;
            }
            /**
             * + - 号优先级最低。
             * ①弹出（之前的所有 运算符
             * ②压栈
             */
            if(aChar.equals('+') || aChar.equals('-')){
                Character temp;
                //栈不为空、且不是 （
                while (!aStack.isEmpty() && !(temp = aStack.peek()).equals('(')){
                    //弹栈、加入数组B
                    aStack.pop();
                    b[arrayBIndex++] = temp;
                }
                //否则压栈
                aStack.push(aChar);
                //进行下一次循环
                continue;
            }
            /**
             * * / 号优先级比 + - 高。
             * ①弹出（之前的的所有 * / 运算符
             * ②压栈
             */
            if(aChar.equals('*') || aChar.equals('/')){
                Character temp;
                //栈不为空、且弹出的不是(、且是 * 或/
                while (!aStack.isEmpty() && !(temp = aStack.peek()).equals('(') && (temp.equals('*') || temp.equals('/'))){
                    //弹栈、加入数组B
                    aStack.pop();
                    b[arrayBIndex++] = temp;
                }
                //否则压栈
                aStack.push(aChar);
                //进行下一次循环
                continue;
            }
            //如果是（  直接入栈
            if(aChar.equals('(')){
                aStack.push(aChar);
                //进行下一次循环
                continue;
            }

            /**
             * 如果是）括号
             * 弹出所有（之前的
             */
            if(aChar.equals(')')) {
                Character temp;
                //栈不为空、且弹出的不是(
                while (!aStack.isEmpty() && !(temp = aStack.pop()).equals('(')){
                    //加入数组B
                    b[arrayBIndex++] = temp;
                }
                continue;
            }
        }
        //遍历结束，将A栈中剩余的，弹出来放入数组B

        //栈不为空、且弹出的不是(
        while (!aStack.isEmpty()){
            //加入数组B
            b[arrayBIndex++] = aStack.pop();
        }

        StringBuffer sb = new StringBuffer();
        for (Character character : b)
            sb.append(ObjectUtils.isEmpty(character)?"":character);


        return sb.toString();
    }


    public static void main(String[] args) {

        ExpressionInfixToSuffix expressionInfixToSuffix = new ExpressionInfixToSuffix();

        System.out.println(expressionInfixToSuffix.infixToSuffix("1+3*(9-2)+9"));

    }

    @Test
    public void test(){
        SymbolMatch symbolMatch = new SymbolMatch();
        ExpressionInfixToSuffix expressionInfixToSuffix = new ExpressionInfixToSuffix();
        String express = "6-3*(5+2)-9+(5-4)";
        //符号检验
        if (symbolMatch.check(express))
            System.out.println(express+"转化为后缀表达式=>"+expressionInfixToSuffix.infixToSuffix(express));
        else
            System.out.println("符号监测错误");
    }
}
