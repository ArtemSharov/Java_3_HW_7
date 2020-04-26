package ru.gb.java_3.hw_7;

import java.lang.reflect.Method;
import java.util.ArrayList;
public class TesterClass {
    public static void start(Object smfClass) throws Exception{


        Method[] methods = smfClass.getClass().getDeclaredMethods();
        ArrayList<Method> al = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : methods) {
        if (o.isAnnotationPresent(Test.class)) {
            al.add(o);
        }
        if (o.isAnnotationPresent(BeforeSuite.class)) {
            if (beforeMethod == null) beforeMethod = o;
            else throw new RuntimeException("Больше одного метода BeforeSuite");
        }
        if (o.isAnnotationPresent(AfterSuite.class)) {
            if (afterMethod == null) afterMethod = o;
            else throw new RuntimeException("Больше одного метода AfterSuite");
        }


    }

            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getAnnotation(Test.class) != null) {
                    if (methods[j].getAnnotation(Test.class).priority() == j) {
                        al.add(methods[j]);
                    }
                }
            }



        if (beforeMethod != null) beforeMethod.invoke(smfClass);
        for (Method o : al) o.invoke(smfClass);
        if (afterMethod != null) afterMethod.invoke(smfClass);
}

    public static void main(String[] args) throws Exception {
        PrintSmf psmf = new PrintSmf();
        start(psmf);
    }
}
