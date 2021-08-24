package reflactannotation.simplejunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunit {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = UserTest.class;
        Object obj = clazz.newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> beforeMethodList = new ArrayList<Method>();
        List<Method> testMethodList = new ArrayList<Method>();
        List<Method> afterMethodList = new ArrayList<Method>();

        for (Method method : methods) {
//            method.getAnnotation()
            if(method.isAnnotationPresent(MyBefore.class)) {
                beforeMethodList.add(method);
            }else if(method.isAnnotationPresent(MyTest.class)) {
                testMethodList.add(method);
            }else if(method.isAnnotationPresent(MyAfter.class)) {
                afterMethodList.add(method);
            }
        }

        for (Method testMethod : testMethodList) {
            for (Method beforeMethod : beforeMethodList) {
                beforeMethod.invoke(obj);
            }
            testMethod.invoke(obj);
            for (Method afterMethod : afterMethodList) {
                afterMethod.invoke(obj);
            }
        }

    }
}
