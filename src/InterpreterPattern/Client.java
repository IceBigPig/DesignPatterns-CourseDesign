package InterpreterPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: icebigpig
 * Data: 2022/6/13 9:30
 * Version 1.0
 **/

public class Client {

    public static void main(String[] args) {
        // 表达式
        String strExpression = "a+b-c+d";
        // 表达式对应的值
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 10);
        map.put("c", 8);
        map.put("d", 13);

        // 创建计算器
        Calculator calculator = new Calculator(strExpression);
        // 计算
        int result = calculator.calculate(map);
        System.out.println("表达式：" + strExpression + "的计算结果为：" + result);
    }
}
