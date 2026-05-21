package com.HJh.test.oop.guiyongfa.jisuanqi.UI;

import com.HJh.test.oop.guiyongfa.jisuanqi.bean.CalculatorButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JiSuanQi extends JFrame {
    /**
     * 实现内容：
     * 创建一个计算器界面，从上到下描述为：计算机标题（占一行），显示输入框和计算结果（占一行），
     * 下面是4*4的按钮，第一行按钮内容为：7 8 9 /，第二行：4 5 6 *，第三行：1 2 3 -，第四行：0 = C +，其中C为清空按钮。
     * 要求每一个按钮都是一个枚举类，并且实现点击按钮后的功能。
     */
    private JTextField displayField;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewNumber = true;

    // 创建一个计算器界面
    public JiSuanQi() {
        this.setTitle("计算机");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//禁止改变大小
        init();


    }

    private void init() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 标题
        JLabel titleLabel = new JLabel("计算器", JLabel.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // 显示面板
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setFont(new Font("微软雅黑", Font.PLAIN, 28));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(Color.WHITE);
        displayField.setText("0");

        displayPanel.add(displayField, BorderLayout.CENTER);
        mainPanel.add(displayPanel, BorderLayout.CENTER);

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        CalculatorButton[] buttons = {
                CalculatorButton.BTN_7, CalculatorButton.BTN_8, CalculatorButton.BTN_9, CalculatorButton.BTN_DIVIDE,
                CalculatorButton.BTN_4, CalculatorButton.BTN_5, CalculatorButton.BTN_6, CalculatorButton.BTN_MULTIPLY,
                CalculatorButton.BTN_1, CalculatorButton.BTN_2, CalculatorButton.BTN_3, CalculatorButton.BTN_MINUS,
                CalculatorButton.BTN_0, CalculatorButton.BTN_EQUAL, CalculatorButton.BTN_CLEAR, CalculatorButton.BTN_PLUS
        };

        for (CalculatorButton btn : buttons) {
            JButton button = new JButton(btn.getText());
            button.setFont(new Font("微软雅黑", Font.BOLD, 24));
            button.addActionListener(new ButtonClickListener(btn));
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    private class ButtonClickListener implements ActionListener {
        private final CalculatorButton button;

        public ButtonClickListener(CalculatorButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = button.getText();

            if (text.equals("C")) {
                // 清空
                clear();
            } else if (text.equals("=")) {
                // 计算结果
                calculate();
            } else if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
                // 运算符
                setOperator(text);
            } else {
                // 数字
                inputNumber(text);
            }
        }
    }

    private void inputNumber(String number) {
        if (isNewNumber) {
            currentInput = number;
            isNewNumber = false;
        } else {
            currentInput += number;
        }
        displayField.setText(currentInput);
    }

    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            operator = op;
            isNewNumber = true;
        }
    }

    private void calculate() {
        double result = 0;
        if (!operator.isEmpty() && !currentInput.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        displayField.setText("错误");
                        clear();
                        return;
                    }
                    break;
            }
        }
        // 格式化结果
        if (result == (long) result) {
            displayField.setText(String.valueOf((long) result));
        } else {
            displayField.setText(String.valueOf(result));
        }

        currentInput = String.valueOf(result);
        operator = "";
        isNewNumber = true;
    }
    private void clear() {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        isNewNumber = true;
        displayField.setText("0");
    }


}




