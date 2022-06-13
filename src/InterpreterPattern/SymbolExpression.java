package InterpreterPattern;

import java.util.Map;

/**
 * Author: icebigpig
 * Data: 2022/6/13 9:28
 * Version 1.0
 **/
public class SymbolExpression implements AbstractExpression {

    /**
     * 假如现有表达式：a + b - c 需要解析。
     * 分析：
     *  1、一个运算符连接的是它左右两个数字。
     *  2、如上表达式【+】号连接的是吧“a"和"b"，【-】号连接的是"a + b"和“c”。
     *  3、经次分析我们将运算符连接的左右都看成是一个表达式也就是Expression。
     */

    // 左表达式
    protected AbstractExpression leftExpression;
    // 右表达式
    protected AbstractExpression rightExpression;

    public SymbolExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    // 不同种类的运算符由不同的运算符子类进行解析，所以该类不实现interpreter方法。
    @Override
    public int interpreter(Map<String, Integer> map) {
        return 0;
    }
}
