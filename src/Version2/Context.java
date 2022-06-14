package Version2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:57
 * Version 1.0
 **/

public class Context {

    /**
     * 存储全局数据变量
     */
    private final Map<Expression, Integer> map = new HashMap<>();

    /**
     * 存储数据方法
     */
    public void add(Expression s, Integer value){
        map.put(s, value);
    }

    /**
     * 查找数据方法
     */
    public Integer lookup(Expression s){
        return map.get(s);
    }

    /**
     * 构建语法树的主要方法
     */
    public static Expression build(String str) {
        //主要利用栈来实现
        Stack<Expression> objects = new Stack<>();

        // 对每个字符串进行遍历判断
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // 遇到运算符号*号时候
            if (c == '*') {
                // 取出栈顶的两个元素
                Expression pop = objects.pop();
                objects.push(new MultiplyOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
            } else if (c == '/') {
                // 取出栈顶的两个元素
                Expression pop = objects.pop();
                objects.push(new MultiplyOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
            } else if (c == '+'){
                //遇到运算符号+号时候
                //先出栈
                Expression pop = objects.pop();
                //将运算结果入栈
                objects.push(new AddOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
            } else if (c == '-'){
                //遇到减号类似加号
                Expression pop = objects.pop();
                objects.push(new SubOperation(pop, new TerminalExpression(String.valueOf(str.charAt(++i)))));
                // TODO 这里只处理了单个字符，当出现多位数值会出现问题
            } else {
                //遇到非终结符直接入栈（基本就是第一个数字的情况）
                objects.push(new TerminalExpression(String.valueOf(str.charAt(i))));
            }
        }
        //把最后的栈顶元素返回
        return objects.pop();
    }
}
