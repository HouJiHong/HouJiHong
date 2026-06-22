package com.HJh.test.oop.streamyongfa.lianxi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexStreamExample {

    // 订单类
    static class Order {
        String orderId;
        String status; // "PAID", "UNPAID", "CANCELED"
        List<Product> products;

        Order(String orderId, String status, List<Product> products) {
            this.orderId = orderId;
            this.status = status;
            this.products = products;
        }
    }

    // 商品类
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        // 1. 准备模拟数据
        List<Order> orders = Arrays.asList(
                new Order("ORD001", "PAID", Arrays.asList(
                        new Product("Laptop", 5999.0),
                        new Product("Mouse", 150.0),
                        new Product("Cable", 20.0)
                )),
                new Order("ORD002", "UNPAID", Arrays.asList(
                        new Product("Keyboard", 300.0),
                        new Product("Mouse", 150.0)
                )),
                new Order("ORD003", "PAID", Arrays.asList(
                        new Product("Monitor", 1200.0),
                        new Product("Mouse", 150.0)
                ))
        );

        // 2. 复杂 Stream 处理链
        List<String> result = orders.stream()
                // 1. 过滤：只保留已支付的订单
                .filter(order -> "PAID".equals(order.status))
                
                // 2. 扁平化：将 Order 流转换为 Product 流
                // flatMap 将每个订单中的商品列表展开，合并成一个大的商品流
                .flatMap(order -> order.products.stream())
                
                // 3. 过滤：只保留价格 > 100 的商品
                .filter(product -> product.price > 100)
                
                // 4. 转换：提取商品名称
                .map(Product::getName)
                
                // 5. 去重
                .distinct()
                
                // 6. 排序 (按字母自然顺序)
                .sorted()
                
                // 7. 收集结果
                .collect(Collectors.toList());

        // 3. 打印结果
        System.out.println("符合条件的商品名称: " + result);
    }
}