package Version2;

import java.util.List;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:59
 * Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
//        TerminalExpression a = enw TerminalExpression("a");
//        TerminalExpression b = new TerminalExpression("b");
//        TerminalExpression c = new TerminalExpression("c");
//        String str = "9+3*3+1";


        String expression = "1-6+((2+3)*64)-5";// 注意表达式

        List<String> infixExpressionList = PolandNotation.toInfixExpressionList(expression);
        System.out.println("中缀" +
                "表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = PolandNotation.parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); // ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.printf("expression=%d\n", PolandNotation.calculate(suffixExpreesionList)); // ?

        Expression build = Context.build(suffixExpreesionList);

        System.out.println(suffixExpreesionList + "=" + build.interpreter(context));
//        context.add(a, 4);
//        context.add(b, 8);
//        context.add(c, 2);
//        System.out.println(new MinusOperation(new PlusOperation(a,b), c).interpreter(context));
    }
}
