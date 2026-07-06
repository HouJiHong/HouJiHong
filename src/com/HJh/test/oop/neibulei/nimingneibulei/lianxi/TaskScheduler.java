package com.HJh.test.oop.neibulei.nimingneibulei.lianxi;

public class TaskScheduler {

    // 1. 定义一个普通类
    static class BaseTask {
        protected String name;
        public BaseTask(String name) {
            this.name = name;
        }
        public void execute() {
            System.out.println("执行基础任务: " + name);
        }
    }

    // 2. 定义一个函数式接口
    @FunctionalInterface
    interface TaskCallback {
        void onComplete(String taskName);
    }

    // 3. 定义一个普通接口（非函数式，不能用Lambda）
    interface TaskValidator {
        boolean validate(String taskName);
        void logError(String msg); // 多个方法，必须用匿名内部类
    }

    public void run() {
        String systemUser = "Admin"; // effectively final 变量

        // ==========================================
        // 场景 A: 匿名内部类【继承普通类】
        // ==========================================
        BaseTask customTask = new BaseTask("数据备份") {
            // 匿名内部类可以有自己的初始化块
            {
                System.out.println("[初始化块] 正在为 " + systemUser + " 准备任务...");
            }

            @Override
            public void execute() {
                System.out.println("[重写方法] 正在执行高级备份任务...");
            }
        };
        customTask.execute();

        // ==========================================
        // 场景 B: 匿名内部类【实现非函数式接口】
        // 因为 TaskValidator 有两个方法，所以【不能】用 Lambda
        // ==========================================
        TaskValidator validator = new TaskValidator() {
            @Override
            public boolean validate(String taskName) {
                return taskName != null && !taskName.isEmpty();
            }

            @Override
            public void logError(String msg) {
                System.err.println("[错误日志] " + msg);
            }
        };

        // ==========================================
        // 场景 C: 匿名内部类【实现函数式接口】(传统写法)
        // ==========================================
        TaskCallback callbackOld = new TaskCallback() {
            @Override
            public void onComplete(String taskName) {
                System.out.println("[传统匿名类] 任务 " + taskName + " 已完成，由 " + systemUser + " 确认。");
            }
        };

        // ==========================================
        // 场景 D: Lambda 表达式【实现函数式接口】(现代写法)
        // ==========================================
        TaskCallback callbackNew = taskName -> 
            System.out.println("[Lambda] 任务 " + taskName + " 已完成，由 " + systemUser + " 确认。");

        // ==========================================
        // 综合调用
        // ==========================================
        String taskName = "日志清理";
        if (validator.validate(taskName)) {
            customTask.execute();
            callbackOld.onComplete(taskName);
            callbackNew.onComplete(taskName);
        } else {
            validator.logError("任务名不合法！");
        }
    }

    public static void main(String[] args) {
        new TaskScheduler().run();
    }
}