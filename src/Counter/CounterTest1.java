package Counter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Author: icebigpig
 * Data: 2022/6/13 8:44
 * Version 1.0
 **/
public class CounterTest1 {

    private String button0 = "0";
    private String button1 = "1";
    private String button2 = "2";
    private String button3 = "3";
    private String button4 = "4";
    private String button5 = "5";
    private String button6 = "6";
    private String button7 = "7";
    private String button8 = "8";
    private String button9 = "9";
    private String buttonAdd = "+";
    private String buttonSub = "-";
    private String buttonMul = "*";
    private String buttonDiv = "/";
    private String buttonDot = ".";
    private String buttonEqu = "=";
    private String buttonDel = "清除";

    String name;
    private double result = 0 ;
    private String stringResult = "";
    //设置文本框的大小为30
    TextField textField = new TextField(30);

    public CounterTest1() {

    }

    public CounterTest1 (String name){
        this.name = name;

    }

    //创建页面
    public void createFrame() {

        JFrame jFrame = new JFrame("计算机");
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setSize(500,500);   //大小
        jFrame.setLocation(700,300);		//位置
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//关闭按钮


        //设置按钮7,8,9，+
        JPanel jPanel1 = new JPanel(new GridLayout(1,4,5,5));
        jPanel1.add(ActionButtonInput(button7));
        jPanel1.add(ActionButtonInput(button8));
        jPanel1.add(ActionButtonInput(button9));
        jPanel1.add(ActionButtonInput(buttonAdd));


        //设置按钮4,5,6，-
        JPanel jPanel2 = new JPanel(new GridLayout(1,4,5,5));
        jPanel2.add(ActionButtonInput(button4));
        jPanel2.add(ActionButtonInput(button5));
        jPanel2.add(ActionButtonInput(button6));
        jPanel2.add(ActionButtonInput(buttonSub));

        //设置按钮1,2,3，*
        JPanel jPanel3 = new JPanel(new GridLayout(1,4,5,5));
        jPanel3.add(ActionButtonInput(button1));
        jPanel3.add(ActionButtonInput(button2));
        jPanel3.add(ActionButtonInput(button3));
        jPanel3.add(ActionButtonInput(buttonMul));

        //设置按钮   清除，0，/ =
        JPanel jPanel4 = new JPanel(new GridLayout(1,4,5,5));
        jPanel4.add(ActionButtonInput(buttonDot));
        jPanel4.add(ActionButtonInput(button0));
        jPanel4.add(ActionButtonInput(buttonDiv));
        // 设置等于按钮
        jPanel4.add(ActionButtonEqu(buttonEqu));

        //设置删除按钮为一行一列，5个像素点
        JPanel jPanel5 = new JPanel(new GridLayout(1,1,5,5));
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringResult =stringResult + buttonName;
                //将输入的计算数字在文本框中显示
                textField.setText(stringResult);
                //将输入的计算数字在控制台显示
                System.out.println(stringResult);
            }

        });
        return button;
    }

    //设置等于按钮
    public JButton ActionButtonEqu(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                calculate();
                //将结果显示在文本框
                textField.setText("运算结果是："+Double.toString(result));
                System.out.println("运算结果是："+result);
            }

        });
        return button;
    }


    //计算输入的字符串
    public	double calculate() {

        //得到输入字符串的数字和操作符
        //转义字符相当于+，-，*，/
        String regex0 = "(\\+)|(\\-)|(\\*)|(\\/)";
        //该语句定义一个正则表达式
        String regex1 = "[0-9]+|[0-9]+\\.[0-9]";

        //将输入的字符串按运算符（+，-, * , / ）分割出来  ，剩下数字
        String split1[] = stringResult.split(regex0);
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(split1[i]+"  ");
//		}
        //将运算符分割出来
        String split2[] = stringResult.split(regex1);
//		for(int i=0;i<split2.length;i++) {
//			System.out.println(split2[i]);   // + - * /
//		}

        String str[] = new String[split2.length];

        //格式化split2数组,
        int j = 0;
        for(int i = 0; i < split2.length; ++i) {

            if(split2[i].equals("."));

            else str[j++] = split2[i];
        }

        //计算结果
        double tresult = 0;
        for (int i = 0; i < split1.length; ++i) {
            if (i == 0) {
                //表示将从数组中得到的值转换成Double类型的数据
                tresult = Double.parseDouble(split1[i]);
            }else {
                //判断进行什么操作
                if (str[i].equals("+"))
                    tresult += Double.parseDouble(split1[i]);
                else if (str[i].equals("-"))
                    tresult -= Double.parseDouble(split1[i]);
                else if (str[i].equals("*"))
                    tresult *= Double.parseDouble(split1[i]);
                else if (str[i].equals("/"))
                    tresult /= Double.parseDouble(split1[i]);
                else continue;
            }
        }

        this.result = tresult;
        return result;

    }

    //设置清除按钮监听器
    public JButton DelButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //将结果和文本框内容清除
                result = 0;
                stringResult = "";
                textField.setText(stringResult);
            }
        });
        return button;
    }

    public static void main(String[] args) {

        CounterTest1 test = new CounterTest1();
        test.createFrame();

    }

}

