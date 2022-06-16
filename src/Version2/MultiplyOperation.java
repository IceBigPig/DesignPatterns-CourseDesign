package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/14 10:01
 * Version 1.0
 **/

public class MultiplyOperation extends NonTerminalExpression {


    public MultiplyOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * 将两个表达式相乘
     */
    @Override
    public double interpreter(Context context) {
        return this.e1.interpreter(context) * this.e2.interpreter(context);
    }

}
