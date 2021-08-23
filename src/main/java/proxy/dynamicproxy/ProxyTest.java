package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        TargetObject targetObject = new TargetObject();
        TargetInterface targetProxy = (TargetInterface) getProxy(targetObject);
        System.out.println(targetProxy.add(1, 2));
    }

    private static Object getProxy(final Object target) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理函数增强");
                        Object result = method.invoke(target, args);
                        return result;
                    }
                }
        );
        return proxy;
    }
}
