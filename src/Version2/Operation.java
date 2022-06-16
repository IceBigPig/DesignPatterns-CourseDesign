package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/14 15:31
 * Version 1.0
 * 可以返回一个运算符 对应的优先级
 **/

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    /**
     * 返回对应的优先级数字
     */
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }
}
