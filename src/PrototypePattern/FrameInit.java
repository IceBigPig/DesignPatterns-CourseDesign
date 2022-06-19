package PrototypePattern;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * Author: icebigpig
 * Data: 2022/6/19 12:07
 * Version 1.0
 **/

public class FrameInit {
    private Frame f;

    private static CounterUI counterUI;

    public FrameInit() {
        init();
    }

    public void init() {
        f = new Frame("myFrame");
        f.setBounds(1000, 500, 300, 400);
        f.setLayout(new FlowLayout());
        Button but = new Button("Clone");
        myEvent();
        f.add(but);
        f.setVisible(true);
        but.addActionListener(e -> {
            System.out.println("创建新窗体");
            CounterUI newCounter = (CounterUI)counterUI.clone();
            newCounter.createFrame();
        });
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            public void windowOpened(WindowEvent e) {
                System.out.println("启动初始化窗体");
                counterUI = new CounterUI();
                counterUI.createFrame();
            }
        });
    }
}
