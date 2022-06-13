package InterpreterPattern;

import java.util.Map;

/**
 * 抽象接口表达式
 * Author: icebigpig
 * Data: 2022/6/13 9:23
 * Version 1.0
 **/

public interface AbstractExpression {

    /**
     * 解释表达式的抽象方法
     * @param map 比如现有表达式：a + b；那么map中存放的就是{a=10,b=20}
     * @return 返回解释后的值。
     */
    int interpreter(Map<String, Integer> map);

}
