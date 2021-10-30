package Calculator;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Calculator {
    JFrame frame;// 顶层容器
    Container contentPane;// 中间容器
    static StringBuffer buffer = new StringBuffer();// 存储输入字符

    // 构造方法
    public Calculator() throws IOException {
        frame = new JFrame("计算器");
        contentPane = frame.getContentPane();
        contentPane.setBackground(Color.black);
        // 事件进行
        FileHandle.clearFile(FileHandle.fileName);// 每次启动，文档清空
        addComponent(contentPane);
        // 容器设置
        frame.setBackground(Color.BLACK);
        frame.setSize(363, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 设置组件
    public static void addComponent(Container contentPane) {
        contentPane.setLayout(new GridBagLayout());// 设置布局
        GridBagConstraints c = new GridBagConstraints();// 设置样式
        c.fill = GridBagConstraints.BOTH;// 全填充
        // 定义组件
        JLabel process = new JLabel("PROCESS");// 展示计算过程
        JLabel result = new JLabel("RESULT");// 展示结果
        JButton clear = new JButton("AC");// 全部清空
        JButton delete = new JButton("C");// 删除一个
        JComboBox<String> history = new JComboBox<String>();// 历史记录
        JButton equal = new JButton("=");// 等于
        JButton add = new JButton("+");// 加
        JButton subtract = new JButton("-");// 减
        JButton multiply = new JButton("x");// 乘
        JButton divide = new JButton("/");// 除
        JButton point = new JButton(".");// 小数点
        JButton num0 = new JButton("0");// 0
        JButton num1 = new JButton("1");// 1
        JButton num2 = new JButton("2");// 2
        JButton num3 = new JButton("3");// 3
        JButton num4 = new JButton("4");// 4
        JButton num5 = new JButton("5");// 5
        JButton num6 = new JButton("6");// 6
        JButton num7 = new JButton("7");// 7
        JButton num8 = new JButton("8");// 8
        JButton num9 = new JButton("9");// 9

        // 设置样式
        CalculatorStyle.setLable(process, CalculatorStyle.font, Color.white, Color.black);
        CalculatorStyle.setLable(result, CalculatorStyle.font, Color.white, Color.black);// 标签
        CalculatorStyle.setButton(equal, CalculatorStyle.fontButton, Color.white, CalculatorStyle.operator);
        CalculatorStyle.setButton(add, CalculatorStyle.fontButton, Color.white, CalculatorStyle.operator);
        CalculatorStyle.setButton(subtract, CalculatorStyle.fontButton, Color.white, CalculatorStyle.operator);
        CalculatorStyle.setButton(multiply, CalculatorStyle.fontButton, Color.white, CalculatorStyle.operator);
        CalculatorStyle.setButton(divide, CalculatorStyle.fontButton, Color.white, CalculatorStyle.operator);// 加减乘除等
                                                                                                             // 五运算符
        CalculatorStyle.setButton(clear, CalculatorStyle.fontButton, Color.black, CalculatorStyle.tool);
        CalculatorStyle.setButton(delete, CalculatorStyle.fontButton, Color.black, CalculatorStyle.tool);
        CalculatorStyle.setComboBox(history, CalculatorStyle.fontButton, Color.white, Color.black);// AC C 历史 三功能键
        CalculatorStyle.setButton(num0, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num1, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num2, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num3, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num4, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num5, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num6, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num7, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num8, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(num9, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);
        CalculatorStyle.setButton(point, CalculatorStyle.fontButton, Color.white, CalculatorStyle.number);// 数字0-9和小数点

        // 添加组件
        CalculatorStyle.gridSet(c, 0, 0, 4, 1);// 第一行 1个组件
        contentPane.add(history, c);
        CalculatorStyle.gridSet(c, 0, 1, 2, 1);// 第二行 2个组件
        contentPane.add(process, c);
        CalculatorStyle.gridSet(c, 2, 1, 2, 1);
        contentPane.add(result, c);
        CalculatorStyle.gridSet(c, 0, 2, 2, 1);// 第三行 3个组件
        contentPane.add(clear, c);
        CalculatorStyle.gridSet(c, 2, 2, 1, 1);
        contentPane.add(delete, c);
        CalculatorStyle.gridSet(c, 3, 2, 1, 1);
        contentPane.add(equal, c);
        CalculatorStyle.gridSet(c, 0, 3, 1, 1);// 第四行 4个组件
        contentPane.add(num7, c);
        CalculatorStyle.gridSet(c, 1, 3, 1, 1);
        contentPane.add(num8, c);
        CalculatorStyle.gridSet(c, 2, 3, 1, 1);
        contentPane.add(num9, c);
        CalculatorStyle.gridSet(c, 3, 3, 1, 1);
        contentPane.add(add, c);
        CalculatorStyle.gridSet(c, 0, 4, 1, 1);// 第五行 4个组件
        contentPane.add(num4, c);
        CalculatorStyle.gridSet(c, 1, 4, 1, 1);
        contentPane.add(num5, c);
        CalculatorStyle.gridSet(c, 2, 4, 1, 1);
        contentPane.add(num6, c);
        CalculatorStyle.gridSet(c, 3, 4, 1, 1);
        contentPane.add(subtract, c);
        CalculatorStyle.gridSet(c, 0, 5, 1, 1);// 第六行 4个组件
        contentPane.add(num1, c);
        CalculatorStyle.gridSet(c, 1, 5, 1, 1);
        contentPane.add(num2, c);
        CalculatorStyle.gridSet(c, 2, 5, 1, 1);
        contentPane.add(num3, c);
        CalculatorStyle.gridSet(c, 3, 5, 1, 1);
        contentPane.add(multiply, c);
        CalculatorStyle.gridSet(c, 0, 6, 2, 1);// 第七行 3个组件
        contentPane.add(num0, c);
        CalculatorStyle.gridSet(c, 2, 6, 1, 1);
        contentPane.add(point, c);
        CalculatorStyle.gridSet(c, 3, 6, 1, 1);
        contentPane.add(divide, c);

        // 绑定事件
        CalculatorBind.bindOperateButton(add, process, "+");
        CalculatorBind.bindOperateButton(subtract, process, "-");
        CalculatorBind.bindOperateButton(multiply, process, "*");
        CalculatorBind.bindOperateButton(divide, process, "/");
        CalculatorBind.bindEqualButton(equal, result, history);// 加减乘除等 五运算符
        CalculatorBind.bindACButton(clear, process, result);// 清空AC
        CalculatorBind.bindCButton(delete, process, result);// 刪除C
        CalculatorBind.bindButton(num0, process, "0");
        CalculatorBind.bindButton(num1, process, "1");
        CalculatorBind.bindButton(num2, process, "2");
        CalculatorBind.bindButton(num3, process, "3");
        CalculatorBind.bindButton(num4, process, "4");
        CalculatorBind.bindButton(num5, process, "5");
        CalculatorBind.bindButton(num6, process, "6");
        CalculatorBind.bindButton(num7, process, "7");
        CalculatorBind.bindButton(num8, process, "8");
        CalculatorBind.bindButton(num9, process, "9");
        CalculatorBind.bindButton(point, process, ".");// 数字0-9和小数点
    }

    // 主函数 运行计算器
    public static void main(String args[]) throws IOException {
        Calculator caculator = new Calculator();
        caculator.toString();// 无实际意义，消除编译器警告
    }
}
