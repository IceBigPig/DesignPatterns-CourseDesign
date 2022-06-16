package Counter;

import Algorithm.PolandNotation;
import Version2.Context;
import Version2.Expression;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Author: icebigpig
 * Data: 2022/6/16 12:50
 * Version 1.0
 **/

public class CounterUI {

    /**
     * 计算结果
     */
    private double result = 0 ;
    private String stringResult = "";
    //设置文本框的大小为30
    TextField textField = new TextField(30);


    //创建页面
    public void createFrame() {

        JFrame jFrame = new JFrame("计算器");
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setSize(350,500);   //大小
        jFrame.setLocation(700,300);		//位置
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//关闭按钮


        //设置按钮7,8,9，+
        JPanel jPanel1 = new JPanel(new GridLayout(1,4,5,5));
        String button7 = "7";
        jPanel1.add(ActionButtonInput(button7));
        String button8 = "8";
        jPanel1.add(ActionButtonInput(button8));
        String button9 = "9";
        jPanel1.add(ActionButtonInput(button9));
        String buttonAdd = "+";
        jPanel1.add(ActionButtonInput(buttonAdd));


        //设置按钮4,5,6，-
        JPanel jPanel2 = new JPanel(new GridLayout(1,4,5,5));
        String button4 = "4";
        jPanel2.add(ActionButtonInput(button4));
        String button5 = "5";
        jPanel2.add(ActionButtonInput(button5));
        String button6 = "6";
        jPanel2.add(ActionButtonInput(button6));
        String buttonSub = "-";
        jPanel2.add(ActionButtonInput(buttonSub));

        //设置按钮1,2,3，*
        JPanel jPanel3 = new JPanel(new GridLayout(1,4,5,5));
        String button1 = "1";
        jPanel3.add(ActionButtonInput(button1));
        String button2 = "2";
        jPanel3.add(ActionButtonInput(button2));
        String button3 = "3";
        jPanel3.add(ActionButtonInput(button3));
        String buttonMul = "*";
        jPanel3.add(ActionButtonInput(buttonMul));

        //设置按钮   清除，0，/ =
        JPanel jPanel4 = new JPanel(new GridLayout(1,4,5,5));
        String buttonDot = ".";
        jPanel4.add(ActionButtonInput(buttonDot));
        String button0 = "0";
        jPanel4.add(ActionButtonInput(button0));
        String buttonDiv = "/";
        jPanel4.add(ActionButtonInput(buttonDiv));
        // 设置等于按钮
        String buttonEqu = "=";
        jPanel4.add(ActionButtonEqu(buttonEqu));

        //设置删除按钮为一行一列，5个像素点
        JPanel jPanel5 = new JPanel(new GridLayout(1,1,5,5));
        String buttonDel = "清除";
        jPanel5.add(DelButton(buttonDel));

        // 创建横向Box布局
        Box box = Box.createVerticalBox();
        //从上到下，将组件添加到box容器中
        box.add(textField);
        box.add(jPanel1);
        box.add(jPanel2);
        box.add(jPanel3);
        box.add(jPanel4);
        box.add(jPanel5);

        //将box布局添加到Frame容器中
        jFrame.setContentPane(box);
        //窗口显示出来
        jFrame.setVisible(true);
    }

    //对于button 的操作
    public JButton ActionButtonInput(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(e -> {
            stringResult =stringResult + buttonName;
            //将输入的计算数字在文本框中显示
            textField.setText(stringResult);
            //将输入的计算数字在控制台显示
            System.out.println(stringResult);
        });
        return button;
    }

    /**
     * 设置等于按钮
     */
    public JButton ActionButtonEqu(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(arg0 -> {

            calculate();
            //将结果显示在文本框
            textField.setText(String.valueOf(result));
            System.out.println("运算结果是："+result);
        });
        return button;
    }

    /**
     * 计算输入的字符串
     */
    public double calculate() {

        Context context = new Context();

        List<String> infixExpressionList = PolandNotation.toInfixExpressionList(stringResult);

        List<String> suffixExpreesionList = PolandNotation.parseSuffixExpreesionList(infixExpressionList);

        System.out.printf("expression=%f\n", PolandNotation.calculate(suffixExpreesionList));

        Expression build = Context.build(suffixExpreesionList);

        System.out.println(suffixExpreesionList + "=" + build.interpreter(context));

        this.result = build.interpreter(context);

        return build.interpreter(context);

    }

    //设置清除按钮监听器
    public JButton DelButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(arg0 -> {
            //将结果和文本框内容清除
            result = 0;
            stringResult = "";
            textField.setText(stringResult);
        });
        return button;
    }

    public static void main(String[] args) {

        CounterUI test = new CounterUI();
        test.createFrame();

    }
}