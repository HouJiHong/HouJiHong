package com.HJh.test.oop.exceptionyongfa.lianxi;

/**
 * 自定义业务异常
 * 继承 RuntimeException，属于非受检异常，不需要在方法签名中强制声明
 */
public class BusinessException extends RuntimeException {
    
    // 错误码
    private final int code;

    /**
     * 构造方法：只传错误信息
     */
    public BusinessException(String message) {
        super(message);
        this.code = 500; // 默认错误码
    }

    /**
     * 构造方法：传错误码和错误信息
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造方法：支持传递原始异常（保留异常链）
     */
    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}