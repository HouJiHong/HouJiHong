package com.HJh.test.oop.guiyongfa.jisuanqi.bean;

public enum CalculatorButton {
    BTN_7("7"),
    BTN_8("8"),
    BTN_9("9"),
    BTN_DIVIDE("/"),

    BTN_4("4"),
    BTN_5("5"),
    BTN_6("6"),
    BTN_MULTIPLY("*"),

    BTN_1("1"),
    BTN_2("2"),
    BTN_3("3"),
    BTN_MINUS("-"),

    BTN_0("0"),
    BTN_EQUAL("="),
    BTN_CLEAR("C"),
    BTN_PLUS("+");

    private final String text;

    CalculatorButton(String text) {
        this.text = text;
    }

    public String getText() {//获取按钮的文本
        return text;
    }
}
