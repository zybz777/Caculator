package Calculator;

import java.awt.*;
import javax.swing.*;

public class CalculatorStyle {
    static Font font = new Font("Dialog", 0, 15);// 标签字体
    static Font fontButton = new Font("Dialog", 0, 13);// 按钮字体
    static Color number = new Color(51, 51, 51);// 数字按钮颜色
    static Color operator = new Color(241, 163, 59);// 运算符按钮颜色
    static Color tool = new Color(165, 165, 165);// 工具端按钮颜色
    // 布局
    public static void gridSet(GridBagConstraints c, int x, int y, int width, int height) {
        c.fill = GridBagConstraints.BOTH;// 全填充
        c.weightx = 1; // 组件自动填充
        c.weighty = 1; // 组件自动填充
        c.insets = new Insets(10, 10, 10, 10);// 设置边距
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
    }

     // 按钮样式
     public static void setButton(JButton button, Font font, Color fontColor, Color backgroundColor) {
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFocusPainted(false);// 去除文字边框，不要焦点
        button.setFont(font);
        button.setForeground(fontColor);
        button.setBackground(backgroundColor);
    }

    // 复选框样式
    public static void setComboBox(JComboBox<String> box, Font font, Color fontColor, Color backgroundColor) {
        box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        box.setFont(font);
        box.setForeground(fontColor);
        box.setBackground(backgroundColor);
        box.addItem("HISTORY");
        box.setFocusable(false);
        box.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                setBackground(Color.BLACK);
                setForeground(Color.WHITE);
                super.paint(g);
            }
        });
    }

    // 标签样式
    public static void setLable(JLabel label, Font font, Color fontColor, Color backgroundColor) {
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(font);
        label.setForeground(fontColor);
        label.setBackground(backgroundColor);
    }
}
