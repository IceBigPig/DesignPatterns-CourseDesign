package InterpreterPattern;

import java.util.Map;
import java.util.Stack;

/**
 * Author: icebigpig
 * Data: 2022/6/13 9:29
 * Version 1.0
 **/
public class Calculator {

    /**
     * 表达式
     */
    private final AbstractExpression expression;

    /**
     * 计算算法方法
     */
    public Calculator(String strExpression) {
        char[] charArray = strExpression.toCharArray();

        /*
            定义栈用于存储表达式，因示例简单故不考虑运算顺序
         */
        Stack<AbstractExpression> stack = new Stack<>();


        AbstractExpression left;
        AbstractExpression right;

        /*
            解析表达式
         */
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    // 获取左表达式
                    left = stack.pop();
                    // 定义右表达式
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    // 将其合并为一个新的表达式,并放入栈中。
                    System.out.println(charArray[i]);
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    // 过程跟加法一样
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    System.out.println(charArray[i]);
                    break;
                default:
                    // 不是运算符
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    System.out.println(charArray[i]);
                    break;
            }
        }
        // 遍历完成获取最终解析好的表达式。
        this.expression = stack.pop();
    }

    /**
     * 根据参数计算结果数值
     * @param map 表达式对应的值
     * @return 计算的结果
     */
    public int calculate(Map<String, Integer> map) {
        return this.expression.interpreter(map);
    }
}
