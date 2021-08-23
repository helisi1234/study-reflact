package reflactbasic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflactTest {

    @Test
//    使用反射获取方法
    public void testReflactMethod() throws NoSuchMethodException {
        Class userClass = User.class;
        Method[] publicMethods = userClass.getMethods();
        /*获取相关权限方法的集合*/
//        类本身的public和Object类public方法
        for (Method method : publicMethods) {
            System.out.println("public method:" + method.toString());
        }
//        类的所有权限方法
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("all method:" + method.toString());
        }

        /*获取特定方法*/
        Method setName = userClass.getMethod("setName", String.class);
        System.out.println(setName.toString());

        Method testPrivateMethod = userClass.getDeclaredMethod("testPrivateMethod");
        System.out.println(testPrivateMethod.toString());
    }

    @Test
//    使用反射获取构造方法并创建对象
    public void testReflactConstructAndCreateClass() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class userClass = User.class;
//        获取全部构造方法
        Constructor[] constructors = userClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
//        获取特定构造方法
        Constructor constructor = userClass.getConstructor(String.class, int.class);
        System.out.println(constructor.toString());
//        通过构造函数创建对象
        User user = (User) constructor.newInstance("helisi", 22);
        System.out.println(user);
    }

    @Test
//    通过反射获取变量
    public void testReflactFields() throws NoSuchFieldException {
        Class userClass = User.class;
        Field[] fields = userClass.getFields();
        for (Field f : fields) {
            System.out.println(f.toString());
        }
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.toString());
        }
        System.out.println("==============================");
        Field age = userClass.getField("age");
        System.out.println(age.toString());
        Field name = userClass.getDeclaredField("name");
        System.out.println(name.toString());
    }

    @Test
//    使用反射获取方法注入对象并执行
    public void testReflactImplementMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class userClass = User.class;
        Constructor constructor = userClass.getConstructor(String.class, int.class);
        User user = (User) constructor.newInstance("helisi", 22);
        System.out.println(user);
        Method setName = userClass.getMethod("setName", String.class);
        Method setAge = userClass.getMethod("setAge", int.class);
        setName.invoke(user, "helisi2");
        setAge.invoke(user, 23);
        System.out.println(user);
    }
}
