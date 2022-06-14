package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:59
 * Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
//        TerminalExpression a = new TerminalExpression("a");
//        TerminalExpression b = new TerminalExpression("b");
//        TerminalExpression c = new TerminalExpression("c");
        String str = "9*3*3+11";
        Expression build = Context.build(str);

        System.out.println(str + "=" + build.interpreter(context));
//        context.add(a, 4);
//        context.add(b, 8);
//        context.add(c, 2);
//        System.out.println(new MinusOperation(new PlusOperation(a,b), c).interpreter(context));
    }
}
