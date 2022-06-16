package Adapter;

/**
 * Author: icebigpig
 * Data: 2022/6/16 19:55
 * Version 1.0
 * 适配器抽象方法接口
 **/
public interface CounterOperation {

    /**
     * 通过字符穿计算数学表达式结果
     */
    double getResult(String inputString);

}
