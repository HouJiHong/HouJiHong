package com.HJh.test.oop.zhujie;
//注解本质上就是接口，注解的属性是接口的抽象方法

//自定义注解
//public @interface 注解名称｛
//  public 属性类型 属性名() default默认值;
//}

//特殊属性名：value
//如果注解中只有一个value属性，使用注解时，value名称可以不写

@MyAnno("HJh")
//@MyAnno(value = "123",name="HJh",address = {"北京","上海"})
public class test {
    public static void main(String[] args) {

    }
}
