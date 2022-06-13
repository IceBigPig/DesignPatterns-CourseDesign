package Counter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Author: icebigpig
 * Data: 2022/6/13 8:45
 * Version 1.0
 **/

public class MyFirstGUI extends JFrame{
    private static final long serialVersionUID = 1L;
    private JButton button;
    private JPanel jPanel;
    private JLabel addLabel,eqsLabel;
    private JTextField f1,f2,f3;

    public MyFirstGUI() {
        setTitle("MY-GUI");
        //设置位置和宽高
        setBounds(40, 40, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        setVisible(true);
    }

    private void initComponent(){

        //初始化组件
        jPanel = new JPanel();

        button = new JButton("求和");
        addLabel = new JLabel("+");
        eqsLabel = new JLabel("=");

        //创建文本输入框对象,并设置长度为5
        f1 = new JTextField(5);
        f2 = new JTextField(5);
        f3 = new JTextField(5);

        //设置容器的布局管理器并添加组件
        jPanel.setLayout(new FlowLayout());

        jPanel.add(f1);
        jPanel.add(addLabel);
        jPanel.add(f2);
        jPanel.add(eqsLabel);
        jPanel.add(f3);
        jPanel.add(button);

        this.add(jPanel);

        //给指定的组件添加事件监听
        button.addActionListener(new ActionListener(){
            //当鼠标点击这个指定按钮的时候程序就会调用这个方法
            @Override
            public void actionPerformed(ActionEvent e) {
                //拿到第一个输入框中的数组(String转换为Double)
                double a =Double.parseDouble(f1.getText());

                //拿到第二个输入框中的数组(String转换为Double)
                double b = Double.parseDouble(f2.getText());

                //相加得到结果
                double c = a+b;
                //把结果放到第三个输入框中
                f3.setText(c+"");
            }
        });
    }

    public static void main(String[] args) {
        new MyFirstGUI();
    }

}
