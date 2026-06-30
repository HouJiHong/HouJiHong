package com.HJh.test.oop.shejisixiang.jianzaozhe;

//Builder 模式 = 必填参数强制化 + 可选参数链式化 + 对象创建不可变化 + 校验逻辑集中化

// 1. 产品类
public class Computer {
    // 必填参数
    private final String cpu;
    private final String ram;
    
    // 可选参数
    private final String gpu;
    private final String storage;
    private final boolean hasBluetooth;

    // 私有构造函数，防止外部直接 new
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.gpu = builder.gpu;
        this.storage = builder.storage;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // 2. 静态内部类作为建造者
    public static class ComputerBuilder {
        // 必填参数在 Builder 中也要声明
        private final String cpu;
        private final String ram;
        
        // 可选参数设置默认值
        private String gpu = "集成显卡";
        private String storage = "512GB SSD";
        private boolean hasBluetooth = false;

        // 必填参数通过构造函数传入，保证不为空
        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // 可选参数通过链式调用设置，返回 Builder 自身
        public ComputerBuilder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder hasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // 最终构建对象
        public Computer build1() {
            return new Computer(this);
        }

        public Computer build() {
            // 1. 参数校验
            if (cpu == null || cpu.isEmpty()) {
                throw new IllegalArgumentException("CPU cannot be null or empty");
            }
            if (ram == null || ram.isEmpty()) {
                throw new IllegalArgumentException("RAM cannot be null or empty");
            }

            // 2. 防御性拷贝（如果属性是可变对象，如 List/Date）
            // 例如：this.tags = new ArrayList<>(builder.tags);

            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{cpu='" + cpu + "', ram='" + ram + "', gpu='" + gpu + 
               "', storage='" + storage + "', bluetooth=" + hasBluetooth + "}";
    }
}


class Main {
    public static void main(String[] args) {
        Computer pc = new Computer.ComputerBuilder("Intel i9", "32GB")
                .gpu("RTX 4090")
                .storage("2TB NVMe")
                .hasBluetooth(true)
                .build();
        
        System.out.println(pc);
    }
}


