package Version2;

/**
 * Author: icebigpig
 * Data: 2022/6/13 22:58
 * Version 1.0
 **/

public interface Expression {

    /**
     * 抽象解释方法
     */
    double interpreter(Context context);
}
