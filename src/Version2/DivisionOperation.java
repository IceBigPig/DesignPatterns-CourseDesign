package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/14 10:03
 * Version 1.0
 **/
public class DivisionOperation extends NonTerminalExpression {

    public DivisionOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * 将两个表达式相除
     */
    @Override
    public int interpreter(Context context) {
        return this.e1.interpreter(context) / this.e2.interpreter(context);
    }
}

