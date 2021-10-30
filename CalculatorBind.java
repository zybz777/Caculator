package Calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class CalculatorBind {
    static StringBuffer buffer = Calculator.buffer;// 存储输入字符
    static Font font = CalculatorStyle.font;// 标签字体
    static Font fontButton = CalculatorStyle.fontButton;// 按钮字体
    static Color number = CalculatorStyle.number;// 数字按钮颜色
    static Color operator = CalculatorStyle.operator;// 运算符按钮颜色
    static Color tool = CalculatorStyle.tool;// 工具端按钮颜色

    // 数字0-9和小数点绑定
    public static void bindButton(JButton button, JLabel label, String buttonString) {
        // 鼠标滑过事件
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                CalculatorStyle.setButton(button, fontButton, Color.white, new Color(115, 115, 115));
            }

            public void mouseExited(MouseEvent e) {
                CalculatorStyle.setButton(button, fontButton, Color.white, number);
            }
        });
        // 按钮点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorStyle.setButton(button, fontButton, Color.white, new Color(115, 115, 115));
                Calculator.buffer.append(buttonString);
                label.setText(Calculator.buffer.toString()); // 输入显示在屏幕上
            }
        });
    }

    // 加减乘除运算符绑定
    public static void bindOperateButton(JButton button, JLabel label, String buttonString) {
        // 鼠标滑过事件
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                CalculatorStyle.setButton(button, fontButton, Color.white, new Color(244, 201, 149));
            }

            public void mouseExited(MouseEvent e) {
                CalculatorStyle.setButton(button, fontButton, Color.white, operator);
            }
        });
        // 按钮点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorStyle.setButton(button, fontButton, operator, Color.white);
                Calculator.buffer.append(buttonString);
                label.setText(Calculator.buffer.toString()); // 输入显示在屏幕上
            }
        });
    }

    // 全清空绑定
    public static void bindACButton(JButton clear, JLabel process, JLabel result) {
        // 鼠标滑过事件
        clear.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                CalculatorStyle.setButton(clear, fontButton, Color.black, new Color(217, 217, 217));
            }

            public void mouseExited(MouseEvent e) {
                CalculatorStyle.setButton(clear, fontButton, Color.black, tool);
            }
        });
        // 按钮点击事件
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorStyle.setButton(clear, fontButton, Color.black, new Color(217, 217, 217));
                buffer.delete(0, buffer.toString().length());// 清零输入
                process.setText("PROCESS");
                result.setText("RESULT");
            }
        });
    }

    // 刪除綁定
    public static void bindCButton(JButton delete, JLabel process, JLabel result) {
        // 鼠标滑过事件
        delete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                CalculatorStyle.setButton(delete, fontButton, Color.black, new Color(217, 217, 217));
            }

            public void mouseExited(MouseEvent e) {
                CalculatorStyle.setButton(delete, fontButton, Color.black, tool);
            }
        });
        // 按钮点击事件
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorStyle.setButton(delete, fontButton, Color.black, new Color(217, 217, 217));
                if (!buffer.toString().equals("")) {
                    buffer.deleteCharAt(buffer.toString().length() - 1);
                    process.setText(buffer.toString());
                } else {
                    process.setText("PROCESS");
                }
                result.setText("RESULT");
            }
        });
    }

    // 等号绑定
    public static void bindEqualButton(JButton equal, JLabel result, JComboBox<String> history) {
        // 鼠标滑过事件
        equal.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                CalculatorStyle.setButton(equal, fontButton, Color.white, new Color(244, 201, 149));
            }

            public void mouseExited(MouseEvent e) {
                CalculatorStyle. setButton(equal, fontButton, Color.white, operator);
            }
        });
        // 按钮点击事件
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorStyle. setButton(equal, fontButton, operator, Color.white);
                try {
                    // 检查输入是否合法
                    if (Calculate.checkInput(buffer.toString())) {
                        result.setText(Calculate.answer(buffer.toString()));// 得到结果
                    } else {
                        throw new NumberFormatException();
                    }
                    // 除数为0
                    if (Calculate.answer(buffer.toString()).equals("Infinity")) {
                        throw new OpearteException();
                    }
                    // 后台操作
                    history.addItem(buffer.toString() + "=" + Calculate.answer(buffer.toString()));// 保留历史记录
                    FileHandle.answerSave(buffer.toString(), Calculate.answer(buffer.toString()));// 保存到文件中
                    buffer.delete(0, buffer.toString().length());// 清零输入
                } catch (IOException e1) {// 文档错误
                } catch (NumberFormatException e2) {// 算式不合法
                    result.setText("格式错误");
                } catch (OpearteException e3) {// 除数为0
                    result.setText(e3.toString());
                }
            }
        });
    }
}
