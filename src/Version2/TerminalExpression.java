package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:59
 * Version 1.0
 **/

public class TerminalExpression implements Expression{

    double variable;
    public TerminalExpression(double variable){
        this.variable = variable;
    }
    @Override
    public double interpreter(Context context) {
        return variable;
        //找不到则直接返回（认为输入的就是数字）
    }
}
