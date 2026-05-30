package com.HJh.test.oop.reflection.reflectionframe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrame {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("src/com/HJh/test/oop/reflection/reflectionframe/save.txt", true));
        Class c1 = obj.getClass();
        String className = c1.getSimpleName();
        ps.println("=============="+className+"==============");
        Field[] fields = c1.getDeclaredFields();
        for (Field f:fields) {
            String fieldName = f.getName();
            f.setAccessible(true);
            Object fieldValue = f.get(obj);
            ps.println(fieldName+"="+fieldValue);
        }
        ps.close();


    }
}
