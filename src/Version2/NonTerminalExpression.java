package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:58
 * Version 1.0
 **/

public abstract class NonTerminalExpression implements Expression {
    Expression e1,e2;
    public NonTerminalExpression(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }
}
