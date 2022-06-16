package Algorithm;

import java.util.*;

/**
 * Author: icebigpig
 * Data: 2022/6/14 15:27
 * Version 1.0
 *
 * 完成将一个中缀表达式转成后缀表达式的功能
 * 说明：
 *  1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
 *  2. 因为直接对str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的List
 *  即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
 *  3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
 *  即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
 **/
public class PolandNotation {

    /**
     * 方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈
        // 说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        // Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> s2 = new ArrayList<>(); // 储存中间结果的Lists2

        System.out.println(ls);

        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，加入s2
            if (item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) {
                s2.add(item);
            } // 如果s1为空,则直接将此运算符入栈；
            else if (s1.size() == 0) {
                s1.push(item);
            } // 如果是左括号“(”，则直接压入s1
            else if (item.equals("(")) {
                s1.push(item);
                // 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();// !!! 将 ( 弹出 s1栈， 消除小括号
            } //栈顶运算符为左括号“(”，则直接将此运算符入栈；
            else if (s1.peek().equals("(")) {
                s1.push(item);
            } else {
                // 当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较				// 问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                // 还需要将item压入栈
                s1.push(item);
            }
        }

        // 将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; // 注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
    }

    /**
     * 将中缀表达式转成对应的List
     * s="1+((2+3)×4)-5";
     */
    public static List<String> toInfixExpressionList(String s) {
        // 定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0; // 这时是一个指针，用于遍历 中缀表达式字符串
        StringBuilder str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            // 如果c是一个非数字，我需要加入到ls
            if (((s.charAt(i)) < 48 || (s.charAt(i)) > 57) & (c=s.charAt(i)) != '.') {
                ls.add("" + c);
                i++; // i需要后移
            } else { // 需要考虑多位数，如果是一个数或者小数点，则进行追加
                str = new StringBuilder(); // 先将str 置成"" '0'[48]->'9'[57]
                while (i < s.length() && ((s.charAt(i) >= 48 && (s.charAt(i)) <= 57) || s.charAt(i) == '.')) {
                    str.append(s.charAt(i));// 拼接
                    i++;
                }
                ls.add(str.toString());
            }
        } while (i < s.length());
        return ls;
    }

    /**
     * 将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
     */
    public static List<String> getListString(String suffixExpression) {
        // 将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }

    /**
     * 完成对逆波兰表达式的运算
     * 1)从左至右扫描，将3和4压入堆栈；
     * 2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3)将5入栈；
     * 4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5)将6入栈；
     * 6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static double calculate(List<String> ls) {
        // 创建栈, 只需要一个栈即可
        Stack<String> stack = new Stack<>();
        // 遍历 ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double res;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                // 把res 入栈
                stack.push("" + res);
            }
        }
        // 最后留在stack中的数据是运算结果
        return Double.parseDouble(stack.pop());
    }
}