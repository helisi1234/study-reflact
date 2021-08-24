package reflactannotation.useannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReadMyAnnotation {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class clazz = UserMyAnnotation.class;

        MyAnnotation annotation = (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.getValue());

        Field name = clazz.getField("name");
        MyAnnotation annotation1 = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotation1.getValue());

        Method testMethod = clazz.getMethod("testMethod");
        MyAnnotation annotation2 = testMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotation2.getValue());

        Method testDefaultMethod = clazz.getMethod("testDefaultMethod");
        MyAnnotation annotation3 = testDefaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotation3.getValue());
    }
}
