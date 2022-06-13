package InterpreterPattern;

import java.util.Map;

/**
 * 变量解析器类
 * Author: icebigpig
 * Data: 2022/6/13 9:27
 * Version 1.0
 **/

public class VarExpression implements AbstractExpression {

    /**
     * 公式中的变量
     */
    private final String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 通过key获取所对应的值
     * @param map 比如现有表达式：a + b；那么map中存放的就是{a=10,b=20}
     */
    @Override
    public int interpreter(Map<String, Integer> map) {
        return map.get(key);
    }
}
