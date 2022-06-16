package Version2;

import java.util.*;

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
    public static Expression build(List<String> strings) {
        //主要利用栈来实现
        Stack<Expression> objects = new Stack<>();

        // 对每个字符串进行遍历判断
        for (String s : strings) {
            // 遇到运算符号*号时候
            if (Objects.equals(s, "*")) {
                // 取出栈顶的两个元素
                Expression pop_1 = objects.pop();
                Expression pop_2 = objects.pop();
                // 生成带有运算符号的节点
                objects.push(new MultiplyOperation(pop_1, pop_2));
            } else if (Objects.equals(s, "/")) {
                // 取出栈顶的两个元素
                Expression pop_1 = objects.pop();
                Expression pop_2 = objects.pop();
                // 生成带有运算符号的节点
                objects.push(new MultiplyOperation(pop_1, pop_2));
            } else if (Objects.equals(s, "+")) {
                //遇到运算符号+号时候
                // 取出栈顶的两个元素
                Expression pop_1 = objects.pop();
                Expression pop_2 = objects.pop();
                //将运算结果入栈
                objects.push(new AddOperation(pop_1, pop_2));
            } else if (Objects.equals(s, "-")) {
                //遇到减号类似加号
                // 取出栈顶的两个元素
                Expression pop_1 = objects.pop();
                Expression pop_2 = objects.pop();
                objects.push(new SubOperation(pop_2, pop_1));
            } else {
                //遇到非终结符直接入栈
//                objects.push(new TerminalExpression(s));
                objects.push(new TerminalExpression(Double.parseDouble(s)));
            }
        }
        //把最后的栈顶元素返回
        return objects.pop();
    }
}
