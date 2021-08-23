package proxy.staticproxy;

import java.lang.annotation.Target;

public class TargetObject {

    public TargetObject() {}

    public int add(int a, int b) {
        return a + b;
    }
}
