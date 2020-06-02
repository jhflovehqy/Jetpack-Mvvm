package com.bis.accessibility.ui.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AutoWiredProcess {

    public static void bind(Object object) {
        Class parentClass = object.getClass();
        Field[] fields = parentClass.getDeclaredFields();
        for (Field field : fields) {
            AutoWired autoWired = field.getAnnotation(AutoWired.class);
            if (autoWired != null) {
                field.setAccessible(true);
                Class<?> autoClass = field.getType();
                try {
                    Constructor autoConstructor = autoClass.getConstructor();
                    try {
                        field.set(object, autoConstructor.newInstance());
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
