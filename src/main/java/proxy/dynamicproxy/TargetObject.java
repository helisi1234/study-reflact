package proxy.dynamicproxy;

public class TargetObject implements TargetInterface{
    public int add(int a, int b) {
        return a + b;
    }
}
