package Adapter;

import Algorithm.PolandNotation;
import InterpreterPattern.Context;
import InterpreterPattern.Expression;

import java.util.List;

/**
 * Author: icebigpig
 * Data: 2022/6/16 19:58
 * Version 1.0
 **/
public class OperationAdapter implements CounterOperation{

    @Override
    public double getResult(String inputString) {
        Context context = new Context();

        // 对输入的表达式进行重新编码
        List<String> infixExpressionList = PolandNotation.toInfixExpressionList(inputString);
        List<String> suffixExpressionList = PolandNotation.parseSuffixExpressionList(infixExpressionList);
        // 构建语法树
        Expression build = Context.build(suffixExpressionList);
//        System.out.printf("expression=%f\n", PolandNotation.calculate(suffixExpressionList));

        // 输出到控制台查看运算结果
        System.out.println(suffixExpressionList + "=" + build.interpreter(context));

        return build.interpreter(context);
    }
}
