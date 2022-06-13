package InterpreterPattern;

import java.util.Map;

/**
 * Author: icebigpig
 * Data: 2022/6/13 9:29
 * Version 1.0
 **/
public class AddExpression extends SymbolExpression {

    public AddExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    // 解释加法
    @Override
    public int interpreter(Map<String, Integer> map) {
        return leftExpression.interpreter(map) + rightExpression.interpreter(map);
    }
}
