package proxy.staticproxy;

public class ProxyObject {

    public TargetObject targetObject;

    public ProxyObject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    public int addEnhance(int a, int b) {
        System.out.println("函数增强");
        return targetObject.add(a, b);
    }
}
