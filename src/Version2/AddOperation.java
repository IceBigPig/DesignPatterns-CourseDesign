package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:59
 * Version 1.0
 **/

public class AddOperation extends NonTerminalExpression {
    public AddOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * 将两个表达式相加
     */
    @Override
    public double interpreter(Context context) {
        return this.e1.interpreter(context) + this.e2.interpreter(context);
    }
}
