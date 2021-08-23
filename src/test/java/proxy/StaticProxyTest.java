package proxy;

import org.junit.Test;
import proxy.staticproxy.ProxyObject;
import proxy.staticproxy.TargetObject;

public class StaticProxyTest {
    @Test
    public void test() {
        ProxyObject proxyObject = new ProxyObject(new TargetObject());
        System.out.println(proxyObject.addEnhance(1, 2));
    }
}
